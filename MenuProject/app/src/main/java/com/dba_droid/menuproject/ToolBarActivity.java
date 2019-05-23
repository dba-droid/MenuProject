package com.dba_droid.menuproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
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
