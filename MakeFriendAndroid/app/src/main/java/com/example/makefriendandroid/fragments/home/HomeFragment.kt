package com.example.makefriendandroid.fragments.home

import android.app.Activity
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makefriendandroid.Adapters.FriendSuggestionsAdapter
import com.example.makefriendandroid.MainActivity

import com.example.makefriendandroid.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getSuggestedFriends()
        val rec = fiendSuggestionsRecycler
        rec.layoutManager = GridLayoutManager(context,3)
        rec.adapter = FriendSuggestionsAdapter(ArrayList(),viewModel)
        viewModel.suggested.observe(viewLifecycleOwner, Observer {
            rec.adapter = FriendSuggestionsAdapter(it,viewModel)
        })
        val mainActivity: MainActivity = activity as MainActivity
        mainActivity.bottomNavigationView.visibility = View.VISIBLE
        viewModel.name.observe(viewLifecycleOwner, Observer {
            home_name_text.text = it;
        })
        viewModel.getProfileDetails()
        //Hide keyboard
        val imm =requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = requireActivity().currentFocus
        if (view == null) {
            view = View(activity);
        }
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}
