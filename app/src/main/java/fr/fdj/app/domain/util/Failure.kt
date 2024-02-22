package fr.fdj.app.domain.util

sealed class Failure(val message: String) {
    class NetworkError(message: String) : Failure(message)
}