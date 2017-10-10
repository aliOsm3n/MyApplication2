package com.example.aliothman.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Random;

/**
 * Created by AliOthman on 9/18/2017.
 */

public class Myservice extends Service {


    private IBinder binder = new Mybinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Myservice","on create is called >");
    }
    MediaPlayer mediaPlayer = null;

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.e("Myservice","on Start command is called  >");
//       mediaPlayer= mediaPlayer.create(this,R.raw.helena__broken_angel);
//        mediaPlayer.start();
//        new CountDownTimer(3000,1000){
//
//            @Override
//            public void onTick(long l) {
//
//            }
//
//            @Override
//            public void onFinish() {
//                stopSelf();
//            }
//        }.start();
        return  START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Myservice","on  Destroy is called  >");
       // mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Myservice"," Binder is Connected ");
        return binder;
    }


    public class Mybinder extends Binder{
       Myservice getservice(){
         return Myservice.this;
       }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Myservice"," Binder is unConnected ");
        return super.onUnbind(intent);
    }
}
