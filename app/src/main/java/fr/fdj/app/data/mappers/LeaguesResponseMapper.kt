package fr.fdj.app.data.mappers

import fr.fdj.app.data.dto.LeaguesDto
import fr.fdj.app.data.dto.LeaguesDto.ApiLeague
import fr.fdj.app.domain.model.League

fun ApiLeague.toLeague() = League(
    id = id,
    name = name,
    sport = sport,
    nameAlt = nameAlt
)

fun LeaguesDto.toLeaguesList() = leagues.map { it.toLeague() }
