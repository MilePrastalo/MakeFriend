package com.example.makefriendandroid.fragments.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makefriendandroid.Adapters.InterestCategoryAdapter

import com.example.makefriendandroid.R
import kotlinx.android.synthetic.main.interests_fragment.*

class InterestsFragment : Fragment() {

    companion object {
        fun newInstance() = InterestsFragment()
    }

    private lateinit var viewModel: InterestsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.interests_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InterestsViewModel::class.java)
        viewModel.getInterestCategories()
        viewModel.getUserInterests()
        interests_category_recycler.layoutManager = LinearLayoutManager(context)
        viewModel.update.observe(viewLifecycleOwner, Observer {
            if (it) {
                val adapter =
                    InterestCategoryAdapter(viewModel.interestCategories, viewModel.userInterests)
                interests_category_recycler.adapter = adapter
            }
        })

    }

}
