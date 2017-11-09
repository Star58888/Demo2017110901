package com.star.demo2017110901;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView lv;
    String names[] = {"Bob", "John", "Mary", "Jane", "Peter", "Amy"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(MainActivity.this, names);
        lv.setAdapter(adapter);
    }
}
