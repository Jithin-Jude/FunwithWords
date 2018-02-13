package com.inc.mountzoft.funwithwords;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class timeup extends AppCompatActivity {
    String givenWrds_display = null;
    int level;
    void go(){

        global_var.timeupBgm.stop();
        Intent intent = new Intent(this, user_input.class);
        intent.putExtra("givenWrds_display",givenWrds_display);
        intent.putExtra("level_pass",level);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_timeup);
        global_var.timeupBgm.start();

        Intent intent = getIntent();
        givenWrds_display = intent.getStringExtra("givenWrds_display");
        level = intent.getIntExtra("level_pass",0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                go();
            }
        }, 1000);
    }
    @Override
    public void onBackPressed() {}

    @Override
    protected void onStop() {
        super.onStop();
    }
}
