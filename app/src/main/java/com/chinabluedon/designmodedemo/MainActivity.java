package com.chinabluedon.designmodedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chinabluedon.designmodedemo.uml.ImageActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                startActivity(new Intent(MainActivity.this, ImageActivity.class));
            }
        });

/*        Computer computer = new MacBuilder()
                .board("苹果10主板")
                .display("三星显示器")
                .os("mac 12.0系统")
                .create();
        Toast.makeText(MainActivity.this, computer.toString(), Toast.LENGTH_SHORT).show();*/

    }
}
