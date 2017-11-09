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
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position,  View convertView, ViewGroup parent) {


        //省資源的高級寫法
            Log.d("GETVIEW", "position:" + position);
            ViewHolder holder;
            LayoutInflater inflater = LayoutInflater.from(context);
            if (convertView == null)   //Android 回收機制 , 後面就不用重新new
            {
                convertView = inflater.inflate(R.layout.myitem, null);
                holder = new ViewHolder();
                holder.tv = (TextView) convertView.findViewById(R.id.textView);
                holder.btn = (Button) convertView.findViewById(R.id.button1);
                holder.chk = (CheckBox) convertView.findViewById(R.id.checkbox);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
            final String msg = str[position];
            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                }
            });
            holder.chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    b[position] = isChecked;
                }
            });
            holder.chk.setChecked(b[position]);
            holder.tv.setText(str[position]);


            return convertView;
        }
    static class ViewHolder
    {
        TextView tv;
        Button btn;
        CheckBox chk;
    }
}
/**         =========================================================================== */

            //系統有的
    //        TextView tv = new TextView(context);
    //        tv.setText("Hello World" + position);
    //        return tv;
//            Log.d("GETVIEW" , "position" + position);
//            //自訂的
//            LayoutInflater inflater = LayoutInflater.from(context);
//            if(convertView == null)    //Android 回收機制 , 後面就不用重新new
//            {
//                convertView = inflater.inflate(R.layout.myitem, null);
//            }
//
//            TextView tv = (TextView) convertView.findViewById(R.id.textView);
//            Button btn = (Button) convertView.findViewById(R.id.button1);
//            CheckBox chk = (CheckBox) convertView.findViewById(R.id.checkbox);
//            final String msg = str[position];
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(context , msg , Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    b[position] = isChecked;
//                }
//            });
//            chk.setChecked(b[position]);
//            tv.setText(str[position] );
//            return convertView;
//    }
//
//}
//
