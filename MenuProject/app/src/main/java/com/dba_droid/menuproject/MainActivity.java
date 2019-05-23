package com.dba_droid.menuproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] data = new String[] { "one", "two", "three" };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("My title");
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setSubtitle("My subtitle");
            getSupportActionBar().setElevation(30);


            Spinner spinner = findViewById(R.id.spinner);

            ArrayAdapter<CharSequence> adapter;
//                 adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item, data);
                 adapter = ArrayAdapter.createFromResource(this, R.array.dayofweek, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.i("TAG", "onItemSelected, pos: " + position + ", id: " + id);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    Log.i("TAG", "onNothingSelected");
                }
            });
            spinner.setAdapter(adapter);
        }

        startActivity(new Intent(this, ToolBarActivity.class));
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
