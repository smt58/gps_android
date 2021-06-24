package com.example.pc.gps_konum;

import android.app.PendingIntent;
import android.content.Intent;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.location.LocationResult;

public abstract class MyLocationService extends BroadcastReceiver {
    public static final String ACTION_PROCESS_UPDATE= "com.example.pc.background.UPDATE_LOCATION";




    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){

            final String action=intent.getAction();
            //System.out.println(action);
            if(true){

                LocationResult result=LocationResult.extractResult(intent);
                if(result!=null){


                    Location location=result.getLastLocation();
                    String location_string=new StringBuilder(""+location.getLatitude())
                            .append("/")
                            .append(location.getLongitude())
                            .toString();

                    try {
                        MainActivity.getInstance().updatetextwiew(location_string);

                    }catch (Exception ex){

                        Toast.makeText(context,location_string,Toast.LENGTH_SHORT).show();


                    }

                }
            }else{}


        }




    }

}


