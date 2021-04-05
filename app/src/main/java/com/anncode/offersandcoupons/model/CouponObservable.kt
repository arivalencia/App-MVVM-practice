package com.anncode.offersandcoupons.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.anncode.offersandcoupons.model.interfaces.ICouponRepository
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.views.RecyclerCouponsAdapter

class CouponObservable( ): BaseObservable() {

    private val couponRepository: ICouponRepository = CouponRepository()

    //REPOSITORIO
    fun callCoupons() {
        couponRepository.callCouponsAPI()
    }
    //VIEW MODEL
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponRepository.getCoupons()
    }

}