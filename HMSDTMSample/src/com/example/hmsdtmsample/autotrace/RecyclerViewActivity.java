/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package com.example.hmsdtmsample.autotrace;

import java.util.ArrayList;
import java.util.List;

import com.example.hmsdtmsample.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewActivity extends Activity implements View.OnClickListener {
	RecyclerView recyclerView = null;
    private static List<String> list = new ArrayList<String>();
    RecyclerViewAdapter adapter = null;
    Button btn_add = null;
    Button btn_del = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);

        btn_add = findViewById(R.id.recycler_btn_add);
        btn_add.setOnClickListener(this);
        btn_del = findViewById(R.id.recycler_btn_del);
        btn_del.setOnClickListener(this);

        list.clear();
        for (int i = 0; i < 6; i++) {
            list.add(String.valueOf(i));
        }

        recyclerView = findViewById(R.id.auto_trace_rv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);

        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int count = 0;
        switch (v.getId()) {
            case R.id.recycler_btn_add:
                count = list.size();
                for (int i = count; i < count + 6; i++) {
                    list.add(String.valueOf(i));
                }
                
                adapter.notifyDataSetChanged();
                break;
            case R.id.recycler_btn_del:
                count = list.size();
                int start = count - 6;
                while (start >= 6 && count > start) {
                    list.remove(count - 1);
                    count--;
                }
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
        private LayoutInflater mInflater;

        RecyclerViewAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int layout = R.layout.recycler_view_item;
            return new ViewHolder(mInflater.inflate(layout, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String string = list.get(position);
            holder.tv.setText(string + " TextView");
            holder.btn.setText(string + " Button");

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        Button btn;

        ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv = itemView.findViewById(R.id.tv);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
