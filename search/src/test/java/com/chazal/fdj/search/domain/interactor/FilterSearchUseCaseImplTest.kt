package com.chazal.fdj.search.domain.interactor

import com.chazal.fdj.search.CoroutineTestRule
import com.chazal.fdj.search.dummyFiltered
import com.chazal.fdj.search.dummySuccessResponse
import com.chazal.fdj.search.dummySuccessState
import io.mockk.MockKAnnotations.init
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FilterSearchUseCaseImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    private lateinit var filterSearchUseCase: FilterSearchUseCase

    @Before
    fun setUp() {
        init(this)
        filterSearchUseCase = FilterSearchUseCaseImpl()
    }

    @Test
    fun `filterSearch - should return filtered list of inpput based on query`() = runTest {
        //given
        val query = "shawa"
        val result = dummySuccessState.content.items

        //when
        filterSearchUseCase.filterSearch(query, result)

        //then
        assertEquals(
            filterSearchUseCase.filterSearch(query, result),
            dummyFiltered.content.items
        )
    }
}