package com.anncode.offersandcoupons.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Connection
import com.anncode.offersandcoupons.presenters.CouponsPresenter
import com.anncode.offersandcoupons.presenters.interfaces.ICouponsPresenter
import com.anncode.offersandcoupons.views.interfeces.ICouponView
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity(), ICouponView {

    private var iCouponsPresenter: ICouponsPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        iCouponsPresenter = CouponsPresenter(this)

        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    override fun showCoupons(coupons: List<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons as ArrayList<Coupon>, R.layout.card_coupon)
        }catch (e: Exception){ e.stackTrace }
    }

    override fun getCoupons() {
        iCouponsPresenter?.getCoupons()
    }
}
