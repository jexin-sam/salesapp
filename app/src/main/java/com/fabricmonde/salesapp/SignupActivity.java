package com.fabricmonde.salesapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {

    TextView gestures;
    RelativeLayout View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /**
        gestures = findViewById(R.id.gestures);
        View = findViewById(R.id.View);
        SimpleFingerGestures sfg = new SimpleFingerGestures();
        sfg.setDebug(true);
        sfg.setConsumeTouchEvents(true);

        sfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
            @Override
            public boolean onSwipeUp(int fingers, long gestureDuration, double gestureDistance) {
                gestures.setText("You swiped " + fingers + " fingers  up " );
                return false;
            }
            @Override
            public boolean onSwipeDown(int fingers, long gestureDuration, double gestureDistance) {
                gestures.setText("You swiped " + fingers + " fingers  down " );
                return false;
            }

            @Override
            public boolean onSwipeLeft(int fingers, long gestureDuration, double gestureDistance) {
                gestures.setText("You swiped " + fingers + " fingers  left " );
                return false;
            }
            @Override
            public boolean onSwipeRight(int fingers, long gestureDuration, double gestureDistance) {
                gestures.setText("You swiped " + fingers + " fingers  right ");
                return false;
            }

            @Override
            public boolean onPinch(int fingers, long gestureDuration, double gestureDistance) {
                gestures.setText("You pinched " + fingers + " fingers ");
                return false;
            }

            @Override
            public boolean onUnpinch(int fingers, long gestureDuration, double gestureDistance) {
                gestures.setText("You unpinched " + fingers + "fingers");
                return false;
            }

            @Override
            public boolean onDoubleTap(int fingers) {
                gestures.setText("You double tapped");
                return false;
            }
        });


        View.setOnTouchListener(sfg);

         */
    }
}
