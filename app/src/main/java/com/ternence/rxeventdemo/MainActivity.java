package com.ternence.rxeventdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ternence.tevent.RxBus;
import com.ternence.tevent.annotation.Subscribe;
import com.ternence.tevent.annotation.Tag;
import com.ternence.tevent.thread.EventThread;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                RxBus.get().post("1234",view.toString());
            }
        });
        RxBus.get().register(this);
    }

    @Subscribe(tags = {@Tag("test"),@Tag("1234")},thread = EventThread.MAIN_THREAD)
    public void onTextChange(String a)
    {
        Log.e("MainActivity","Thread:" + Thread.currentThread().getName());
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
