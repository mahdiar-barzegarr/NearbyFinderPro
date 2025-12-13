package ir.company.namadapplication.viewModel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.company.namadapplication.data.LocationData
import ir.company.namadapplication.data.model.LocationModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {


    private val _data = MutableStateFlow<List<LocationModel>>(LocationData.locationList)
    val data: StateFlow<List<LocationModel>> = _data

}