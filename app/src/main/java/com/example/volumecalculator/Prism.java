package com.example.volumecalculator;

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

public class Prism extends AppCompatActivity {
    EditText lengthB,breadthB,height;
    Button cal;
    TextView vol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        lengthB=findViewById(R.id.length);
        breadthB=findViewById(R.id.breadth);
        height=findViewById(R.id.height);
        cal=findViewById(R.id.calculate);
        vol=findViewById(R.id.Volume);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String len,bread,heigh;
                len=lengthB.getText().toString();
                bread=breadthB.getText().toString();
                heigh=height.getText().toString();
                double l,b,h,volume;
                l=Double.parseDouble(len);
                b=Double.parseDouble(bread);
                h=Double.parseDouble(heigh);
                volume=l*b*h;
                vol.setText("Volume: "+volume);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}