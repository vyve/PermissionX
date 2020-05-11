package com.permissionx.app;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.permissionx.wxc.IPermissionXCallBack;
import com.permissionx.wxc.PermissionX;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionX.INSTANCE.request(MainJavaActivity.this, new String[]{Manifest.permission.CALL_PHONE}, new IPermissionXCallBack() {
                    @Override
                    public void callBack(boolean granted, @NotNull List<String> deniedList) {
                        if (granted) {
                            Toast.makeText(MainJavaActivity.this, "拨打电话", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You denied $deniedList", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
