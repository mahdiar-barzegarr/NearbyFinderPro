package ir.company.namadapplication.data.remote.remoteModel

data class PlacesResponse(
    val layerPoints: LayerPoints?
)

data class LayerPoints(
    val nearestPoints: List<NearestPoint>?
)

data class NearestPoint(
    val name: String?,
    val location: LocationData?
)

data class LocationData(
    val latitude: Double?,
    val longitude: Double?
)

data class LatLng(
    val lat: Double,
    val lng: Double
)



