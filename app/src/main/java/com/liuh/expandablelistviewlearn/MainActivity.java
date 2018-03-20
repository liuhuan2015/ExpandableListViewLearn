package com.liuh.expandablelistviewlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.exp_listview)
    ExpandableListView expListView;

    private String[] groupStrs = {"西游记", "水浒传", "三国演义", "红楼梦"};
    private String[][] childStrs = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "吴用", "林冲", "花荣", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤", "袭人"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        expListView.setAdapter(new ExpAdapter(this, groupStrs, childStrs));
    }
}
