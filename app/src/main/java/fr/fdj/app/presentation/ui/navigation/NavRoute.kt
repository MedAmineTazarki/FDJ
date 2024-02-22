package fr.fdj.app.presentation.ui.navigation

sealed class NavRoute(val route: String) {
    object Teams : NavRoute("teams_screen")
}
