package com.example.doan_appchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager myviewPager;
    private TabLayout mytabLayout;
    private TabsAccessorAdapter mytabsAccessorAdapter;
    private FirebaseAuth currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.main_page_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("doan-appchat");

        myviewPager=findViewById(R.id.main_tabs_pager);
        mytabsAccessorAdapter=new TabsAccessorAdapter(getSupportFragmentManager());
        myviewPager.setAdapter(mytabsAccessorAdapter);

        mytabLayout=findViewById(R.id.main_tabs);
        mytabLayout.setupWithViewPager(myviewPager);
    }
    @Override
    protected void onStart() {
        super.onStart();

        if(currentUser==null)
        {
            sendUserToLoginActivity();
        }

    }
    private void sendUserToLoginActivity() {
        Intent loginintent=new Intent(MainActivity.this,RegisterActivity.class);
        loginintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginintent);
        finish();
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.options_menu,menu);
//
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id=item.getItemId();
//        if(id==R.id.main_find_friends_menu)
//        {
//            //sendUserToFindFriendsActivity();
//        }
//        else if(id==R.id.main_settings_menu)
//        {
//            //sendUserToSettingsActivity();
//        }
//        else if(id==R.id.main_logout_menu)
//        {
//            //updateUserStatus("offline");
//            currentUser.signOut();
//            sendUserToLoginActivity();
//            Toast.makeText(MainActivity.this,"User logged out succuessfully...",Toast.LENGTH_SHORT).show();
//        }
//       /* else if(id==R.id.main_create_group_menu)
//        {
//            RequestNewGroup();
//        }*/
//        return true;
//    }
}