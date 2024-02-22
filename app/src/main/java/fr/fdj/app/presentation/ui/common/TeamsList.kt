package fr.fdj.app.presentation.ui.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.fdj.app.domain.model.Team
import fr.fdj.app.presentation.ui.viewmodel.TeamsUIState


@Composable
fun TeamsList(
    state: TeamsUIState,
    teams: List<Team>,
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        columns = GridCells.Fixed(3),
    ) {
        items(teams.size) {
            TeamItem(team = teams[it])
        }
        if (state.isLoading) {
            item {
                ProgressIndicator()
            }
        }
    }
}