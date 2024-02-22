package fr.fdj.app.data.dto

import com.google.gson.annotations.SerializedName

data class TeamsDto(
    @SerializedName("teams") val teams: List<ApiTeam>?
) {
    data class ApiTeam(
        @SerializedName("idTeam") val id: String,
        @SerializedName("strTeam") val name: String,
        @SerializedName("strSport") val sport: String,
        @SerializedName("strLeague") val league: String,
        @SerializedName("strAlternate") val nameAlt: String,
        @SerializedName("strTeamBadge") val badgeUrl: String,
    )
}
