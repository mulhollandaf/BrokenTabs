package com.example.brokentabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.tab_fragment.*
import java.util.ArrayList


class TabFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = TabCollectionPagerAdapter(fragmentManager!!)

        tabLayout.setupWithViewPager(viewPager)

        viewPager.adapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.tab_fragment, container, false)
    }
}

class TabCollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val items = ArrayList<Fragment>()
    private val fragmentTitleList = ArrayList<String>()

    init {
        addFragment(FirstTabFragment.newInstance(), "FirstTab")
    }

    override fun getItem(position: Int): Fragment {
        return items[position]
    }

    override fun getCount(): Int {
        return items.size
    }

    private fun addFragment(fragment: Fragment, title: String) {
        items.add(fragment)
        fragmentTitleList.add(title)
        notifyDataSetChanged()
    }

    override fun getPageTitle(position: Int): String {
        return fragmentTitleList[position]
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

}
