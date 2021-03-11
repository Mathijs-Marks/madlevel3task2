package com.example.madlevel3task2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madlevel3task2.databinding.FragmentPortalsBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalsFragment : Fragment() {

    private var _binding: FragmentPortalsBinding? = null
    private val binding get() = _binding!!

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals) { portal: Portal -> portalItemClicked(portal) }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPortalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeAddPortalResult()
    }

    private fun initViews() {
        // Initialize the recycler view with a grid layout manager, adapter.
        binding.rvPortals.layoutManager =
                GridLayoutManager(context, 2)
        binding.rvPortals.adapter = portalAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeAddPortalResult() {
        setFragmentResultListener(REQ_PORTAL_KEY) { _, bundle ->
            bundle.getParcelable<Portal>(BUNDLE_PORTAL_KEY)?.let {
                val portal = it

                portals.add(portal)
                portalAdapter.notifyDataSetChanged()
            } ?: Log.e("PortalFragment", "Request triggered, but empty portal!")
        }
    }

    private fun portalItemClicked(portal: Portal) {
        Toast.makeText(activity, "Clicked: ${portal.portalText}", Toast.LENGTH_LONG).show()
    }
}