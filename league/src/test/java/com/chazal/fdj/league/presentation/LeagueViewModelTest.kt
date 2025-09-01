package com.chazal.fdj.league.presentation

import com.chazal.fdj.league.CoroutineTestRule
import com.chazal.fdj.league.domain.interactor.GetLeaguesUseCase
import com.chazal.fdj.league.dummyLeagueResponse
import com.chazal.fdj.league.dummySuccessState
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LeagueViewModelTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()
    @MockK
    private lateinit var useCase: GetLeaguesUseCase
    private lateinit var viewModel: LeagueViewModel
    private val errorMessage = "test"
    private val error = Exception(errorMessage)

    @Before
    fun setUp() {
        init(this)
        viewModel = LeagueViewModel(useCase)
    }

    @Test
    fun `getLeagues - on Success Receive - should return success state`() = runTest {
        //given
        coEvery { useCase.getLeagues("") } returns dummyLeagueResponse

        //when
        viewModel.getLeagues("")

        //then
        assertEquals(
            (viewModel.uiState.value as LeagueScreenState.Success),
            dummySuccessState
        )
    }

    @Test
    @Throws(Exception::class)
    fun `getLeagues - on Failure Receive - should return failure state`() = runTest {
        //given
        coEvery { useCase.getLeagues("") } throws error

        //when
        viewModel.getLeagues("")

        //then
        assert(viewModel.uiState.value is LeagueScreenState.Error)
    }
}