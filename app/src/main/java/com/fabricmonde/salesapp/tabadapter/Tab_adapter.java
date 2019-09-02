package com.fabricmonde.salesapp.tabadapter;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.fabricmonde.salesapp.fragments.AlternativeStorykit;


public class Tab_adapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public Tab_adapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }



    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AlternativeStorykit tab1= new AlternativeStorykit();
                return tab1;
            case 1:
                AlternativeStorykit tab2= new AlternativeStorykit();
                return tab2;
            case 2:
                AlternativeStorykit tab3= new AlternativeStorykit();
                return tab3;
            case 3:
                AlternativeStorykit tab4= new AlternativeStorykit();
                return tab4;
            case 4:
                AlternativeStorykit tab5= new AlternativeStorykit();
                return tab5;
            case 5:
                AlternativeStorykit tab6= new AlternativeStorykit();
                return tab6;
            case 6:
                AlternativeStorykit tab7= new AlternativeStorykit();
                return tab7;
            case 7:
                AlternativeStorykit tab8= new AlternativeStorykit();
                return tab8;
            case 8:
                AlternativeStorykit tab9= new AlternativeStorykit();
                return tab9;
            case 9:
                AlternativeStorykit tab10= new AlternativeStorykit();
                return tab10;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
