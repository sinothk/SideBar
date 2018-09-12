package com.sinothk.sidebar.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sinothk.sidebar.demo.style1.SideBarDemoMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoSideBarDemoMainActivity(View view) {
        startActivity(new Intent(this, SideBarDemoMainActivity.class));
    }

//    public void gotoSwitchTabDemoActivity(View view) {
//        startActivity(new Intent(this, SwitchTabDemoActivity.class));
//    }
//
//    public void gotoMallDetailImageView(View view) {
//        startActivity(new Intent(this, MallDemoImageViewMainActivity.class));
//    }
//
//    public void gotoBannerViewMainActivity(View view) {
//        startActivity(new Intent(this, BannerViewMainActivity.class));
//    }
//
//
//    public void gotoSideBarDemoMainActivity(View view) {
//        startActivity(new Intent(this, SideBarDemoMainActivity.class));
//    }
}
