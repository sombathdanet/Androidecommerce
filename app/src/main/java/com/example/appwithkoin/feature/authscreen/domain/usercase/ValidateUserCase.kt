package com.example.appwithkoin.feature.authscreen.domain.usercase
import com.example.appwithkoin.core.validate.Validate
import com.example.appwithkoin.feature.authscreen.domain.model.ValidationModel

interface  BaseCase<In,Out>{
    fun  execute(input:In):Out
}
object ValidateObject{
    class ValidateEmailUserCase:BaseCase<String, ValidationModel> {
        private val validate = Validate()
        override fun execute(input: String): ValidationModel {
            if(input.isBlank()){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Please enter email"
                )
            }
            if(!validate.isEmailValidate(input)){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Wrong validation"
                )
            }
            return  ValidationModel(
                success = true,
                errorMessage  = null
            )
        }
    }
    class  ValidatePassword:BaseCase<String,ValidationModel>{
        override fun execute(input: String): ValidationModel {
            if(input.isBlank()){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Please enter password"
                )
            }
            if(input.length < 8){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Password not strong enough"
                )
            }
            return  ValidationModel(
                success = true,
                errorMessage = null
            )
        }
    }
    class ValidateFirstName:BaseCase<String,ValidationModel>{
        override fun execute(input: String): ValidationModel {
            if(input.isBlank()){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Please Enter FirstName"
                )
            }
            return  ValidationModel(
                success = true,
                errorMessage = null
            )
        }
    }
    class ValidateLastName:BaseCase<String,ValidationModel>{
        override fun execute(input: String): ValidationModel {
            if(input.isBlank()){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Please Enter LastName"
                )
            }
            return  ValidationModel(
                success = true,
                errorMessage = null
            )
        }
    }
    class ValidatePhone:BaseCase<String,ValidationModel>{
        private val validate = Validate()
        override fun execute(input: String): ValidationModel {
            if(input.isBlank()){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Please enter Phone Number"
                )
            }
            if(!validate.isPhoneNumber(input)){
                return  ValidationModel(
                    success = false,
                    errorMessage = "Phone number must be digit"
                )
            }
            return  ValidationModel(
                success = true,
                errorMessage = null
            )
        }
    }


}