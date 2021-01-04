package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.model.interfaces.ICouponRepository
import com.anncode.offersandcoupons.model.interfaces.ICouponsInteractor
import com.anncode.offersandcoupons.presenters.interfaces.ICouponsPresenter

class CouponsInteractor( val iCouponsPresenter: ICouponsPresenter): ICouponsInteractor {

    private val iCouponRepository: ICouponRepository = CouponRepository(iCouponsPresenter)

    override fun getCouponsAPI() {
        iCouponRepository.getCouponsAPI()
    }
}