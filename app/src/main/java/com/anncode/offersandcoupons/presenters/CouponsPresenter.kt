package com.anncode.offersandcoupons.presenters

import com.anncode.offersandcoupons.model.CouponsInteractor
import com.anncode.offersandcoupons.model.interfaces.ICouponsInteractor
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.presenters.interfaces.ICouponsPresenter
import com.anncode.offersandcoupons.views.interfeces.ICouponView

class CouponsPresenter( val iCouponView: ICouponView): ICouponsPresenter {

    private var iCouponInteractor: ICouponsInteractor = CouponsInteractor(this)

    override fun showCoupons(coupons: List<Coupon>?) {
        iCouponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        iCouponInteractor.getCouponsAPI()
    }

}