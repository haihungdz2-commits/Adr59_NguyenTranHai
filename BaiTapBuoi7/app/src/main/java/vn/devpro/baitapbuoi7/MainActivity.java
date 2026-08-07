package vn.devpro.baitapbuoi7;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView ivAvatar;
    private ImageButton btnEditAvatar;
    private TextView tvName, tvEmail, tvPhone;
    private Button btnGoToEdit;

    // 1. Bộ thu nhận kết quả từ màn hình EditProfile trả về
    private final ActivityResultLauncher<Intent> editProfileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Intent data = result.getData();
                        tvName.setText(data.getStringExtra("NEW_NAME"));
                        tvEmail.setText(data.getStringExtra("NEW_EMAIL"));
                        tvPhone.setText(data.getStringExtra("NEW_PHONE"));
                    }
                }
            }
    );

    // 2. Bộ thu nhận kết quả khi chọn ảnh từ Gallery
    private final ActivityResultLauncher<String> pickImageLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    if (uri != null) {
                        ivAvatar.setImageURI(uri);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivAvatar = findViewById(R.id.ivAvatar);
        btnEditAvatar = findViewById(R.id.btnEditAvatar);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        btnGoToEdit = findViewById(R.id.btnGoToEdit);

        // Click mở màn hình Edit Profile
        btnGoToEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                intent.putExtra("CURRENT_NAME", tvName.getText().toString());
                intent.putExtra("CURRENT_EMAIL", tvEmail.getText().toString());
                intent.putExtra("CURRENT_PHONE", tvPhone.getText().toString());
                editProfileLauncher.launch(intent);
            }
        });

        // Click chọn ảnh Avatar
        btnEditAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageLauncher.launch("image/*");
            }
        });
    }
}