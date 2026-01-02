package ir.company.namadapplication.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.company.namadapplication.data.LocationData
import ir.company.namadapplication.data.model.SubCategoriesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SubcategoriesViewModel @Inject constructor() : ViewModel() {

    private val _data = MutableStateFlow<List<SubCategoriesModel>>(emptyList())
    val data: StateFlow<List<SubCategoriesModel>> = _data

    fun loadSubcategories(locationId: Int) {
        _data.value = when (locationId) {
            1 -> LocationData.locationHospitalList
            2 -> LocationData.carServiceList
            3 -> LocationData.restaurantList
            4 -> LocationData.supermarketList
            5 -> LocationData.hotelList
            else -> emptyList()
        }
    }
}
