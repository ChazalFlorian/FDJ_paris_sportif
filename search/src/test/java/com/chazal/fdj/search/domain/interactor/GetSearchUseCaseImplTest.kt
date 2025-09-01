package com.chazal.fdj.search.domain.interactor

import com.chazal.fdj.search.CoroutineTestRule
import com.chazal.fdj.search.data.repository.SearchRepository
import com.chazal.fdj.search.dummySearchResultItem
import com.chazal.fdj.search.dummySuccessResponse
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetSearchUseCaseImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var repository: SearchRepository

    private lateinit var getSearchUseCase: GetSearchUseCaseImpl
    private val errorMessage = "test"
    private val error = Exception(errorMessage)

    @Before
    fun setUp() {
        init(this)
        getSearchUseCase = GetSearchUseCaseImpl(
            repository = repository
        )
    }

    @Test
    fun `getSearch - onSuccess - should return Success`() = runTest {
        //given
        coEvery { repository.getSearch() } returns dummySearchResultItem

        //when
        repository.getSearch()

        //then
        assertEquals(
            getSearchUseCase.getSearchResults(), dummySuccessResponse
        )
    }

    @Test
    @Throws(Exception::class)
    fun `getSearch - onFailure - should return Failure`() = runTest {
        //given
        coEvery { repository.getSearch() } throws error

        //when
        runCatching {
            repository.getSearch()
        }.onFailure {
            assertThat("", it is Exception)
        }
    }
}