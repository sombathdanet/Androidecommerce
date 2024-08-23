package com.example.appwithkoin.feature.authscreen.signupscreen
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.core.device.DeviceInfoModule
import com.example.appwithkoin.core.view_model.BaseViewModel
import com.example.appwithkoin.feature.authscreen.data.model.body.SignUpBodyModel
import com.example.appwithkoin.feature.authscreen.data.repository.AuthRepository
import com.example.appwithkoin.feature.authscreen.domain.usercase.ValidateObject
import com.example.appwithkoin.util.network.DataState
import kotlinx.coroutines.launch


class  SignUpVM(
    private  val deviceInfo: DeviceInfoModule,
    private  val authRepository: AuthRepository
):BaseViewModel<SignUpContract.State,SignUpContract.SignupEvent,SignUpContract.Effect>(){

    override fun createInitialState() = SignUpContract.State ();

    override fun handleEvent(event: SignUpContract.SignupEvent) {
        when(event){
            SignUpContract.SignupEvent.Back -> {}
            is SignUpContract.SignupEvent.EmailChangeEvent -> {
                setState {
                    copy(email = event.email)
                }
            }
            is SignUpContract.SignupEvent.FirstNameChangeEvent -> {
                setState {
                    copy(fistName = event.firstname)
                }
            }
            is SignUpContract.SignupEvent.LastChangeEvent -> {
                setState {
                    copy(lastName = event.lastname)
                }
            }
            is SignUpContract.SignupEvent.PasswordChangeEvent -> {
                setState {
                    copy(
                        password = event.password
                    )
                }
            }
            is SignUpContract.SignupEvent.PhoneChangeEvent -> {
                setState {
                    copy(
                        phone = event.phone
                    )
                }
            }
        }
    }
    @RequiresApi(Build.VERSION_CODES.S)
     fun signUpUser(){
         if(vFirstName()){
             val body = SignUpBodyModel(
                 deviceInfo = deviceInfo.getDeviceInfo().toString(),
                 firstName = currentState.fistName,
                 lastName = currentState.lastName,
                 email = currentState.email,
                 password = currentState.password,
                 photoUrl = "https://i.pinimg.com/736x/df/fd/b9/dffdb9316dc28090a77b7e9ac9945870.jpg",
                 dateOfBirth = "2024-01-01",
                 region = "KH",
                 interests = emptyList(),
                 gender = "MALE",
                 username = currentState.fistName + currentState.lastName,
                 mobileCode = "KH",
                 mobile = currentState.phone,
             );
             viewModelScope.launch {
                 authRepository.signUpUser(body).collect{
                     when(it){
                         is DataState.Error -> {
                             setState { copy(isError = true) }
                             setState { copy(message = it.exception) }
                         }
                         is DataState.Loading -> {
                             setState { copy(loading = true) }
                         }
                         is DataState.Success -> {
                                 setEffect { SignUpContract.Effect.Nav.Back }
                         }
                     }
                 }
             }
         }
    }
    fun setError(isError:Boolean){
        setState { copy(isError = false) }
    }
    private val vFName = ValidateObject.ValidateFirstName()
    private val vLName = ValidateObject.ValidateLastName()
    private val vEmail = ValidateObject.ValidateEmailUserCase()
    private val vPass = ValidateObject.ValidatePassword()
    private val vPhone = ValidateObject.ValidatePhone()


    private fun vFirstName():Boolean{
        // for first name
        val firstR =   vFName.execute(uiState.value.fistName)
        setState { copy(firstNameError =firstR.errorMessage) }
        // for last name
        val lastR =   vLName.execute(uiState.value.lastName)
        setState { copy(lastNameError =lastR.errorMessage) }
        // for email
        val emailR =   vEmail.execute(uiState.value.email)
        setState { copy(emailError =emailR.errorMessage) }
        // for password
        val passR =   vPass.execute(uiState.value.password)
        setState { copy(passwordError =passR.errorMessage) }
        // for phone number
        val phoneR =   vPhone.execute(uiState.value.phone)
        setState { copy(phoneError =phoneR.errorMessage) }

        return  firstR.success && lastR.success && emailR.success && passR.success && phoneR.success
    }
}