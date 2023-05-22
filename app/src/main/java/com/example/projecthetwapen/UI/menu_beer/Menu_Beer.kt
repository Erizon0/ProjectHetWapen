package com.example.projecthetwapen.UI.menu_beer

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projecthetwapen.DATA.APIController
import com.example.projecthetwapen.DATA.API_Call
import com.example.projecthetwapen.DATA.Beer
import com.example.projecthetwapen.R

class Menu_Beer : Fragment(), API_Call {

    companion object {
        fun newInstance() = Menu_Beer()
    }

    private lateinit var viewModel: MenuBeerViewModel

    var apiC = APIController.getInstance(this.requireContext())

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

    override fun onSuccess(bList: ArrayList<Beer>) {}

}