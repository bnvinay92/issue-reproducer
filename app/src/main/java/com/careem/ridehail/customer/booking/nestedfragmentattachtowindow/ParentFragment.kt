package com.careem.ridehail.customer.booking.nestedfragmentattachtowindow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*

class ParentFragment : Fragment() {

    suspend fun doSomething() = withContext(Dispatchers.IO) { delay(200) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val viewGroup = inflater.inflate(R.layout.fragment_parent, container, false) as ViewGroup
        val scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
        scope.launch {
            doSomething()
            commitChildFragment() // moving this to #onViewCreated triggers ChildFragment's rootview's attachStateChangeListener. Why?
        }
        return viewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun commitChildFragment() {
        childFragmentManager.beginTransaction()
            .replace(R.id.child_fragment_container, ChildFragment(), "child")
            .commit()
    }
}