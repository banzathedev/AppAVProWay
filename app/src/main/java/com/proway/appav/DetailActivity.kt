package com.proway.appav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.proway.appav.model.Products

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val product = intent.getSerializableExtra("product_To_Pass") as? Products

        product?.let { chosedProduct ->

            supportActionBar?.title = "${chosedProduct.name}"
            findViewById<ImageView>(R.id.product_photo_detail).apply {
                Glide.with(context)
                    .load(chosedProduct.image)
                    .into(this)
            }
            findViewById<TextView>(R.id.product_name_detail).apply {
                text = "Name: ${chosedProduct.name}"
            }
            findViewById<TextView>(R.id.product_category_detail).apply {
                text = "Category: ${chosedProduct.category}"
            }
            findViewById<TextView>(R.id.product_descripition_detail).apply {
                text = "Description: ${chosedProduct.description}"
            }
            findViewById<TextView>(R.id.product_price_detail).apply {
                text = "Price: $" + chosedProduct.price.toString()
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
