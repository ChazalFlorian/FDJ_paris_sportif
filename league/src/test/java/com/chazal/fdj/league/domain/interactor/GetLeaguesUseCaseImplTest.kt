package com.chazal.fdj.league.domain.interactor

import com.chazal.fdj.league.CoroutineTestRule
import com.chazal.fdj.league.dummyLeagueResponse
import com.chazal.fdj.league.dummyLeagueResponseSuccess
import com.chazal.fdj.shared.domain.league.repository.LeagueRepository
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetLeaguesUseCaseImplTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var repository: LeagueRepository
    private lateinit var useCase: GetLeaguesUseCase
    private val errorMessage = "test"
    private val error = Exception(errorMessage)

    @Before
    fun setUp() {
        init(this)
        useCase = GetLeaguesUseCaseImpl(repository)
    }

    @Test
    fun `getSearch - onSuccess - should return Success`() = runTest {
        //given
        coEvery { repository.getLeagues("") } returns dummyLeagueResponseSuccess

        //when
        repository.getLeagues("")

        //then
        assertEquals(
            useCase.getLeagues(""), dummyLeagueResponse
        )
    }

    @Test
    @Throws(Exception::class)
    fun `getSearch - onFailure - should return Failure`() = runTest {
        //given
        coEvery { repository.getLeagues("") } throws error

        //when
        runCatching {
            repository.getLeagues("")
        }.onFailure {
            assertThat("", it is Exception)
        }
    }
}