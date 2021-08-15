package com.proway.appav.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.proway.appav.R
import com.proway.appav.model.Products
import com.proway.appav.model.User
import com.proway.appav.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserSettingsFragment : Fragment(R.layout.fragment_user_settings), Callback<User> {
    var user: User? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        triggerRequest()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
    }

    override fun onFailure(call: Call<User>, t: Throwable) {
        TODO("Not yet implemented")
    }
//        fun newInstance(param1: String, param2: String) =
//            UserSettingsFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}