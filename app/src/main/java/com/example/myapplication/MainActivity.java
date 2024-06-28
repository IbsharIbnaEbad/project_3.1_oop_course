package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;*/



        Button btnreg, btnlog;
      //  edtid = findViewById(R.id.edtid);
        //edtpass = findViewById(R.id.edtpass);
        btnlog = findViewById(R.id.btnlog);
        btnreg = findViewById(R.id.btnreg);


        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // btn e click korle jekta oibo ogu ono lekmu
                // bmi t ase kemne amra fetch kormu data xml taki
            }
        });
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inext;//1
                inext = new Intent (MainActivity.this, register.class);//2
                //1 2 line jekuno jaygay dewa jay doesnt matter but start activy btn click er bitore likhte hoy

                startActivity(inext);
            }
            // text dekaimu time faile log in as user dia id dimu
        });


}
}
