package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.anncode.offersandcoupons.model.interfaces.ICouponRepository
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepository: ICouponRepository {

    private val TAG: String = "CouponRepository"
    private var coupons = MutableLiveData<List<Coupon>>()

    override fun getCoupons(): MutableLiveData<List<Coupon>> = coupons

    override fun callCouponsAPI() {
        var couponsList: ArrayList<Coupon> = ArrayList<Coupon>()
        val connection = Connection()
        val apiService = connection.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e(TAG, "getCouponsAPI -> onFailure: ${t.message}")
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    couponsList.add(coupon)
                }

                coupons.value = couponsList

            }
        })
    }
}