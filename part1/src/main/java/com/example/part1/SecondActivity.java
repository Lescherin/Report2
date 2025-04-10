package com.example.part1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 显示ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("2411664 施翊聪");
        }

        ListView listView = findViewById(R.id.listView);

        // 从Intent获取数据
        Intent intent = getIntent();
        String studentId = intent.getStringExtra("studentId");
        String name = intent.getStringExtra("name");
        String gender = intent.getStringExtra("gender");
        String college = intent.getStringExtra("college");
        String major = intent.getStringExtra("major");
        String className = intent.getStringExtra("class");

        // ListView进行图标排序
        List<Map<String, Object>> data = new ArrayList<>();
        int[] icons = {
                R.drawable.credit_card_black,
                R.drawable.account_box_black,
                R.drawable.wc_black,
                R.drawable.account_balance_black,
                R.drawable.school_black,
                R.drawable.assignment_ind_black
        };

        String[] details = {studentId, name, gender, college, major, className};

        for (int i = 0; i < details.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icon", icons[i]);
            item.put("text", details[i]);
            data.add(item);
        }

        // 使用自定义适配器
        CustomAdapter adapter = new CustomAdapter(this, data);
        listView.setAdapter(adapter);
    }

}