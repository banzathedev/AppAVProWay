package com.proway.appav

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.appav.fragments.ItemFragment
import com.proway.appav.fragments.UserSettingsFragment
import com.proway.appav.interfaces.ClickableItem
import com.proway.appav.model.Products

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragmentMainActivity, ItemFragment())
            .commitNow()


        findViewById<Button>(R.id.home_page_Button).apply {
            setOnClickListener {
                replaceFrag(ItemFragment())
            }
        }
        findViewById<Button>(R.id.user_pref_Button).apply {
            setOnClickListener {
                replaceFrag(UserSettingsFragment())
            }
        }
    }

    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragmentMainActivity, fragment)
            .commitNow()
    }

    fun goToOtherActivity(products: Products) {
        val intentToDetail =
            Intent(this, DetailActivity::class.java).putExtra("product_To_Pass", products)
        startActivity(intentToDetail)
    }


}