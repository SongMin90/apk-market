package com.example.apk.market.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.apk.market.R;
import com.example.apk.market.download.DownLoadAcitivity;
import com.example.apk.market.search.SearchAcitivity;
import com.example.apk.market.setting.SettingActivity;
import com.example.apk.market.xiaomi.AppInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by asus on 2017/11/1.
 */

public class SameAppActivity extends AppCompatActivity {

    @BindView(R.id.detail_tv_title)
    TextView mTvTitle;
    @BindView(R.id.search_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.sameapp_rv_result)
    RecyclerView mRvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sameapp);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        initView();

    }

    private void initView() {
        ArrayList<AppInfo> appInfoList = getIntent().getParcelableArrayListExtra("appInfoList");
        Log.d("test", "同开发者应用：" + appInfoList.size());

    }

    public static void startActivity(Context context, ArrayList<AppInfo> appInfoList) {
        Intent intent = new Intent(context, SameAppActivity.class);
        intent.putParcelableArrayListExtra("appInfoList", appInfoList);
        context.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_main_search:
                SearchAcitivity.startActivity(this);
                break;
            case R.id.menu_main_refresh:
                break;
            case R.id.menu_main_download:
                DownLoadAcitivity.startActivity(this);
                break;
            case R.id.menu_main_setting:
                SettingActivity.startActivity(this);
                break;
            case R.id.menu_main_login:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.search_iv_back)
    public void onClick() {
        finish();
    }
}
