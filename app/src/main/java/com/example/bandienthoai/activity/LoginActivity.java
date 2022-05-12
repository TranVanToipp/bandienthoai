package com.example.bandienthoai.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bandienthoai.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    ImageView img_hinhanh;
    TextInputLayout ed_usesname;
    TextInputLayout ed_password;
    Button btnforgot, btn_login, btn_register;

     int REQUEST_CODE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        Anhxa();

        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(LoginActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }





    private void Anhxa() {
        img_hinhanh = (ImageView) findViewById(R.id.al_logo_namelogin);
        ed_usesname = (TextInputLayout) findViewById(R.id.al_ed_Usesname);
        ed_password = (TextInputLayout) findViewById(R.id.al_ed_Password);
        btnforgot = (Button) findViewById(R.id.al_btnforgot);
        btn_login = (Button) findViewById(R.id.al_btnlogin);
        btn_register = (Button) findViewById(R.id.al_btn_nologin);
    }
}