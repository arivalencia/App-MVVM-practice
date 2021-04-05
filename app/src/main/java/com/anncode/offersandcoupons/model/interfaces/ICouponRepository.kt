package com.anncode.offersandcoupons.model.interfaces

import androidx.lifecycle.MutableLiveData
import com.anncode.offersandcoupons.model.pojos.Coupon

interface ICouponRepository {
    fun getCoupons(): MutableLiveData<List<Coupon>>
    fun callCouponsAPI()
}