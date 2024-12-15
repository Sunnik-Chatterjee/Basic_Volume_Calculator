package com.example.volumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapesArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapesArrayList,Context context) {
        super(context, R.layout.grid_item_layout,shapesArrayList);
        this.shapesArrayList=shapesArrayList;
        this.context=context;
    }
    //Hold the refrences
    private static class ViewHolder{
        TextView ShapeText;
        ImageView ShapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get the shape of the current position
        Shape shape=getItem(position);
        //Inflating Layout
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.grid_item_layout,parent,false);
            //Finding Values
            viewHolder.ShapeText=(TextView) convertView.findViewById(R.id.Shape);
            viewHolder.ShapeImage=(ImageView) convertView.findViewById(R.id.ShapeImage);
            //Setting the views
            convertView.setTag(viewHolder);

        }else{
            //A view went off-screen -->for resuing it
                viewHolder=(ViewHolder) convertView.getTag();
        }
        //Getting the data
        viewHolder.ShapeText.setText(shape.getShapeText());
        viewHolder.ShapeImage.setImageResource((shape.getShapeImage()));

        return convertView;
    }
}
