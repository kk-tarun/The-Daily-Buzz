package com.example.thedailybuzz

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabsAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getItem(position:Int): Fragment {
        var fragment:Fragment?=null
        if(position==0)
            fragment=India()
        else if(position==1)
            fragment=World()
        else if(position==2)
            fragment=Technology()
        else if(position==3)
            fragment=Science()
        return fragment!!
    }

    override fun getCount():Int{
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title:String?=null
        when (position) {
            0 -> title="India"
            1 -> title="World"
            2 -> title="Tech"
            3 -> title="Science"
        }
        return title
    }
}