package com.memebattle.template.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.template.App
import com.memebattle.template.R

class MainFlowFragment : Fragment() {
    private lateinit var navController : NavController


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        navController = Navigation.findNavController(activity!!, R.id.nav_host_main)
        navController.navigate(R.id.action_mainFlowFragment_to_gameFlowFragment)
        return inflater.inflate(R.layout.flow_fragment_main, container, false)
    }

}
