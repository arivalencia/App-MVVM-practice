package com.anncode.offersandcoupons.viewmodel

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.CouponObservable
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.views.RecyclerCouponsAdapter
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import com.squareup.picasso.Target
import de.hdodenhof.circleimageview.CircleImageView
import kotlin.coroutines.coroutineContext


class CouponViewModel: ViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(imageView: CircleImageView, imageUrl: String?) {
            imageUrl?.let {
                if (it.isNotEmpty()) Picasso.get().load(it).into(imageView)
            }
        }
    }

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

    fun getCouponAt(position: Int): Coupon {
        var coupons = couponObservable.getCoupons().value
        return coupons!![position]
    }

}