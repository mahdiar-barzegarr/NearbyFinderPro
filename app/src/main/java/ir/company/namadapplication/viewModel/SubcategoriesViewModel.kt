package ir.company.namadapplication.viewModel

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.company.namadapplication.data.LocationData
import ir.company.namadapplication.data.model.SubCategoriesModel
import ir.company.namadapplication.data.model.UserLocation
import ir.company.namadapplication.data.remote.remoteModel.LatLng
import ir.company.namadapplication.data.remote.remoteRepo.ApiRepository
import ir.company.namadapplication.utilities.LocationDataSource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubcategoriesViewModel @Inject constructor(
    private val repository: ApiRepository,
    private val locationDataSource: LocationDataSource
) : ViewModel() {

    private val _data = MutableStateFlow<List<SubCategoriesModel>>(emptyList())
    val data: StateFlow<List<SubCategoriesModel>> = _data

    private val _nearestLocation = MutableStateFlow<LatLng?>(null)
    val nearestLocation = _nearestLocation.asStateFlow()

    private val _lastLocation = MutableStateFlow<UserLocation?>(null)
    val lastLocation = _lastLocation.asStateFlow()

    private val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()


    init {
        loadLocation()
    }

    fun loadSubcategories(locationId: Int) {
        _data.value = when (locationId) {
            1 -> LocationData.locationHospitalList
            2 -> LocationData.EntertainmentList
            3 -> LocationData.RestaurantList
            4 -> LocationData.CarServiceList
            5 -> LocationData.entertainmentCentersList
            6 -> LocationData.HotelList
            7 -> LocationData.CommercialList
            8 -> LocationData.CulturalList
            9 -> LocationData.TransportList
            10 -> LocationData.PublicServicesList
            else -> emptyList()
        }
    }

    fun loadLocation() {
        locationDataSource.getLastLocation { userLocation ->
            _lastLocation.value = userLocation
        }
    }

    fun resetNearestLocation() {
        _nearestLocation.value = null
    }


    fun findNearestPlace(apiCategory: String, lat: Double, lng: Double) {
        _nearestLocation.value = null

        viewModelScope.launch {
            repository.getNearbyPlaceLocation(
                layer = apiCategory,
                lat = lat,
                lng = lng
            ).onSuccess { pair ->
                _nearestLocation.value = LatLng(
                    lat = pair.first,
                    lng = pair.second
                )
            }.onFailure {
                Log.i("NEARBY_PLACE_ERROR", it.toString())
                _error.emit("مکانی پیدا نشد")
            }
        }
    }


    fun openMaps(context: Context, lat: Double, lng: Double) {

        val geoIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:$lat,$lng?q=$lat,$lng")
        )

        try {
            context.startActivity(
                Intent.createChooser(geoIntent, "Open with")
            )
        } catch (e: Exception) {
            Toast.makeText(context, "هیچ مسیریابی نصب نیست", Toast.LENGTH_SHORT).show()
        }
    }


}
