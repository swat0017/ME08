package com.example.me08;
import android.content.Context;

import java.util.List;

/**
 * @description:
 * @author: houkeqin
 */
public class NewsListAdapter extends SimpleAdapter<NewsListBean> {

    public NewsListAdapter(Context context, List<NewsListBean> list) {
        super(context, R.layout.item_news_list, list);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, NewsListBean bean, int position) {
        viewHolder.getTextView(R.id.tv_title).setText(bean.getTitle());
        viewHolder.getTextView(R.id.tv_content).setText(bean.getContent());
    }
}
