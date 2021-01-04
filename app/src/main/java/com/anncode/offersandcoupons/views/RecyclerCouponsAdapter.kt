package com.anncode.offersandcoupons.views

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.anncode.offersandcoupons.model.pojos.Coupon
import com.anncode.offersandcoupons.R
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(
    var coupons : ArrayList<Coupon>?,
    var resource: Int
) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        var view: View = LayoutInflater.from(p0!!.context).inflate(resource, p0, false)
        return CardCouponHolder(view)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        var coupon = coupons?.get(p1)
        p0.setDataCard(coupon)
    }

    class CardCouponHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var coupon: Coupon? = null
        private var imgCoupon: ImageView = v.findViewById(R.id.imgCoupon)
        private var tvTitle: TextView = v.findViewById(R.id.tvTitle)
        private var tvDescriptionShort: TextView = v.findViewById(R.id.tvDescriptionShort)
        private var tvCategory: TextView = v.findViewById(R.id.tvCategory)
        private var tvDate: TextView = v.findViewById(R.id.tvDate)

        init {
            v.setOnClickListener(this)
        }

        fun setDataCard(coupon: Coupon?){
            Log.e("IMAGE_URL", coupon?.image_url)
            this.coupon = coupon

            if (coupon?.image_url != null && coupon?.image_url.isNotEmpty()){
                Picasso.get().load(coupon?.image_url).resize(520, 520).centerCrop().into(imgCoupon)
            }
            tvTitle.setText(coupon?.title)
            tvDescriptionShort.text = if (coupon?.descriptionShort != null) coupon?.descriptionShort else "--"
            tvCategory.text = if (coupon?.category != null) coupon?.category else "--"
            tvDate.text = if (coupon?.endDate != null) coupon?.endDate else "--"

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
