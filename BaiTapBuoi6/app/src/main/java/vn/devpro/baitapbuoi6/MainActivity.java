package vn.devpro.baitapbuoi6;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPinterest;


    private int[] images = {
            R.drawable.pin1, R.drawable.pin2, R.drawable.pin3,
            R.drawable.pin4, R.drawable.pin5, R.drawable.pin6,
            R.drawable.pin7, R.drawable.pin8, R.drawable.pin9,
            R.drawable.pin10
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPinterest = findViewById(R.id.rvPinterest);


        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvPinterest.setLayoutManager(layoutManager);


        PinterestAdapter adapter = new PinterestAdapter(this, images);
        rvPinterest.setAdapter(adapter);
    }
}