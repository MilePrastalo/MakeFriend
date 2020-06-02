package com.example.makefriendandroid.fragments.profile

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.makefriendandroid.model.ProfileDetails
import com.example.makefriendandroid.service.RetrofitService
import com.example.makefriendandroid.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {
   val profileDetails = MutableLiveData<ProfileDetails>()
   val service:UserService = RetrofitService.get_retrofit().create(UserService::class.java)
   fun saveProfileInfo(){
      service.setProfileDetails(profileDetails.value!!).enqueue(object : Callback<ProfileDetails>{
         override fun onFailure(call: Call<ProfileDetails>, t: Throwable) {
            Log.i("ProfileViewModel",t.message)
         }

         override fun onResponse(call: Call<ProfileDetails>, response: Response<ProfileDetails>) {
            Log.i("ProfileViewModel",response.message())
         }

      })
   }
   fun getProfileInfo(){

      service.getProfileDetails().enqueue(object :Callback<ProfileDetails>{
         override fun onFailure(call: Call<ProfileDetails>, t: Throwable) {
            Log.i("ProfileViewModel",t.message)
         }

         override fun onResponse(call: Call<ProfileDetails>, response: Response<ProfileDetails>) {
            profileDetails.value = response.body()!!
         }

      })
   }
}
