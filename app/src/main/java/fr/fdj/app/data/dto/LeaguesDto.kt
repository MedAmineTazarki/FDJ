package fr.fdj.app.data.dto

import com.google.gson.annotations.SerializedName

data class LeaguesDto(
    @SerializedName("leagues") val leagues: List<ApiLeague>
) {
    data class ApiLeague(
        @SerializedName("idLeague") val id: String,
        @SerializedName("strLeague") val name: String,
        @SerializedName("strSport") val sport: String,
        @SerializedName("strLeagueAlternate") val nameAlt: String?,
    )
}
