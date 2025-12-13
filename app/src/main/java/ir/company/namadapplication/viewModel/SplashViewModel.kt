package ir.company.namadapplication.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.company.namadapplication.base.ConnectivityObserver
import ir.company.namadapplication.base.isNetworkState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    val observer: ConnectivityObserver
) : ViewModel() {

    private val _state = MutableStateFlow<Boolean?>(null)
    val state: StateFlow<Boolean?> = _state

    private val _isLoading = MutableStateFlow<Boolean>(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        navigateToHome()
    }

    private fun navigateToHome() {
        viewModelScope.launch {
            val startTime = System.currentTimeMillis()

            val hasInternet = context.isNetworkState()
            _state.value = hasInternet

            val elapsed = System.currentTimeMillis() - startTime
            val remaining = 3000 - elapsed
            if (remaining > 0) delay(remaining)

            _isLoading.value = false
        }
    }


    fun retryLoading() {
        viewModelScope.launch {
            _isLoading.value = true

            val startTime = System.currentTimeMillis() //10

            val hasInternet = context.isNetworkState()
            _state.value = hasInternet

            val elapsed = System.currentTimeMillis() - startTime //5
            val remaining = 3000 - elapsed
            if (remaining > 0) delay(remaining)

            _isLoading.value = false
        }
    }


}