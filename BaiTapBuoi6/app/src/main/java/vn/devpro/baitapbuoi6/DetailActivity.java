package vn.devpro.baitapbuoi6;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private ImageView ivFullImage;
    private ImageButton btnBackDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ivFullImage = findViewById(R.id.ivFullImage);
        btnBackDetail = findViewById(R.id.btnBackDetail);


        int imageId = getIntent().getIntExtra("IMAGE_ID", 0);
        if (imageId != 0) {
            ivFullImage.setImageResource(imageId);
        }


        btnBackDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}