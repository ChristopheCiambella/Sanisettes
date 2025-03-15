package eu.ciambella.toilettest.domain.location.model

sealed interface LocationResult {

    data class Success(
        val location: Location,
    ) : LocationResult

    data object Error : LocationResult

    data object NeedPermissions : LocationResult

    data object Disabled : LocationResult

}
