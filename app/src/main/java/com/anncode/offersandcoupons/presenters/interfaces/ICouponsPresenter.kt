package com.anncode.offersandcoupons.presenters.interfaces

import com.anncode.offersandcoupons.model.pojos.Coupon

interface ICouponsPresenter {
    //VIEW
    fun showCoupons(coupons: List<Coupon>?)
    //INTERACTOR
    fun getCoupons()
}