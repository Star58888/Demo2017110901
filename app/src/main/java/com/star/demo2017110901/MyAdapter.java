package com.star.demo2017110901;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Star on 2017/11/9.
 */

public class MyAdapter extends BaseAdapter {

    Context context ;
    String str [];

    public boolean [] b;

    public MyAdapter(Context context , String[] str)
        {
            this.context = context;
            this.str = str;
            b = new boolean[str.length];

        }
        @Override
        public int getCount() {
            return str.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {
            //系統有的
    //        TextView tv = new TextView(context);
    //        tv.setText("Hello World" + position);
    //        return tv;
            Log.d("GETVIEW" , "position" + position);
            //自訂的
            LayoutInflater inflater = LayoutInflater.from(context);
            View v = inflater.inflate(R.layout.myitem, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);
            Button btn = (Button) v.findViewById(R.id.button1);
            CheckBox chk = (CheckBox) v.findViewById(R.id.checkbox);
            final String msg = str[position];
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context , msg , Toast.LENGTH_SHORT).show();
                }
            });

            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    b[position] = isChecked;
                }
            });
            chk.setChecked(b[position]);
            tv.setText(str[position] );
            return v;

    }

}
