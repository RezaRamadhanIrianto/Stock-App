package com.froyout.stockmvvm.modules.detail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.databinding.FragmentImbalHasilBinding

class ImbalHasilFragment : Fragment() {
    private var _binding: FragmentImbalHasilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImbalHasilBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment = DetailTimeFragment(0)
        val tr  = childFragmentManager.beginTransaction()
        tr.replace(binding.lytParent.id, fragment)
        tr.commit()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}