package my.project.weatherappcourse.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.project.weatherappcourse.R
import my.project.weatherappcourse.databinding.FragmentHoursBinding


class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initRecyclerView() = with(binding) {

    }


    companion object {
        @JvmStatic
        fun newInstance() = HoursFragment()
    }

}