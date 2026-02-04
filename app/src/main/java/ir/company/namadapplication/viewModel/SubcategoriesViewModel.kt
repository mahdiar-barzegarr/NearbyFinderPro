package ir.company.namadapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.company.namadapplication.data.LocationData
import ir.company.namadapplication.data.model.SubCategoriesModel
import ir.company.namadapplication.data.model.UserLocation
import ir.company.namadapplication.data.remote.remoteRepo.ApiRepository
import ir.company.namadapplication.utilities.LocationDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    private val _nearestPlaceName = MutableStateFlow<String?>(null)
    val nearestPlaceName = _nearestPlaceName.asStateFlow()

    private val _lastLocation = MutableStateFlow<UserLocation?>(null)
    val lastLocation = _lastLocation.asStateFlow()



    init {
        loadLocation()
    }

    fun loadSubcategories(locationId: Int) {
        _data.value = when (locationId) {
            1 -> LocationData.locationHospitalList
            2 -> LocationData.carServiceList
            3 -> LocationData.restaurantList
            4 -> LocationData.hotelList
            else -> emptyList()
        }
    }

    fun loadLocation() {
        locationDataSource.getLastLocation { userLocation ->
            _lastLocation.value = userLocation
        }
    }

    fun findNearestPlace(
        apiCategory: String,
        lat: Double,
        lng: Double
    ) {
        viewModelScope.launch {
            repository.getNearbyPlaceName(
                category = apiCategory,
                lat = lat,
                lng = lng
            ).onSuccess {
                _nearestPlaceName.value = it
            }
        }
    }
}
