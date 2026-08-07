package vn.devpro.baitapbuoi7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton; // Thêm import này
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPhone;
    private Button btnSave;
    private ImageButton btnBack; // Khai báo thêm nút Back

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack); // Ánh xạ nút Back

        // Xử lý sự kiện click nút Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng màn hình, quay về Profile
            }
        });

        // Lấy dữ liệu được gửi từ Profile
        Intent intent = getIntent();
        if (intent != null) {
            edtName.setText(intent.getStringExtra("CURRENT_NAME"));
            edtEmail.setText(intent.getStringExtra("CURRENT_EMAIL"));
            edtPhone.setText(intent.getStringExtra("CURRENT_PHONE"));
        }

        // Xử lý nút Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = edtName.getText().toString();
                String newEmail = edtEmail.getText().toString();
                String newPhone = edtPhone.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("NEW_NAME", newName);
                returnIntent.putExtra("NEW_EMAIL", newEmail);
                returnIntent.putExtra("NEW_PHONE", newPhone);

                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}