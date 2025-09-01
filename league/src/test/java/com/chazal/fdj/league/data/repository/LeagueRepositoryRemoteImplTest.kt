package com.chazal.fdj.league.data.repository

import com.chazal.fdj.league.CoroutineTestRule
import com.chazal.fdj.league.data.datasource.LeagueDataSource
import com.chazal.fdj.league.dummyLeagueResponseSuccess
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LeagueRepositoryRemoteImplTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var dataSource: LeagueDataSource
    private lateinit var leagueRepository: LeagueRepository
    private val errorMessage = "test"
    private val error = Exception(errorMessage)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        leagueRepository = LeagueRepositoryRemoteImpl(dataSource)
    }

    @Test
    fun `getSearch - onSuccess - should return Success`() = runTest {
        //given
        coEvery { dataSource.getLeagues("") } returns Result.success(dummyLeagueResponseSuccess)

        //when
        leagueRepository.getLeagues("")

        //then
        assertEquals(
            leagueRepository.getLeagues(""), dummyLeagueResponseSuccess
        )
    }

    @Test
    @Throws(Exception::class)
    fun `getSearch - onFailure - should return Exception`() = runTest {
        //given
        coEvery { dataSource.getLeagues("") } throws error

        //when
        runCatching {
            leagueRepository.getLeagues("")
        }.onFailure {
            assertThat("", it is Exception)
        }
    }
}