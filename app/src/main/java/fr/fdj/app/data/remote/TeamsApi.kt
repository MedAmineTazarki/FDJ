package fr.fdj.app.data.remote

import fr.fdj.app.data.dto.TeamsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamsApi {
    @GET("search_all_teams.php")
    suspend fun getTeamsForLeague(
        @Query("l") leagueName: String,
    ): TeamsDto
}