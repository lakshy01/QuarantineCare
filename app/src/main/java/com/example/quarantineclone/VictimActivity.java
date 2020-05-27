package com.example.quarantineclone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class VictimActivity extends AppCompatActivity {

    private Button clickButton;

    BottomNavigationView navView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victim);

        clickButton = findViewById(R.id.clickButton);
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPicture();
            }
        });
    }

    public void BtnSetEmergency_onClick(View view){
        String number="8920654112";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: "+ number));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(intent);
    }

    private void openPicture() {
        Intent mainIntent = new Intent(VictimActivity.this, Picture.class);
        startActivity(mainIntent);
        finish();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override

        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    Intent mainIntent = new Intent(VictimActivity.this, VictimActivity.class);
                    startActivity(mainIntent);
                    break;

                case R.id.navigation_settings:
                    Intent settingsIntent = new Intent(VictimActivity.this, SettingActivity.class);
                    startActivity(settingsIntent);
                    break;

                case R.id.navigation_notifications:
                    Intent notificationsIntent = new Intent(VictimActivity.this, NotificationActivity.class);
                    startActivity(notificationsIntent);
                    break;

                case R.id.navigation_logout:
                    FirebaseAuth.getInstance().signOut();
                    Intent logoutIntent = new Intent(VictimActivity.this, LoginPage.class);
                    startActivity(logoutIntent);
                    finish();

                case R.id.navigation_map:
                    FirebaseAuth.getInstance().signOut();
                    Intent mapIntent = new Intent(VictimActivity.this, MainActivity.class);
                    startActivity(mapIntent);
                    finish();
            }
            return true;
        }
    };


}
