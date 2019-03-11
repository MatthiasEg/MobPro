package ch.hslu.mobpro.ui_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ViewsDemoActivity extends AppCompatActivity {

    private RatingBar ratingBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views_demo);

        this.ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        final TextView ratingBarTextView = (TextView) findViewById(R.id.textViewRating);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBarTextView.setText("Neue Bewertung: " + rating);
            }
        });

    }


}