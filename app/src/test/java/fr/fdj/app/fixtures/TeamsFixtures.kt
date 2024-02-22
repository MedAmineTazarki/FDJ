package fr.fdj.app.fixtures

import fr.fdj.app.domain.model.Team

object TeamsFixtures {
    val teamsResult = listOf(
        Team(
            id = "1",
            name = "Team 1",
            sport = "",
            league = "",
            nameAlt = "",
            badgeUrl = ""
        ),
        Team(
            id = "2",
            name = "Team 2",
            sport = "",
            league = "",
            nameAlt = "",
            badgeUrl = ""
        ),
        Team(
            id = "3",
            name = "Team 3",
            sport = "",
            league = "",
            nameAlt = "",
            badgeUrl = ""
        )
    )
    val filteredTeams = listOf(
        Team(
            id = "3",
            name = "Team 3",
            sport = "",
            league = "",
            nameAlt = "",
            badgeUrl = ""
        ),
        Team(
            id = "1",
            name = "Team 1",
            sport = "",
            league = "",
            nameAlt = "",
            badgeUrl = ""
        )
    )
}