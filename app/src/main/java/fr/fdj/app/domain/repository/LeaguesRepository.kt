package fr.fdj.app.domain.repository

import fr.fdj.app.domain.util.Failure
import fr.fdj.app.domain.util.Resource
import fr.fdj.app.domain.model.League

interface LeaguesRepository {
    suspend fun getAllLeagues(): Resource<List<League>, Failure.NetworkError>
}
