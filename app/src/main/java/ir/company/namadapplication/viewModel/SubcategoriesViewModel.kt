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

    private val _nearestLocation = MutableStateFlow<LatLng?>(null)
    val nearestLocation = _nearestLocation.asStateFlow()

    private val _lastLocation = MutableStateFlow<UserLocation?>(null)
    val lastLocation = _lastLocation.asStateFlow()



    init {
        loadLocation()
    }

    fun loadSubcategories(locationId: Int) {
        _data.value = when (locationId) {
            1 -> LocationData.locationHospitalList
            2 -> LocationData.carServiceList
            3 -> LocationData.Bank
            4 -> LocationData.hotelList
            5-> LocationData.transportationList
            6-> LocationData.entertainmentCentersList
            else -> emptyList()
        }
    }

    fun loadLocation() {
        locationDataSource.getLastLocation { userLocation ->
            _lastLocation.value = userLocation
        }
    }


    fun findNearestPlace(apiCategory: String, lat: Double, lng: Double) {

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
            }
        }
    }


    fun openMaps(context: Context, lat: Double, lng: Double) {

        val intents = mutableListOf<Intent>()

        // 🔹 لینک عمومی (برای همه اپ‌های نقشه)
        val geoIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("geo:$lat,$lng?q=$lat,$lng")
        )

        // 🔹 دیپ لینک اختصاصی نشان
        val neshanIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("neshan://navigation?destination=$lat,$lng")
        ).apply {
            setPackage("org.neshan.maps") // پکیج نشان
        }

        // اگر نشان نصب بود اضافه کن
        if (neshanIntent.resolveActivity(context.packageManager) != null) {
            intents.add(neshanIntent)
        }

        // chooser اصلی
        val chooser = Intent.createChooser(geoIntent, "انتخاب مسیریاب").apply {
            putExtra(Intent.EXTRA_INITIAL_INTENTS, intents.toTypedArray())
        }

        try {
            context.startActivity(chooser)
        } catch (e: Exception) {
            Toast.makeText(context, "هیچ مسیریابی نصب نیست", Toast.LENGTH_SHORT).show()
        }
    }














}
