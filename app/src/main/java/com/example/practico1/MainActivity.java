package com.example.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private AccionUsb us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
        this.us=new AccionUsb();
        registerReceiver(this.us,new IntentFilter("android.Hardware.USB.action.USB_STATE"));
    }

    protected void onPause(){
        super.onPause();
        unregisterReceiver(us);
    }

}
