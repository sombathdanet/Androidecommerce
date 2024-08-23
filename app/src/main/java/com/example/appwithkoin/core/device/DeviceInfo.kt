package com.example.appwithkoin.core.device
import android.annotation.SuppressLint
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DeviceInfoModule( private val context: Context) {
    @RequiresApi(Build.VERSION_CODES.S)
    @SuppressLint("HardwareIds")
    fun getDeviceInfo() : Flow<DataState<DeviceInfo>> = flow{
    try {
            DataState.Loading
            val deviceModel = Build.MODEL
            val deviceBrand = Build.MANUFACTURER
            val deviceName = Build.DEVICE
            val softwareId: String =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Settings.Secure.getString(
                        context.contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                } else {
                    val manager= context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
                    manager.enrollmentSpecificId
                }
            val info = DeviceInfo(
                deviceModel = deviceModel,
                deviceBrand = deviceBrand,
                softwareId = softwareId,
                deviceName = deviceName
            )
            DataState.Success(data = info)
        } catch (e: Exception) {
            DataState.Error(e.message.toString())
        }

    }
}