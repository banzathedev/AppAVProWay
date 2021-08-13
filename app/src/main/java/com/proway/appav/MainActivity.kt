package com.proway.appav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.appav.fragments.ItemFragment
import com.proway.appav.fragments.UserSettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, ItemFragment())
            .commitNow()

        findViewById<Button>(R.id.home_page).apply {
            setOnClickListener {
                replaceFrag(ItemFragment())
            }
        }
        findViewById<Button>(R.id.user_prefs).apply {
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
}