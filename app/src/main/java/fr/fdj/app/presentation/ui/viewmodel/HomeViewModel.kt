package fr.fdj.app.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.fdj.app.domain.model.League
import fr.fdj.app.domain.model.Team
import fr.fdj.app.domain.usecase.GetLeaguesUseCase
import fr.fdj.app.domain.usecase.GetTeamsUseCase
import fr.fdj.app.domain.util.coFold
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val getLeaguesUseCase: GetLeaguesUseCase,
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModel() {

    private val _leaguesState = MutableStateFlow(LeaguesUIState())
    val leaguesState = _leaguesState.asStateFlow()

    private val _teamsState = MutableStateFlow(TeamsUIState())
    val teamsState = _teamsState.asStateFlow()

    init {
        fetchLeagues()
    }

    private fun fetchLeagues() {
        viewModelScope.launch {
            _leaguesState.update { it.copy(isLoading = true) }

            getLeaguesUseCase.execute().coFold({ leagues ->
                _leaguesState.update {
                    it.copy(
                        leagues = leagues,
                        error = null
                    )
                }
            }, { failure ->
                _leaguesState.update { it.copy(leagues = null, error = failure.message) }
            })

            _leaguesState.update { it.copy(isLoading = false) }
        }
    }

    fun fetchTeamsForLeague(leagueName: String) {
        viewModelScope.launch {
            _teamsState.update { it.copy(isLoading = true) }

            getTeamsUseCase.execute(leagueName).coFold({ teams ->
                _teamsState.update {
                    it.copy(
                        teams = teams,
                        error = null
                    )
                }
            }, { failure ->
                _teamsState.update { it.copy(teams = null, error = failure.message) }
            })

            _teamsState.update { it.copy(isLoading = false) }
        }
    }
}