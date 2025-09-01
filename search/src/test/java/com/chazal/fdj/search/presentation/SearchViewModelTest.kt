package com.chazal.fdj.search.presentation

import com.chazal.fdj.search.CoroutineTestRule
import com.chazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.chazal.fdj.search.domain.interactor.GetSearchUseCase
import com.chazal.fdj.search.dummySuccessResponse
import com.chazal.fdj.search.dummySuccessState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    private lateinit var getUseCase: GetSearchUseCase

    @MockK
    private lateinit var filterUseCase: FilterSearchUseCase
    private lateinit var viewModel: SearchViewModel

    private val errorMessage = "test"
    private val error = Exception(errorMessage)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    private fun initVM() {
        viewModel = SearchViewModel(getUseCase, filterUseCase)
    }

    @Test
    fun `getSearchResults - on Success Receive - should return success state`() = runTest {
        //given
        coEvery { getUseCase.getSearchResults() } returns dummySuccessResponse

        //when init
        initVM()

        //then
        assertEquals(
            (viewModel.uiState.value as SearchState.Success),
            dummySuccessState
        )
    }

    @Test
    @Throws(Exception::class)
    fun `getSearchResults - on Failure Receive - should return failure state`() = runTest {
        //given
        coEvery { getUseCase.getSearchResults() } throws error

        //when
        initVM()

        //then
        assert(viewModel.uiState.value is SearchState.Error)
    }
}