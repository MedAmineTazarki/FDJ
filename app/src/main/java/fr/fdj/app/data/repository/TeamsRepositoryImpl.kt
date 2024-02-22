package fr.fdj.app.data.repository

import fr.fdj.app.domain.util.Failure
import fr.fdj.app.domain.util.Resource
import fr.fdj.app.data.mappers.toTeamsList
import fr.fdj.app.data.remote.TeamsApi
import fr.fdj.app.domain.model.Team
import fr.fdj.app.domain.repository.TeamsRepository

class TeamsRepositoryImpl(private val api: TeamsApi) : TeamsRepository {

    override suspend fun getTeamsForLeague(leagueName: String): Resource<List<Team>, Failure.NetworkError> {
        return try {
            Resource.Success(api.getTeamsForLeague(leagueName).toTeamsList() ?: emptyList())
        } catch (e: Exception) {
            Resource.Error(Failure.NetworkError(e.message ?: "Unknown error"))
        }
    }
}