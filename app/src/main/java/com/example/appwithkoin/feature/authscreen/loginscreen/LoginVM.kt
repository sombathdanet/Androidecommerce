package com.example.appwithkoin.feature.authscreen.loginscreen
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.core.device.DeviceInfoModule
import com.example.appwithkoin.core.view_model.BaseViewModel
import com.example.appwithkoin.feature.authscreen.data.model.body.LoginUserBodyModel
import com.example.appwithkoin.feature.authscreen.data.repository.AuthRepository
import com.example.appwithkoin.feature.authscreen.domain.usercase.ValidateObject
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.launch

class LoginVM(
    private val  authRepository: AuthRepository,
    private  val deviceInfo: DeviceInfoModule
) : BaseViewModel<LoginContract.State, LoginContract.LoginEvent, LoginContract.Effect>(){

    private  val validateEmailUserCase = ValidateObject.ValidateEmailUserCase()
    private  val validatePassword = ValidateObject.ValidatePassword()

    override fun createInitialState() = LoginContract.State()

    override fun handleEvent(event: LoginContract.LoginEvent) {
        when(event){

            LoginContract.LoginEvent.HomeRoute -> setEffect { LoginContract.Effect.Nav.HomeRoute }

            LoginContract.LoginEvent.SignUp -> setEffect { LoginContract.Effect.Nav.SignUpRoute }

            is  LoginContract.LoginEvent.EmailChange -> {
                setState { copy(email = event.email) }

            }
            is  LoginContract.LoginEvent.PassChange -> {
                setState {  copy(pass = event.pass) }
            }
        }
    }

     @RequiresApi(Build.VERSION_CODES.S)
     fun  loginUserWithUserPass(){
         if(validationLogin()){
             val body = LoginUserBodyModel(
                 deviceInfo = deviceInfo.getDeviceInfo().toString(),
                 username = uiState.value.email,
                 password = uiState.value.pass
             )
             viewModelScope.launch {
                  authRepository.loginUser(body).collect{
                     when(it){
                         is DataState.Loading -> {
                             setState { copy(loading = true) }
                         }
                         is DataState.Success -> {
                             if(it.data.status.toInt() == 200) {
                                 setEffect { LoginContract.Effect.Nav.NoteHomeRoute }
                             }
                         }
                         is DataState.Error -> {
                             setState { copy(message = it.exception) }
                         }
                     }
                 }
             }
         }
     }

    fun setError(setError:Boolean){
        setState { copy(error = setError) }
    }
    fun setMessage(message:String?){
        setState { copy(message =message ) }
    }
    private  fun validationLogin():Boolean{
        val  emailResult = validateEmailUserCase.execute(
            currentState.email
        )
        setState {  copy(errorEmail = emailResult.errorMessage) }

        val passResult = validatePassword.execute(uiState.value.pass)

        setState { copy(errorPass = passResult.errorMessage) }

        return  emailResult.success && passResult.success
    }
}