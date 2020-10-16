package com.example.me08;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author houkeqin
 */
public class MainNewsActivity extends AppCompatActivity implements NewsListAdapter.OnItemClickListener {

    private List<NewsListBean> mNewsList;
    private RecyclerView mRvNewsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setAdapter();
    }

    private void initView() {
        mRvNewsList = findViewById(R.id.rv_news_list);
        mNewsList = new ArrayList<>();
    }

    private void initData() {
        NewsListBean bean1 = new NewsListBean("Speech at the 40th anniversary of the Establishment of the Shenzhen Special Economic Zone","In the first three quarters of this year, the total value of China's foreign trade exceeded 23 trillion yuan");
        NewsListBean bean2 = new NewsListBean("Speech at the 40th anniversary of the Establishment of the Shenzhen Special Economic Zone","In the first three quarters of this year, the total value of China's foreign trade exceeded 23 trillion yuan");
        NewsListBean bean3 = new NewsListBean("Speech at the 40th anniversary of the Establishment of the Shenzhen Special Economic Zone","In the first three quarters of this year, the total value of China's foreign trade exceeded 23 trillion yuan");
        NewsListBean bean4 = new NewsListBean("Speech at the 40th anniversary of the Establishment of the Shenzhen Special Economic Zone","In the first three quarters of this year, the total value of China's foreign trade exceeded 23 trillion yuan");
        NewsListBean bean5 = new NewsListBean("Speech at the 40th anniversary of the Establishment of the Shenzhen Special Economic Zone","In the first three quarters of this year, the total value of China's foreign trade exceeded 23 trillion yuan");
        mNewsList.add(bean1);
        mNewsList.add(bean2);
        mNewsList.add(bean3);
        mNewsList.add(bean4);
        mNewsList.add(bean5);
        mNewsList.add(bean1);
        mNewsList.add(bean2);
        mNewsList.add(bean3);
        mNewsList.add(bean4);
        mNewsList.add(bean5);
        mNewsList.add(bean1);
        mNewsList.add(bean2);
        mNewsList.add(bean3);
        mNewsList.add(bean4);
        mNewsList.add(bean5);
    }

    private void setAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        NewsListAdapter newsListAdapter = new NewsListAdapter(this, mNewsList);
        mRvNewsList.setLayoutManager(linearLayoutManager);
        mRvNewsList.setAdapter(newsListAdapter);
        newsListAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "第"+position+1+"条新闻", Toast.LENGTH_SHORT).show();
    }
}