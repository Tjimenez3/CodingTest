package com.vogella.android.codingtest.ui.main

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vogella.android.codingtest.App
import com.vogella.android.codingtest.EmailViewModel
import com.vogella.android.codingtest.R
import com.vogella.android.codingtest.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    private var _binding: FragmentInboxBinding? = null
    private val binding get()  = _binding!!
    private val mEmailAdapter = EmailAdapter()
    private var emailViewModel = EmailViewModel(App.getApi())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)


        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = mEmailAdapter
        }

        emailViewModel.responseNewsItems.observe(viewLifecycleOwner) {
            mEmailAdapter.setData(it)
        }

        emailViewModel.makeApiRequest()

        return binding.root
    }

}