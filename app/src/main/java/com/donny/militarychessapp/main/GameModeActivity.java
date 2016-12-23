package com.donny.militarychessapp.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.donny.militarychessapp.R;

import java.util.ArrayList;
import java.util.List;

public class GameModeActivity extends AppCompatActivity {
    private Button onebtn;
    private Button twobtn;
    private List<String> list = new ArrayList<String>();
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        list = initData();

        onebtn = (Button) findViewById(R.id.button);
        twobtn = (Button) findViewById(R.id.button2);

        onebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ShowDialog();
            }
        });

        twobtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameModeActivity.this,BlueToothMatchActivity.class);
                //设置从右边出现
                GameModeActivity.this.overridePendingTransition(R.anim.initactivity_open, 0);
                startActivity(intent);
            }
        });
    }
    private ArrayList<String> initData() {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 1; i < 7; i++){
            String name = "难度等级"+i;
            list.add(name);
        }
        return list;
    }
    public void ShowDialog() {
        Context context = GameModeActivity.this;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.setlevel, null);
        ListView myListView = (ListView) layout.findViewById(R.id.formcustomspinner_list);
        MyAdapter adapter = new MyAdapter(context, list);
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int positon, long id) {
                //在这里面就是执行点击后要进行的操作,这里只是做一个显示
                Intent intent = new Intent();
                intent.putExtra("level", positon);
                intent.putExtra("mode", 1);
                intent.setClass(GameModeActivity.this, MainActivity.class);
                GameModeActivity.this.startActivity(intent);
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        builder = new AlertDialog.Builder(context);
        builder.setView(layout);
        alertDialog = builder.create();
        alertDialog.show();
    }

    class MyAdapter extends BaseAdapter {
        private List<String> mlist;
        private Context mContext;

        public MyAdapter(Context context, List<String> list) {
            this.mContext = context;
            mlist = new ArrayList<String>();
            this.mlist = list;
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {

            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Person person = null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.rtu_item,null);
                person = new Person();
                person.name = (TextView)convertView.findViewById(R.id.tv_name);
                convertView.setTag(person);
            }else{
                person = (Person)convertView.getTag();
            }
            person.name.setText(list.get(position).toString());
            return convertView;
        }
        class Person{
            TextView name;
        }
    }
}
