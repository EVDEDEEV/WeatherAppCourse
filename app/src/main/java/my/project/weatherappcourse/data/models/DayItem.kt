package my.project.weatherappcourse.data.models

data class DayItem(
    val city: String,
    val time: String,
    val conditions: String,
    val imageUrl: String,
    val currentTemp: String,
    val currentMax: String,
    val currentMin: String,
    val hours: String,
)