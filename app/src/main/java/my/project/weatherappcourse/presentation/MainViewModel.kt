package my.project.weatherappcourse.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val LiveDataCurrent = MutableLiveData<String>()
    val liveDataList = MutableLiveData<List<String>>()
}