package com.example.tinku.projectmanagementsystem.fragment.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinku.projectmanagementsystem.R;
import com.example.tinku.projectmanagementsystem.adapter.DetailPagerAdapter;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class DetailFragment extends Fragment implements DetailView,TabLayout.OnTabSelectedListener {
    DetailPresenter detailPresenter;
    TabLayout tabLayout;
    ViewPager viewPager;
    DetailPagerAdapter detailPagerAdapter;
    String taskId;
    String productId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        detailPresenter = new DetailPresenterImpl(this);
        taskId = getArguments().getString("taskId");
        productId = getArguments().getString("productId");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment,container,false);
        detailPresenter.createView(view);
        return view;
    }

    @Override
    public void updateView(View view) {
        /**
         * initialization
         */
        tabLayout = view.findViewById(R.id.tablayout_detail);
        viewPager = view.findViewById(R.id.viewPager_detail);

        tabLayout.addTab(tabLayout.newTab().setText("Task"));
        tabLayout.addTab(tabLayout.newTab().setText("Sub Task"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

//        String taskId = getArguments().getString("taskId");
//        String productId = getArguments().getString("productId");

        detailPagerAdapter = new DetailPagerAdapter(getFragmentManager(),2,taskId,productId);
        viewPager.setAdapter(detailPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position,0,true);
                tabLayout.setSelected(true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
