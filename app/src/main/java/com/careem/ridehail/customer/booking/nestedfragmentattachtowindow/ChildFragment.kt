package com.careem.ridehail.customer.booking.nestedfragmentattachtowindow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class ChildFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_child, container, false) as ViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewDetachedFromWindow(v: View?) {
                Toast.makeText(view.context, "onViewDetachedFromWindow", Toast.LENGTH_SHORT).show()
            }

            override fun onViewAttachedToWindow(v: View?) {
                Toast.makeText(view.context, "onViewAttachedToWindow", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
