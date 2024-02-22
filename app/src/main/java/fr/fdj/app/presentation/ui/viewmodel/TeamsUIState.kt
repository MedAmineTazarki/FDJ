package fr.fdj.app.presentation.ui.viewmodel

import fr.fdj.app.domain.model.Team

data class TeamsUIState(
    val isLoading: Boolean = false,
    val teams: List<Team>? = null,
    val error: String? = null
)