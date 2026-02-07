package ir.company.namadapplication.data.remote.remoteModel

data class PlacesResponse(
    val features: List<PlaceFeature>
)

data class PlaceFeature(
    val properties: PlaceProperties
)

data class PlaceProperties(
    val name: String?
)

