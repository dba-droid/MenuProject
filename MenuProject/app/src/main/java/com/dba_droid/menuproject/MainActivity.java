package com.dba_droid.menuproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("My title");
            getSupportActionBar().setSubtitle("My subtitle");
            getSupportActionBar().setElevation(30);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                Toast.makeText(this, "home button clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item1: {
                Toast.makeText(this, "item 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item2: {
                Toast.makeText(this, "item 2 clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item3: {
                Toast.makeText(this, "item 3 clicked", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.item4: {
                Toast.makeText(this, "item 4 clicked", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);

    }
}
