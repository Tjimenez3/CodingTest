package com.vogella.android.codingtest.ui.main

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vogella.android.codingtest.EmailViewModel
import com.vogella.android.codingtest.R
import com.vogella.android.codingtest.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    private var _binding: FragmentInboxBinding? = null
    private val binding get()  = _binding!!
    private val mEmailAdapter = EmailAdapter()
    private var emailViewModel = EmailViewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        with(binding.recyclerView) {
            adapter = mEmailAdapter
        }
        emailViewModel.responseNewsItems.observe(viewLifecycleOwner) {
            mEmailAdapter.setData(it)
        }

        return binding.root
    }

}