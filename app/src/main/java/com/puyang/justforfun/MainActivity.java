package com.puyang.justforfun;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.puyang.R;
import com.puyang.animation.AllAnimation;
import com.puyang.colorful.Colorful;
import com.puyang.colorful.ViewGroupSetter;
import com.puyang.receivers.UserDefinedReceiver;

public class MainActivity extends Activity implements View.OnClickListener{

    private int symbol = 0;
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.LightAppTheme);
        setContentView(R.layout.activity_main);
        Log.i("info", "onCreate");
        *//*new AlertDialog.Builder(this).setSingleChoiceItems(new String[]{"1", "2", "3"}, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();

        new AlertDialog.Builder(this).setMultiChoiceItems(new String[]{"1", "2", "3"}, new boolean[]{false, false, true}, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

            }
        }).show();

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*//*
        findViewById(R.id.favorite_list_edit_button).setOnClickListener(this);
    }*/

    ListView mNewsListView;
    List<String> mNewsList = new ArrayList<String>();
    Colorful mColorful;
    boolean isNight = false;

    public static final String TAG_RECEIVER = "android.com.user.defined.receiver";

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(TAG_RECEIVER);
        sendBroadcast(intent);
        localBroadcastManager.sendBroadcast(intent);
    }

    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //local broadcast mechanism
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TAG_RECEIVER);

        localBroadcastManager.registerReceiver(new UserDefinedReceiver(), intentFilter);
        /*// 换肤事件
        findViewById(R.id.change_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeThemeWithColorful();
            }
        });

        // 第二个Activity,显示的是RecyclerVoew
        findViewById(R.id.second_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        AllAnimation.class);
                startActivity(intent);
            }
        });

        mNewsListView = (ListView) findViewById(R.id.listview);
        // 模拟数据
        mockNews();
        mNewsListView.setAdapter(new NewsAdapter());

        // 初始化Colorful
        setupColorful();*/
    }

    /**
     * 设置各个视图与颜色属性的关联
     */
    private void setupColorful() {
        ViewGroupSetter listViewSetter = new ViewGroupSetter(mNewsListView);
        // 绑定ListView的Item View中的news_title视图，在换肤时修改它的text_color属性
        listViewSetter.childViewTextColor(R.id.news_title, R.attr.text_color);

        // 构建Colorful对象来绑定View与属性的对象关系
        mColorful = new Colorful.Builder(this)
                .backgroundDrawable(R.id.root_view, R.attr.root_view_bg)
                        // 设置view的背景图片
                .backgroundColor(R.id.change_btn, R.attr.btn_bg)
                        // 设置背景色
                .textColor(R.id.textview, R.attr.text_color)
                .setter(listViewSetter) // 手动设置setter
                .create(); // 设置文本颜色
    }

    /**
     * 切换主题
     */
    private void changeThemeWithColorful() {
        if (!isNight) {
            mColorful.setTheme(R.style.DarkAppTheme);
        } else {
            mColorful.setTheme(R.style.LightAppTheme);
        }
        isNight = !isNight;
    }

    private void mockNews() {
        for (int i = 0; i < 20; i++) {
            mNewsList.add("News Title - " + i);
        }
    }

    /**
     *
     * @author mrsimple
     *
     */
    class NewsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mNewsList.size();
        }

        @Override
        public String getItem(int position) {
            return mNewsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            NewsViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.news_lv_item, parent, false);
                viewHolder = new NewsViewHolder();
                viewHolder.newsTitleView = (TextView) convertView
                        .findViewById(R.id.news_title);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (NewsViewHolder) convertView.getTag();
            }

            viewHolder.newsTitleView.setText(getItem(position));
            return convertView;
        }

    }

    public static class NewsViewHolder {
        public TextView newsTitleView;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
