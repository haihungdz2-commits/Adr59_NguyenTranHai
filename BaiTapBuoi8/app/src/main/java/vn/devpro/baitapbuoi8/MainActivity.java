package vn.devpro.baitapbuoi8;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel viewModel;
    private SharedPreferences prefs;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        Button btnIncrement = findViewById(R.id.btnIncrement);
        Button btnDecrement = findViewById(R.id.btnDecrement);
        Button btnReset = findViewById(R.id.btnReset);

        // TODO 5: Khởi tạo SharedPreferences
        prefs = getSharedPreferences("counter_prefs", MODE_PRIVATE);

        // TODO 6: Create ViewModel
        viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // TODO 7: Load giá trị count đã lưu trước đó vào viewmodel
        viewModel.loadCount(prefs);

        // TODO 8: Observe LiveData và update count lên TextView
        viewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvCount.setText(String.valueOf(integer));
            }
        });

        // TODO 9: Xử lý click cho các nút tăng, giảm, reset
        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.increment(prefs);
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.decrement(prefs);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.reset(prefs);
            }
        });
    }
}