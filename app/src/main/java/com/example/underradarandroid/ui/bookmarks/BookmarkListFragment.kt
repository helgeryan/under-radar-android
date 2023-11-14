package com.example.underradarandroid.ui.bookmarks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.underradarandroid.DataClasses.Bookmark
import com.example.underradarandroid.DataClasses.Event
import com.example.underradarandroid.DataClasses.User
import com.example.underradarandroid.NavGraphDirections
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.DatabaseManager.DatabaseManager
import com.example.underradarandroid.databinding.FragmentBookmarkListBinding
import com.example.underradarandroid.databinding.FragmentSavedEventListBinding
import com.example.underradarandroid.ui.savedevents.SavedEventAdapter


class BookmarkListFragment : Fragment() {

    private var _binding: FragmentBookmarkListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DatabaseManager.readBookmarks.observe(viewLifecycleOwner, Observer { bookmarks ->

            val itemAdapter = BookmarksAdapter(bookmarks)
            itemAdapter.onClickListener = object: BookmarksAdapter.OnClickListener {
                override fun onClick(position: Int, model: User) {
                    val action = NavGraphDirections.actionGlobalPlayerFragment(model)
                    findNavController().navigate(action)
                }
            }
            // Set the LayoutManager that
            // this RecyclerView will use.
            val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
            val layoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = layoutManager
            // adapter instance is set to the
            // recyclerview to inflate the items.
            recyclerView.adapter = itemAdapter

            val dividerItemDecoration = DividerItemDecoration(recyclerView.context, layoutManager.orientation)
            recyclerView.addItemDecoration(dividerItemDecoration)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark_list, container, false)
    }

}