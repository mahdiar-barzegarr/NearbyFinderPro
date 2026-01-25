package ir.company.namadapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.company.namadapplication.data.LocationData
import ir.company.namadapplication.data.model.SubCategoriesModel
import ir.company.namadapplication.data.remote.remoteRepo.ApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SubcategoriesViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {

    private val _data = MutableStateFlow<List<SubCategoriesModel>>(emptyList())
    val data: StateFlow<List<SubCategoriesModel>> = _data

    private val _nearestPlaceName = MutableStateFlow<String?>(null)
    val nearestPlaceName = _nearestPlaceName.asStateFlow()

    fun loadSubcategories(locationId: Int) {
        _data.value = when (locationId) {
            1 -> LocationData.locationHospitalList
            2 -> LocationData.restaurantList
            else -> emptyList()
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
