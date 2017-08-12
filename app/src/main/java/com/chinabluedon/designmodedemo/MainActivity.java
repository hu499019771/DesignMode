package com.chinabluedon.designmodedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.chinabluedon.designmodedemo.builder.Computer;
import com.chinabluedon.designmodedemo.builder.MacBuilder;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Computer computer = new MacBuilder()
                        .board("mac 10.0")
                        .display("三星显示器")
                        .os("mac 12.0系统")
                        .create();
                Toast.makeText(MainActivity.this, computer.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
