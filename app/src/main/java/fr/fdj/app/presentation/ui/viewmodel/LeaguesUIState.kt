package fr.fdj.app.presentation.ui.viewmodel

import fr.fdj.app.domain.model.League

data class LeaguesUIState(
    val isLoading: Boolean = false,
    val leagues: List<League>? = null,
    val error: String? = null
)