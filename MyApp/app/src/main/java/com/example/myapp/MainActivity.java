package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout draw;
    private LinearLayout line;
    private Toolbar tool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        draw = findViewById(R.id.Drawer);
        line = findViewById(R.id.line);
        tool = findViewById(R.id.toolbar);
        setSupportActionBar(tool);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,draw,tool, R.string.open_navigation_drawer, R.string.close_navigation_drawer) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float sidebar = drawerView.getWidth() * slideOffset;
                line.setTranslationX(sidebar);
            }
        };

        draw.addDrawerListener(toggle);
        toggle.syncState();


    }
}


