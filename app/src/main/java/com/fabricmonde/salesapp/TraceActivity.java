package com.fabricmonde.salesapp;



import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.fabricmonde.salesapp.fragments.MapFragment;
import com.fabricmonde.salesapp.fragments.TraceStorykit;
import com.fabricmonde.salesapp.interfaces.Interface;
import com.fabricmonde.salesapp.tracemodel.productInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moos.library.HorizontalProgressView;

import org.jetbrains.annotations.NotNull;

/**
 * All keys be small, Praise Lord!
 */

public class TraceActivity extends AppCompatActivity implements TraceStorykit.OnFragmentInteractionListener, Interface{


    final Context context = TraceActivity.this;
    private   productInfo object;
    private Dialog myDialog;
    private final String TAG = "TRACER";
    productInfo post = null;
    HorizontalProgressView progressbar_width,progressbar_count,progressbar_construction,progressbar_gsm,progressbar_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trace_main);


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("products").child("KCA2PL132");
        ValueEventListener Listener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                post = dataSnapshot.getValue(productInfo.class);
                UpdateData(post);
                Log.i(TAG, "onDataChange: "+post.getpBulkprice()+dataSnapshot.exists());

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        };
        mDatabase.addValueEventListener(Listener);
         progressbar_width = findViewById(R.id.progressbar_width);
         progressbar_count = findViewById(R.id.progressbar_count);
         progressbar_construction = findViewById(R.id.progressbar_construction);
         progressbar_gsm = findViewById(R.id.progressbar_gsm);
         progressbar_color = findViewById(R.id.progressbar_color);

        progressbar_width.setProgressViewUpdateListener(new HorizontalProgressView.HorizontalProgressUpdateListener() {

            @Override
            public void onHorizontalProgressStart(View view) {
            }
            @Override
            public void onHorizontalProgressUpdate(View view,float progress) {
                /**
                 * you can detail with progressViews' animate event and customize their animate order
                 */
            }
            @Override
            public void onHorizontalProgressFinished(View view) {

            }
        });
        Flag flag = new Flag();
        flag.setListener(new Flag.ChangeListener() {
            @Override
            public void onChange(boolean bool) {
                if(flag.getBoolean())
                {
                    progressbar_width.startProgressAnimation();
                    progressbar_count.startProgressAnimation();
                    progressbar_construction.startProgressAnimation();
                    progressbar_gsm.startProgressAnimation();
                    progressbar_color.startProgressAnimation();
                }
            }
        });

        ScrollView scroll = findViewById(R.id.scroll);
        LinearLayout quality = findViewById(R.id.quality);
        scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                Rect scrollBounds = new Rect();
                v.getHitRect(scrollBounds);
                if (!quality.getLocalVisibleRect(scrollBounds)
                        || scrollBounds.height() < quality.getHeight()) {
                    // imageView is not within or only partially within the visible window
                    Log.i("SCROLLSTUFF", "PARTIAL  X: "+scrollX+" Y: "+scrollY);

                } else {
                    // imageView is completely visible
                    Log.i("SCROLLSTUFF", "FULL  X: "+scrollX+" Y: "+scrollY);
                    flag.setBoolean(true);
                }

            }
        });
    }

    private void UpdateData(productInfo post) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, new TraceStorykit())
                .commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_map, new MapFragment())
                .commit();
        TextView Compostion , Width, Count, Construction, GSM,Weave,Finish;
        Compostion = findViewById(R.id.mCompostion);
        Compostion.setText(post.getpComposition());
        Width = findViewById(R.id.mWidth);
        Width.setText(post.getpWidth());
        Count = findViewById(R.id.mCount);
        Count.setText(post.getpCount());
        Construction = findViewById(R.id.mConstruction);
        Construction.setText(post.getpConstruction());
        GSM = findViewById(R.id.mGSM);
        GSM.setText(post.getpGsm());
        Weave = findViewById(R.id.mWeave);
        Weave.setText(post.getpWeave());
        Finish =findViewById(R.id.mFinish);
        Finish.setText(post.getpFinish());
        progressbar_width.setEndProgress(post.getpProgress_width());
        progressbar_count.setEndProgress(post.getpProgress_count());
        progressbar_construction.setEndProgress(post.getpProgress_construction());
        progressbar_gsm.setEndProgress(post.getpProgress_gsm());
        progressbar_color.setEndProgress(post.getpProgress_color());
    }
    @Override
    public void onFragmentInteraction(@NotNull Uri uri) {
    }

    @Override
    public productInfo getProductData() {
        if(post!= null)
        return post;
        else
            return new productInfo();
    }
}
