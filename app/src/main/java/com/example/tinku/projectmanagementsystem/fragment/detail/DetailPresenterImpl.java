package com.example.tinku.projectmanagementsystem.fragment.detail;

import android.view.View;

/**
 * Created by KinhangPoon on 5/3/2018.
 */

public class DetailPresenterImpl implements DetailPresenter {
    DetailView detailView;

    public DetailPresenterImpl(DetailFragment detailFragment) {
        detailView = detailFragment;
    }

    @Override
    public void createView(View view) {
        detailView.updateView(view);
    }
}
