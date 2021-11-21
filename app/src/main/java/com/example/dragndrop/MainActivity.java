package com.example.dragndrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3, dragToImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        dragToImageView = findViewById(R.id.targetForDrop);

        imageView1.setOnLongClickListener(longClickListener);
        imageView2.setOnLongClickListener(longClickListener);
        imageView3.setOnLongClickListener(longClickListener);

        dragToImageView.setOnDragListener(dragListener);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener(){

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int dragEventAction = dragEvent.getAction();

            switch(dragEventAction){
                case DragEvent.ACTION_DRAG_ENTERED:
                    final View v = (View)dragEvent.getLocalState();
                    Log.e("view entered", "view with id " + v.getId() + "entered");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //kode til at reset position er her
                    break;
                case DragEvent.ACTION_DROP:
                    //Kode for at sætte pusle spillet fast er her
                    break;
            }
            return true;
        }
    };
}