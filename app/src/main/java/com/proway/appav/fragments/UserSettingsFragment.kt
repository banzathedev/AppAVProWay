package com.proway.appav.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.button.MaterialButton
import com.google.android.material.switchmaterial.SwitchMaterial
import com.proway.appav.AppPreferences.AppPreferences
import com.proway.appav.AppPreferences.Keys
import com.proway.appav.MainActivity
import com.proway.appav.R
import com.proway.appav.model.Products
import com.proway.appav.model.User
import com.proway.appav.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserSettingsFragment : Fragment(R.layout.fragment_user_settings), Callback<User> {
    private lateinit var preferences: AppPreferences
    private lateinit var emailSwitch: SwitchMaterial
    private lateinit var pushSwitch: SwitchMaterial
    private lateinit var emailTextView: TextView
    private lateinit var buttonClear: MaterialButton
    private var activityManager: MainActivity? = null
    var user: User? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        preferences = AppPreferences(requireContext())
        activityManager = (requireActivity() as? MainActivity)
        triggerRequest()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emailSwitch = view.findViewById<SwitchMaterial>(R.id.emailSwitch)
        pushSwitch = view.findViewById<SwitchMaterial>(R.id.pushSwitch)

        emailSwitch.setOnCheckedChangeListener { button, value ->
            preferences.setValue<Boolean>(Keys.Notifications_Email, value)
        }
        pushSwitch.setOnCheckedChangeListener { button, value ->
            preferences.setValue<Boolean>(Keys.Notifications_PUSH, value)
        }

        checkIfHaveSavedValues()

    }

    private fun checkIfHaveSavedValues() {
        emailSwitch.isChecked = preferences.base.getBoolean(Keys.Notifications_Email.name, false)
        pushSwitch.isChecked = preferences.base.getBoolean(Keys.Notifications_Email.name, false)
    }

    private fun triggerRequest() {
        val service = RetrofitBuilder.getUser()
        val call = service.getUserEndpoint()
        call.clone().enqueue(this)
    }

    override fun onResponse(call: Call<User>, response: Response<User>) {
        response.body()?.apply {
            user = this
            if (user != null) {
                loadComponents(requireView())
            }
        }
    }

    private fun loadComponents(view: View) {
        val emailTextView = view.findViewById<TextView>(R.id.user_pref_email_textView)
        val userNickName = view.findViewById<TextView>(R.id.user_pref_nickname)
        val userCompleteName = view.findViewById<TextView>(R.id.user_pref_complete_name)

        emailTextView.text = user!!.email
        userNickName.text = "Welcome ${user!!.username}"
        userCompleteName.text = "Name: ${user!!.name.firstname} ${user!!.name.lastname}"

        view.findViewById<ImageView>(R.id.user_pref_photo).apply {
            Glide.with(context)
                .load(R.drawable.ic_avatar_photo)
                .into(this)
        }

    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        TODO("Not yet implemented")
    }
}