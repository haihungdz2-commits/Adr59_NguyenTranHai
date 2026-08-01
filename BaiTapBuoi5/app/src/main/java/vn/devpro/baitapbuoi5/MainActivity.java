package vn.devpro.baitapbuoi5;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView ivPhoto;
    private ImageButton btnBack, btnNext;
    private TextView tvCounter;


    private int[] images = {R.drawable.img1, R.drawable.img2, R.drawable.img3};


    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivPhoto = findViewById(R.id.ivPhoto);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        tvCounter = findViewById(R.id.tvCounter);


        updateUI();


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateUI();
                }
            }
        });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex < images.length - 1) {
                    currentIndex++;
                    updateUI();
                }
            }
        });
    }


    private void updateUI() {

        ivPhoto.setImageResource(images[currentIndex]);


        tvCounter.setText((currentIndex + 1) + " / " + images.length);


        if (currentIndex == 0) {
            btnBack.setVisibility(View.INVISIBLE);
        } else {
            btnBack.setVisibility(View.VISIBLE);
        }


        if (currentIndex == images.length - 1) {
            btnNext.setVisibility(View.INVISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
        }
    }
}