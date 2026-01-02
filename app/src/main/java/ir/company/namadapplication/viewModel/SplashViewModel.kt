package ir.company.namadapplication.viewModel

import android.content.Context
import android.location.Location
import android.location.LocationManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.company.namadapplication.base.ConnectivityObserver
import ir.company.namadapplication.data.model.UserLocation
import ir.company.namadapplication.utilities.DataStoreManager
import ir.company.namadapplication.utilities.LocationDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    val observer: ConnectivityObserver,
    private val locationDataSource: LocationDataSource,
    private val dataStoreManager: DataStoreManager
) : ViewModel()
{

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isGpsEnabled = MutableStateFlow(false)
    val isGpsEnabled: StateFlow<Boolean> = _isGpsEnabled

    private val _locationState = MutableStateFlow<UserLocation?>(null)
    val locationState = _locationState.asStateFlow()

    private val _savedLocation = MutableStateFlow<UserLocation?>(null)
    val savedLocation = _savedLocation.asStateFlow()




    init {
        startLoading()
        monitorGps()
        observeSavedLocation()
    }

    private fun startLoading() {
        viewModelScope.launch {
            delay(3000)
            _isLoading.value = false
        }
    }

    fun fetchUserLocation() {
        locationDataSource.getLastLocation { location ->
            location?.let {
                viewModelScope.launch {
                    dataStoreManager.saveLocation(it)
                    _locationState.value = it
                }
            }
        }
    }

    private fun observeSavedLocation() {
        viewModelScope.launch {
            dataStoreManager.locationFlow.collect { location ->
                _savedLocation.value = location
            }
        }
    }



    fun forceCheckGps() {
        val locationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        _isGpsEnabled.value =
            locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    private fun monitorGps() {
        val locationManager =
            context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        forceCheckGps()

        viewModelScope.launch {
            while (true) {
                delay(1000)
                val enabled =
                    locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                if (enabled != _isGpsEnabled.value) {
                    _isGpsEnabled.value = enabled
                }
            }
        }
    }
}


