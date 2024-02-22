package fr.fdj.app.domain.repository

import fr.fdj.app.domain.util.Failure
import fr.fdj.app.domain.util.Resource
import fr.fdj.app.domain.model.Team

interface TeamsRepository {
    suspend fun getTeamsForLeague(leagueName: String): Resource<List<Team>, Failure.NetworkError>
}
