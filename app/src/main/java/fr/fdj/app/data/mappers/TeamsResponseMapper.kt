package fr.fdj.app.data.mappers

import fr.fdj.app.data.dto.TeamsDto
import fr.fdj.app.data.dto.TeamsDto.ApiTeam
import fr.fdj.app.domain.model.Team

fun ApiTeam.toTeam() = Team(
    id = id,
    name = name,
    sport = sport,
    league = league,
    nameAlt = nameAlt,
    badgeUrl = badgeUrl
)

fun TeamsDto.toTeamsList() = teams?.map { it.toTeam() }
