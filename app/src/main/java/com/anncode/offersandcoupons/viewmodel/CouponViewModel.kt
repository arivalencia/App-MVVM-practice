package com.anncode.offersandcoupons.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.views.RecyclerCouponsAdapter

class CouponViewModel: ViewModel() {

    private val couponObservable = CouponObservable()
    private var recyclerCouponsAdapter: RecyclerCouponsAdapter? = null

    fun callCoupons() {
        couponObservable.callCoupons()
    }

    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }

    fun setCoupnsAdapter(coupons: List<Coupon>) {
        recyclerCouponsAdapter?.setCoupons(coupons)
        recyclerCouponsAdapter?.notifyDataSetChanged()
    }

    fun getCouponsAdapter(): RecyclerCouponsAdapter {
        recyclerCouponsAdapter = RecyclerCouponsAdapter(this, R.layout.card_coupon)
        return recyclerCouponsAdapter!!
    }

}