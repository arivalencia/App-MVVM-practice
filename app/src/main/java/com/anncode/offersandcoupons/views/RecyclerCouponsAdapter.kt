package com.anncode.offersandcoupons.views

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.viewmodel.CouponViewModel
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(
    //var coupons : ArrayList<Coupon>?,
    val couponViewModel: CouponViewModel,
    var resource: Int
) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    private lateinit var coupons: List<Coupon>

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)

        //var view: View = LayoutInflater.from(p0!!.context).inflate(resource, p0, false)
        //return CardCouponHolder(view)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    fun setCoupons(coupons: List<Coupon>) {
        this.coupons = coupons
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        var coupon = coupons?.get(p1)
        p0.setDataCard(coupon)
    }

    class CardCouponHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            binding.setVariable()
        }

        override fun onClick(v: View) {
            Log.i("CLICK Coupon: ", coupon?.title)
            val context = v.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupon)
            context.startActivity(showPhotoIntent)

        }

    }

}
