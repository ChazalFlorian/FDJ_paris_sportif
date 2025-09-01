package com.chazal.fdj.search.data.repository

import com.chazal.fdj.search.CoroutineTestRule
import com.chazal.fdj.search.data.datasource.SearchDataSource
import com.chazal.fdj.search.dummySearchResponse
import com.chazal.fdj.search.dummySearchResultItem
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.jvm.Throws

class SearchRepositoryImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var dataSource: SearchDataSource
    private lateinit var searchRepository: SearchRepository
    private val errorMessage = "test"
    private val error = Exception(errorMessage)

    @Before
    fun setUp() {
        init(this)
        searchRepository = SearchRepositoryRemoteImpl(dataSource)
    }

    @Test
    fun `getSearch - onSuccess - should return Success`() = runTest {
        //given
        coEvery { dataSource.getSearchResults() } returns Result.success(dummySearchResponse)

        //when
        searchRepository.getSearch()

        //then
        assertEquals(
            searchRepository.getSearch(), dummySearchResultItem
        )
    }

    @Test
    @Throws(Exception::class)
    fun `getSearch - onFailure - should throw Exception`() = runTest {
        //given
        coEvery { dataSource.getSearchResults() } throws error

        //when
        runCatching {
            searchRepository.getSearch()
        }.onFailure {
            assertThat("", it is Exception)
        }
    }
}