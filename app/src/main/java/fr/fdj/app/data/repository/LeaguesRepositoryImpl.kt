package fr.fdj.app.data.repository

import fr.fdj.app.domain.util.Failure
import fr.fdj.app.domain.util.Resource
import fr.fdj.app.data.mappers.toLeaguesList
import fr.fdj.app.data.remote.LeaguesApi
import fr.fdj.app.domain.model.League
import fr.fdj.app.domain.repository.LeaguesRepository

class LeaguesRepositoryImpl(private val api: LeaguesApi) : LeaguesRepository {

    override suspend fun getAllLeagues(): Resource<List<League>, Failure.NetworkError> {
        return try {
            Resource.Success(api.getLeagues().toLeaguesList())
        } catch (e: Exception) {
            Resource.Error(Failure.NetworkError(e.message ?: "Unknown error"))
        }
    }
}