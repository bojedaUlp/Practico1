package com.example.practico1;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class AccionUsb extends BroadcastReceiver {

    public void onReceive(Context ctx, Intent i) {

        if(i.getExtras().getBoolean("connected")) {
            Intent callI = new Intent(Intent.ACTION_CALL);
            callI.setData(Uri.parse("tel:911"));
            if(ActivityCompat.checkSelfPermission(ctx.getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                return;
            }

        ctx.startActivity(callI);
    }
      else{
        Toast.makeText(ctx, "USB desconectado", Toast.LENGTH_LONG).show();
       }
    }
}


