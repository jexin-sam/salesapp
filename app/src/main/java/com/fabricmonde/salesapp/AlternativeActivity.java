package com.fabricmonde.salesapp;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.fabricmonde.salesapp.fragments.AlternativeStorykit;
import com.fabricmonde.salesapp.interfaces.Interface;
import com.fabricmonde.salesapp.tabadapter.Tab_adapter;
import com.fabricmonde.salesapp.tracemodel.productInfo;
import com.fabricmonde.salesapp.viewpager.CustomViewPager;
import com.google.android.material.tabs.TabLayout;
import com.moos.library.HorizontalProgressView;

import org.jetbrains.annotations.NotNull;

/**
 * All keys be small, Praise Lord!
 */

public class AlternativeActivity extends AppCompatActivity implements AlternativeStorykit.OnFragmentInteractionListener{


    final Context context = AlternativeActivity.this;
    private   productInfo object;
    private Dialog myDialog;



    CustomViewPager viewPager;
    TabLayout tablayout;


    private Typeface mTypeface;
    private Typeface mTypefaceBold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alternative_main);

        viewPager=findViewById(R.id.viewpager);
        tablayout=findViewById(R.id.tablayout1);


        setCustomFontAndStyle(tablayout, 0);
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tablayout.addTab(tablayout.newTab().setText("Path 1"));
        tablayout.addTab(tablayout.newTab().setText("Path 2"));
        tablayout.addTab(tablayout.newTab().setText("Path 3"));
        tablayout.addTab(tablayout.newTab().setText("Path 4"));
        tablayout.addTab(tablayout.newTab().setText("Path 5"));
        tablayout.addTab(tablayout.newTab().setText("Path 6"));
        tablayout.addTab(tablayout.newTab().setText("Path 7"));
        tablayout.addTab(tablayout.newTab().setText("Path 8"));
        tablayout.addTab(tablayout.newTab().setText("Path 9"));
        tablayout.addTab(tablayout.newTab().setText("Path 10"));

        Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
        ViewGroup vg = (ViewGroup) tablayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);

                }
            }
        }


        Tab_adapter adapter = new Tab_adapter(getSupportFragmentManager(), tablayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                LinearLayout tabLayout = (LinearLayout)((ViewGroup) tablayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.BOLD);
                Typeface mTypeface = Typeface.createFromAsset(getAssets(), "fonts/roboto_regular.ttf");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                LinearLayout tabLayout = (LinearLayout)((ViewGroup) tablayout.getChildAt(0)).getChildAt(tab.getPosition());
                TextView tabTextView = (TextView) tabLayout.getChildAt(1);
                tabTextView.setTypeface(tabTextView.getTypeface(), Typeface.NORMAL);


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }


    private void setCustomFontAndStyle(TabLayout tabLayout, Integer position) {

        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/sfpro_display_bold.otf");
        mTypefaceBold = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    if (j == position) {
                        ((TextView) tabViewChild).setTypeface(mTypefaceBold, Typeface.BOLD);
                    } else {
                        ((TextView) tabViewChild).setTypeface(mTypeface, Typeface.NORMAL);
                    }
                }
            }
        }
    }


    @Override
    public void onFragmentInteraction(@NotNull Uri uri) {

    }

}
