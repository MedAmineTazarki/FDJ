package fr.fdj.app.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.fdj.app.presentation.ui.screens.HomeScreen
import fr.fdj.app.presentation.ui.viewmodel.HomeViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoute.Teams.route) {
        composable(NavRoute.Teams.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            val leaguesState = viewModel.leaguesState.collectAsState()
            val teamsState = viewModel.teamsState.collectAsState()
            HomeScreen(
                leaguesState = leaguesState.value,
                teamsState = teamsState.value,
                fetchTeamsForLeague = viewModel::fetchTeamsForLeague
            )
        }
    }
}
