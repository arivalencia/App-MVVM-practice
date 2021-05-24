package com.anncode.offersandcoupons.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var couponsViewModel: CouponViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setUpBindings(savedInstanceState)

    }

    private fun setUpBindings(savedInstanceState: Bundle?) {

        val activityMainBinding: com.anncode.offersandcoupons.databinding.ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        couponsViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)

        activityMainBinding.model = couponsViewModel

        setUpListUpdate()

    }

    private fun setUpListUpdate() {
        couponsViewModel.callCoupons()

        couponsViewModel.getCoupons().observe(this, Observer {coupons ->
            coupons.forEach {
                Log.w("Coupon", it.title)
            }
            couponsViewModel.setCoupnsAdapter(coupons)
        })
    }

}
