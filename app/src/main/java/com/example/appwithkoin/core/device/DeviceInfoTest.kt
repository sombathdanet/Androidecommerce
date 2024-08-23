package com.example.appwithkoin.core.device//package com.example.appwithkoin.core.device
//import android.annotation.SuppressLint
//import android.content.Context
//import android.net.ConnectivityManager
//import android.net.NetworkCapabilities
//import android.net.NetworkInfo
//import android.os.BatteryManager
//import android.os.Build
//import android.util.DisplayMetrics
//import android.view.WindowManager
//import androidx.annotation.RequiresApi
//import com.example.appwithkoin.util.network.DataState
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.flow
//import java.util.Locale
//import java.util.TimeZone
//
//@Suppress("DEPRECATION")
//class DeviceInfoTest{
//    @SuppressLint("HardwareIds")
//    @RequiresApi(Build.VERSION_CODES.S)
//    fun getDeviceInfo(context: Context):Flow<DataState<DeviceInformationModel>> = flow {
//        val res = try {
//            val deviceModel = Build.MODEL
//            val deviceBrand = Build.MANUFACTURER
//            val deviceName = Build.DEVICE
//            val systemVersion = Build.VERSION.RELEASE
//            val screenResolution = getScreenResolution(context) // Assume this function exists
//            val availableScreenResolution = getAvailableScreenResolution(context) // Assume this function exists
//            val systemLang = Locale.getDefault().language
//            val timezone = TimeZone.getDefault().id
//            val userAgent = System.getProperty("http.agent") ?: ""
//            val remoteIp = "" // You would need to obtain this from a network request
//            val platform = "Android"
//            val webTimezone = TimeZone.getDefault().id // or other web-specific timezone format
//            val fingerprint = Build.FINGERPRINT
//            val deviceId = "" // Obtain from TelephonyManager or Settings.Secure
//            val onesignalId = "" // Obtain from OneSignal SDK
//            val batteryLevel = getBatteryLevel(context) // Assume this function exists
//            val connectionType = getConnectionType(context) // Assume this function exists
//
//            // Application info
//            val application = Application(
//                name = context.applicationInfo.loadLabel(context.packageManager).toString(),
//                version = context.packageManager.getPackageInfo(context.packageName, 0).versionName,
//                build = context.packageManager.getPackageInfo(context.packageName, 0).versionCode.toString(),
//                platform = "Android"
//            )
//
//            // Location info (assuming default location is 0,0 if not available)
//            val location = Location(
//                latitude = 0.0,
//                longitude = 0.0
//            )
//         val deviceInfo =   DeviceInformationModel(
//                screenResolution = screenResolution,
//                availableScreenResolution = availableScreenResolution,
//                systemVersion = systemVersion,
//                brandModel = "$deviceBrand $deviceModel",
//                systemLang = systemLang,
//                timezone = timezone,
//                userAgent = userAgent,
//                remoteIp = remoteIp,
//                platform = platform,
//                webTimezone = webTimezone,
//                deviceName = deviceName,
//                fingerprint = fingerprint,
//                deviceId = deviceId,
//                onesignalId = onesignalId,
//                application = application,
//                location = location,
//                batteryLevel = batteryLevel,
//                connectionType = connectionType
//            )
//        }
//    }
//    @SuppressLint("ServiceCast")
//     private  fun getAvailableScreenResolution(context: Context): String {
//        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        val displayMetrics = DisplayMetrics()
//        wm.defaultDisplay.getRealMetrics(displayMetrics)
//        val width = displayMetrics.widthPixels
//        val height = displayMetrics.heightPixels
//        return "${width}x${height}"
//    }
//    private fun getScreenResolution(context: Context): String {
//        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        val displayMetrics = DisplayMetrics()
//        wm.defaultDisplay.getMetrics(displayMetrics)
//        val width = displayMetrics.widthPixels
//        val height = displayMetrics.heightPixels
//        return "${width}x${height}"
//    }
//
//    @SuppressLint("ServiceCast")
//    private fun getBatteryLevel(context: Context): Long {
//        val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
//        return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY).toLong()
//    }
//
//    private fun getConnectionType(context: Context): String {
//        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        // For API Level 29 and above
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            val activeNetwork = connectivityManager.activeNetwork ?: return "No Connection"
//            val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return "No Connection"
//
//            return when {
//                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "WiFi"
//                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Mobile Data"
//                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> "Ethernet"
//                else -> "Other"
//            }
//        } else {
//            // For API Level 28 and below
//            val activeNetworkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
//            return when (activeNetworkInfo?.type) {
//                ConnectivityManager.TYPE_WIFI -> "WiFi"
//                ConnectivityManager.TYPE_MOBILE -> "Mobile Data"
//                ConnectivityManager.TYPE_ETHERNET -> "Ethernet"
//                else -> "Other"
//            }
//        }
//    }
//
//}
