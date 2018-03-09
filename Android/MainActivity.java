package com.example.rajn.oasisfeedback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView smile = (ImageView) findViewById(R.id.smile);
        smile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this,Description.class);
                intent.putExtra("feel","excellent");
                startActivity(intent);
            }
        });

        ImageView good = (ImageView) findViewById(R.id.good);
        good.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this,Description.class);
                intent.putExtra("feel","good");
                startActivity(intent);
            }
        });

        ImageView hector = (ImageView) findViewById(R.id.hector);
        hector.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this,Description.class);
                intent.putExtra("feel","normal");
                startActivity(intent);
            }
        });

        ImageView crying = (ImageView) findViewById(R.id.crying);
        crying.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent intent = new Intent(MainActivity.this,Description.class);
                intent.putExtra("feel","bad");
                startActivity(intent);
            }
        });
    }
}
