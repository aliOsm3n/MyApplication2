package com.example.aliothman.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Myservice myservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    Intent intent ;

    public void startbtn(View view) {
        intent = new Intent(this,Myservice.class);
        //startService(intent);
        bindService(intent,mconnection, BIND_AUTO_CREATE);
//        int num =   myservice.getRandomNumber();
//        Toast.makeText(myservice, "the service num :" + num, Toast.LENGTH_SHORT).show();
    }


    public void stopbtn(View view) {
       // stopService(intent);
        unbindService(mconnection);
    }

    public ServiceConnection mconnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
          Myservice.Mybinder mybinder = (Myservice.Mybinder) iBinder;
            MainActivity.this.myservice = mybinder.getservice();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            MainActivity.this.myservice = null;
        }
    };

}
