package com.example.volumecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Shape> shapeArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Layout
        gridView=findViewById(R.id.GridView);
        //Data
        shapeArrayList=new ArrayList<>();
        Shape cube=new Shape(R.drawable.cube,"Cube");
        Shape cylinder=new Shape(R.drawable.cylinder,"Cylinder");
        Shape prism=new Shape(R.drawable.prism,"Prism");
        Shape sphere=new Shape(R.drawable.sphere,"Sphere");
        shapeArrayList.add(cube);
        shapeArrayList.add(cylinder);
        shapeArrayList.add(prism);
        shapeArrayList.add(sphere);
        //Adapter
        MyCustomAdapter adapter=new MyCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String shape=shapeArrayList.get(position).getShapeText();
                goToCalculator(shape);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void goToCalculator(String shapeType){
        Class<?>targetActivity;
        if(shapeType=="Cube"){
            targetActivity=CubeActivity.class;
        }else if(shapeType=="Cylinder") {
            targetActivity = Cylinder.class;
        }else if(shapeType=="Prism"){
            targetActivity=Prism.class;
        }else if(shapeType=="Sphere"){
            targetActivity= Sphere.class;
        }else{
            targetActivity=null;
        }
        if(targetActivity!=null) {
            Intent intent = new Intent(MainActivity.this,targetActivity);
            startActivity(intent);
        }
    }
}