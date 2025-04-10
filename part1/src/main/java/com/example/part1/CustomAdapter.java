package com.example.part1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> data;

    public CustomAdapter(Context context, List<Map<String, Object>> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.icon_student_id);
        TextView textView = convertView.findViewById(R.id.item_text);

        Map<String, Object> item = data.get(position);

        imageView.setImageResource((Integer) item.get("icon"));
        textView.setText((String) item.get("text"));

        return convertView;
    }
}