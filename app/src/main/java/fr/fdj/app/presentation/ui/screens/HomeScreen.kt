package fr.fdj.app.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.fdj.app.domain.model.League
import fr.fdj.app.domain.model.Team
import fr.fdj.app.presentation.ui.common.ErrorMsg

import fr.fdj.app.presentation.ui.common.ProgressIndicator
import fr.fdj.app.presentation.ui.common.SearchBar
import fr.fdj.app.presentation.ui.viewmodel.HomeViewModel
import fr.fdj.app.presentation.ui.common.TeamsList
import fr.fdj.app.presentation.ui.viewmodel.LeaguesUIState
import fr.fdj.app.presentation.ui.viewmodel.TeamsUIState

@Composable
fun HomeScreen(
    teamsState: TeamsUIState,
    leaguesState: LeaguesUIState,
    fetchTeamsForLeague: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        SearchBar(
            suggestions = leaguesState.leagues?.map(League::name) ?: emptyList(),
            onSelect = { leagueName ->
                // Fetch the teams for the selected league
                fetchTeamsForLeague(leagueName)
            }
        )

        if (teamsState.isLoading || leaguesState.isLoading) {
            // Show a progress indicator
            ProgressIndicator()
        }

        Spacer(modifier = Modifier.weight(1f))

        teamsState.error?.let {
            ErrorMsg(message = it)
        }
        leaguesState.error?.let {
            ErrorMsg(message = it)
        }

        teamsState.teams?.let {
            if (it.isNotEmpty()) {
                // Show the list of teams
                TeamsList(state = teamsState, teams = it)
            } else {
                // Show a message when the list is empty
                ErrorMsg(message = "No teams found")
            }
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenLoadingPreview() {
    HomeScreen(
        teamsState = TeamsUIState(isLoading = true),
        leaguesState = LeaguesUIState(isLoading = true),
        fetchTeamsForLeague = {}
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenErrorPreview() {
    HomeScreen(
        teamsState = TeamsUIState(error = "Error"),
        leaguesState = LeaguesUIState(error = "Error"),
        fetchTeamsForLeague = {}
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenLoadedPreview() {
    HomeScreen(
        teamsState = TeamsUIState(
            isLoading = false,
            teams = emptyList(),
            error = null
        ),
        leaguesState = LeaguesUIState(
            isLoading = false,
            leagues = listOf(
                League(
                    id = "1",
                    name = "League 1",
                    sport = "",
                    nameAlt = "",
                ),
            ),
            error = null
        ),
        fetchTeamsForLeague = {}
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenDataPreview() {
    HomeScreen(
        teamsState = TeamsUIState(
            isLoading = false,
            teams = listOf(
                Team(
                    id = "1",
                    name = "Team 1",
                    sport = "",
                    league = "",
                    nameAlt = "",
                    badgeUrl = "",
                ),
            ),
            error = null
        ),
        leaguesState =LeaguesUIState(
            isLoading = false,
            leagues = emptyList(),
            error = null
        ),
        fetchTeamsForLeague = {}
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenEmptyDataPreview() {
    HomeScreen(
        teamsState = TeamsUIState(
            isLoading = false,
            teams = emptyList(),
            error = null
        ),
        leaguesState = LeaguesUIState(
            isLoading = false,
            leagues = emptyList(),
            error = null
        ),
        fetchTeamsForLeague = {}
    )
}