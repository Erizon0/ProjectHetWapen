package com.example.projecthetwapen.UI.menu_beer

import CustomAdapter2
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.FragmentManager
import com.example.projecthetwapen.DATA.APIController
import com.example.projecthetwapen.DATA.API_Call
import com.example.projecthetwapen.DATA.Beer
import com.example.projecthetwapen.R
import com.example.projecthetwapen.UI.detail_beer.DetailPaginaFragment

class Menu_Beer : Fragment(), API_Call {

    companion object {
        fun newInstance() = Menu_Beer()
    }

    private lateinit var viewModel: MenuBeerViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu__beer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuBeerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var apiC = APIController.getInstance(this.requireContext())
        val beerList = view.findViewById<ListView>(R.id.beerList)
        val adapter = CustomAdapter2(this.requireContext(), apiC.getBeer())
        beerList.adapter = adapter

        val fm : FragmentManager = requireActivity().supportFragmentManager

        beerList.setOnItemClickListener { adapterView, view, i, l ->
            val selection = Bundle()
            selection.putInt("selected", i)

            val frag = DetailPaginaFragment()

            fm.beginTransaction()
                .replace(R.id.nav_host_fragment_activity_main, frag, null)
                .commit()

            Log.d("BeerID", i.toString())
        }
    }
    override fun onSuccess(bList: ArrayList<Beer>) {}

}