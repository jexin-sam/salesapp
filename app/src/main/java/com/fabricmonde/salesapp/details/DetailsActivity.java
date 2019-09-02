package com.fabricmonde.salesapp.details;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.fabricmonde.salesapp.AppState;
import com.fabricmonde.salesapp.R;
import com.fabricmonde.salesapp.utils.GlideApp;


import java.util.ArrayList;

import io.bloco.faker.Faker;

public class DetailsActivity extends AppCompatActivity implements AppState.FakerReadyListener {

    private static final int ITEM_COUNT = 4;

    private static final String BUNDLE_NAME = "BUNDLE_NAME";
    private static final String BUNDLE_INFO = "BUNDLE_INFO";
    private static final String BUNDLE_AVATAR_URL = "BUNDLE_AVATAR_URL";

    private final ArrayList<DetailsData> mListData = new ArrayList<>();

    public static void start(final Context activity,
                             final String name, final String address, final String url,
                             final View root) {
        Intent starter = new Intent(activity, DetailsActivity.class);

        starter.putExtra(BUNDLE_NAME, name);
        starter.putExtra(BUNDLE_INFO, address);
        starter.putExtra(BUNDLE_AVATAR_URL, url);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Pair<View, String> p1 = Pair.create(root, activity.getString(R.string.transition_card));

            final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation((Activity) activity, p1);
            activity.startActivity(starter, options.toBundle());
        } else {
            activity.startActivity(starter);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ((AppState)getApplication()).addListener(this);

        ((TextView) findViewById(R.id.tv_name)).setText(getIntent().getStringExtra(BUNDLE_NAME));
        ((TextView) findViewById(R.id.tv_info)).setText(getIntent().getStringExtra(BUNDLE_INFO));
//        ((ImageView) findViewById(R.id.iv_background).setBackground());

        GlideApp.with(this)
                .load(getIntent().getStringExtra(BUNDLE_AVATAR_URL))
                .into((ImageView) findViewById(R.id.iv_background));
    }

    @Override
    public void onFakerReady(Faker faker) {
//        ((TextView) findViewById(R.id.tv_status)).setText(faker.book.title());
        for (int i = 0; i < ITEM_COUNT; i++) {
            mListData.add(new DetailsData(faker.book.title(), faker.name.name()));
        }

        ((RecyclerView)findViewById(R.id.recycler_view)).setAdapter(new DetailsAdapter(mListData));
    }

    public void onCloseClick(View v) {

        super.onBackPressed();

    }



}


