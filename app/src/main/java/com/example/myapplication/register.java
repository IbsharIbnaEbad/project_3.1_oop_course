package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class register extends AppCompatActivity {
EditText edtfn,editpass,edtrpass,edtphn,edtsn;
Button btncrtreg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        edtfn=findViewById(R.id.edtfn);
        edtsn=findViewById(R.id.edtsn);
        edtphn=findViewById(R.id.edtphn);
      //  edtpass=findViewById(R.id.edtpass);
        edtrpass=findViewById(R.id.edtrpass);
        btncrtreg=findViewById(R.id.btncrtreg);










        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
}