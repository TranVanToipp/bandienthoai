package com.example.bandienthoai.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.bandienthoai.R;
import com.google.android.material.textfield.TextInputLayout;

public class ChangePasswordActivity extends AppCompatActivity {

    TextInputLayout ed_password_cu;
    TextInputLayout ed_password_moi;
    TextInputLayout ed_password_moi2;
    Button btnXacnhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password2);
        Anhxa();
        Intent intent = getIntent();

        String noiDung = intent.getStringExtra("password");
//        ed_password_moi2.setTextInputAccessibilityDelegate();
    }

    private void Anhxa() {
        ed_password_cu = findViewById(R.id.acp_password_cu);
        ed_password_moi = findViewById(R.id.acp_password1);
        ed_password_moi2 = findViewById(R.id.acp_password_nhaplai2);
        btnXacnhan = findViewById(R.id.acp_Xacnhan);
    }
}