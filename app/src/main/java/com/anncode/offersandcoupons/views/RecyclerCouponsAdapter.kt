package com.anncode.offersandcoupons.views

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.anncode.offersandcoupons.BR
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

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

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        ///var coupon = coupons?.get(p1)
        p0.setDataCard(couponViewModel, p1)
    }

    override fun getItemCount(): Int = coupons?.size ?: 0

    override fun getItemViewType(position: Int): Int = resource

    fun setCoupons(coupons: List<Coupon>) {
        this.coupons = coupons
    }

    class CardCouponHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setDataCard(couponViewModel: CouponViewModel, position: Int){
            binding.setVariable(BR.model, couponViewModel)
            binding.setVariable(BR.position, position)
            binding.executePendingBindings()
        }

    }

}
