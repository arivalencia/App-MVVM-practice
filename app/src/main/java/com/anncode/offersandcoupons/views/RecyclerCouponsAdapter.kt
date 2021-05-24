package com.anncode.offersandcoupons.views

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.BR
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

class RecyclerCouponsAdapter(
    //var coupons : ArrayList<Coupon>?,
    val couponViewModel: CouponViewModel,
    val resource: Int
) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    private val TAG = javaClass.simpleName
    private var coupons: List<Coupon> = ArrayList<Coupon>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        p0.setDataCard(couponViewModel, p1)
    }

    override fun getItemCount(): Int = coupons.size

    override fun getItemViewType(position: Int): Int = resource

    fun setCoupons(coupons: List<Coupon>) {
        this.coupons = coupons
    }

    inner class CardCouponHolder(
        val binding: ViewDataBinding
        ) : RecyclerView.ViewHolder(binding.root) {

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            binding.setVariable(BR.model, couponViewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }

    }

}
