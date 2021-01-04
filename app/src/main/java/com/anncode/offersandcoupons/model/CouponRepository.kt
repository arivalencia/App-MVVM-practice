package com.anncode.offersandcoupons.model

import android.util.Log
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.interfaces.ICouponRepository
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.presenters.interfaces.ICouponsPresenter
import com.anncode.offersandcoupons.views.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepository( val iCouponsPresenter: ICouponsPresenter): ICouponRepository {

    private val TAG: String = "CouponRepository"

    override fun getCouponsAPI() {
        var coupons: ArrayList<Coupon> = ArrayList<Coupon>()
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
                    coupons.add(coupon)
                }

                iCouponsPresenter.showCoupons(coupons)
            }
        })
    }
}