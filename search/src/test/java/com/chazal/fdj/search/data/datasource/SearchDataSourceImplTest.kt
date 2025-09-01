package com.chazal.fdj.search.data.datasource

import com.chazal.fdj.search.CoroutineTestRule
import com.chazal.fdj.search.dummySearchResponse
import com.chazal.fdj.shared.data.search.datasource.SearchDataSource
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchDataSourceImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var searchService: SearchService
    private lateinit var searchDataSource: SearchDataSource
    private val error = Throwable()

    @Before
    fun setUp() {
        init(this)
        searchDataSource = SearchDataSourceImpl(searchService)
    }

    @Test
    fun `search - should return result of search response`() = runTest {
        //Given
        coEvery { searchService.search() } returns Result.success(dummySearchResponse)
        //when
        searchDataSource.getSearchResults()
        //then
        assert(searchDataSource.getSearchResults().isSuccess)
        assertEquals(searchDataSource.getSearchResults().getOrNull(), dummySearchResponse)
    }

    @Test
    fun `search - should return failure if failure response`() = runTest {
        //Given
        coEvery { searchService.search() } returns Result.failure(error)
        //when
        searchDataSource.getSearchResults()
        //then
        assert(searchDataSource.getSearchResults().isFailure)
        assertEquals(searchDataSource.getSearchResults().exceptionOrNull(), error)
    }
}