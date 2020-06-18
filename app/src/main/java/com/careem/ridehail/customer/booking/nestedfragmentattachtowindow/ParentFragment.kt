package com.careem.ridehail.customer.booking.nestedfragmentattachtowindow

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ParentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_parent, container, false) as ViewGroup
    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({ commitChildFragment() }, 200) // Simulating api call/user interaction.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        commitChildFragment() // works fine if called here instead of being posted in #onResume().
    }

    private fun commitChildFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.child_fragment_container, ChildFragment(), "child")
            .commit()
    }
}