package com.chazal.fdj.league.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chazal.fdj.league.domain.interactor.GetLeaguesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LeagueViewModel(
    private val useCase: GetLeaguesUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow<LeagueScreenState>(LeagueScreenState.Loading)
    val uiState: StateFlow<LeagueScreenState>
        get() = _uiState.asStateFlow()

    fun getLeagues(id: String) {
        viewModelScope.launch {
            try {
                _uiState.value = LeagueScreenState.Success(
                    content = useCase.getLeagues(id)
                )
            } catch (e: Exception) {
                _uiState.value = LeagueScreenState.Error(
                    message = e.message ?: ""
                )
            }
        }
    }
}