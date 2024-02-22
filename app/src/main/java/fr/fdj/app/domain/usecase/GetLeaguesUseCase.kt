package fr.fdj.app.domain.usecase

import fr.fdj.app.domain.util.Failure
import fr.fdj.app.domain.util.Resource
import fr.fdj.app.domain.model.League
import fr.fdj.app.domain.repository.LeaguesRepository

class GetLeaguesUseCase(
    private val leaguesRepository: LeaguesRepository
) {

    suspend fun execute(): Resource<List<League>, Failure.NetworkError> {
        return leaguesRepository.getAllLeagues()
    }
}
