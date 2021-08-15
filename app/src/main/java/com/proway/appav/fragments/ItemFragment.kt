package com.proway.appav.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.view.View

import com.proway.appav.Adapter.ItemRecyclerViewAdapter
import com.proway.appav.R
import com.proway.appav.model.Products
import com.proway.appav.services.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemFragment : Fragment(R.layout.fragment_item), Callback<List<Products>> {
    var productsList: List<Products>? = null
    lateinit var recyclerView: RecyclerView


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    private fun triggerRequest(view: View) {
        val service = RetrofitBuilder.getProducts()
        val call = service.getProductsAtApiEndpoint()
        call.clone().enqueue(this)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        triggerRequest(view)

    }



    override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
        response.body()?.apply {
            productsList = this
            if (productsList != null){
                loadComponents(requireView())
            }
        }

    }

    override fun onFailure(call: Call<List<Products>>, t: Throwable) {
        TODO("Not yet implemented")
    }
    fun loadComponents(view: View) {
        recyclerView = view.findViewById(R.id.recyclerViewIdOnFragment)
        recyclerView.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter =ItemRecyclerViewAdapter(productsList!!)

    }
}

//    companion object {
//
//        // TODO: Customize parameter argument names
//        const val ARG_COLUMN_COUNT = "column-count"
//
//        // TODO: Customize parameter initialization
//        @JvmStatic
//        fun newInstance(columnCount: Int) =
//            ItemFragment().apply {
//                arguments = Bundle().apply {
//                    putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
//    }
//}