package my.project.weatherappcourse.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.project.weatherappcourse.data.models.WeatherModel

class MainViewModel: ViewModel() {

    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}