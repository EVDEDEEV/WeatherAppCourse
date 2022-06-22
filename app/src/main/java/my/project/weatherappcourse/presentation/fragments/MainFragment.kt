package my.project.weatherappcourse.presentation.fragments

import android.Manifest
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import my.project.weatherappcourse.R
import my.project.weatherappcourse.databinding.ActivityMainBinding
import my.project.weatherappcourse.databinding.FragmentMainBinding
import my.project.weatherappcourse.presentation.adapters.ViewPagerAdapter


class MainFragment : Fragment() {

    private val fragmentList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private val tabList = listOf(
        "Hours",
        "Days"
    )
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
    }

    private fun init() = with(binding) {
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fragmentList)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = tabList[pos]
        }.attach()
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()) {
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPermission() {
        if (!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            /*Если нет разрешения(проверка на строку выше), то запрашиваем разрешение.
            Если разрешение есть, то ничего не делаем. */
            permissionListener() //Ждем результат дал пользователь разрешение или нет
            //Запускаем диалог, чтобы он спросил пользователя
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}