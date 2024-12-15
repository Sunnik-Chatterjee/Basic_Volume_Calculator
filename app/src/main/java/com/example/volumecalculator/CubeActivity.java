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

public class CubeActivity extends AppCompatActivity {
    EditText length,breadth,height;
    Button cal;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cube);
        length=findViewById(R.id.length);
        breadth=findViewById(R.id.breadth);
        height=findViewById(R.id.height);
        cal=findViewById(R.id.calculate);
        result=findViewById(R.id.Volume);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String len=length.getText().toString();
                String bred=breadth.getText().toString();
                String heigh=height.getText().toString();
                double l,b,h;
                l=Double.parseDouble(len);
                b=Double.parseDouble(bred);
                h=Double.parseDouble(heigh);
                double volume=l*b*h;
                result.setText("Volume: "+volume);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}