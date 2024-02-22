package fr.fdj.app.data.remote

import fr.fdj.app.data.dto.LeaguesDto
import retrofit2.http.GET

interface LeaguesApi {
    @GET("all_leagues.php")
    suspend fun getLeagues(): LeaguesDto
}