package com.anncode.offersandcoupons.views.interfeces

import com.anncode.offersandcoupons.model.pojos.Coupon

interface ICouponView {
    //VIEW
    fun showCoupons(coupons: List<Coupon>?)
    //PRESENTER
    fun getCoupons()
}