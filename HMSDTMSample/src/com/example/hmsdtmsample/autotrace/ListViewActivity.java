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

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.hmsdtmsample.R;

public class ListViewActivity extends Activity implements View.OnClickListener {
    ListView mlistView = null;
    RoomAdapter adapter = null;
    List<Room> rooms = null;
    Button btn_add = null;
    Button btn_del = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_activity);

        btn_add = findViewById(R.id.listview_btn_add);
        btn_add.setOnClickListener(this);
        btn_del = findViewById(R.id.listview_btn_del);
        btn_del.setOnClickListener(this);

        rooms = new ArrayList<Room>();
        int start = 0;
        for (int i = 0; i < 1; i++) {
            rooms.add(new Room(getString(R.string.presidential_room), start++));
            rooms.add(new Room(getString(R.string.family_room), start++));
            rooms.add(new Room(getString(R.string.double_bed_room), start++));
            rooms.add(new Room(getString(R.string.king_bed_room), start++));
            rooms.add(new Room(getString(R.string.single_room), start++));
        }

        adapter = new RoomAdapter(this);
        adapter.setItems(rooms);

        mlistView = findViewById(R.id.book_room_lv);
        mlistView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        int count = 0;
        switch (v.getId()) {
            case R.id.listview_btn_add:
                count = rooms.size();
                rooms.add(new Room(getString(R.string.presidential_room), count++));
                rooms.add(new Room(getString(R.string.family_room), count++));
                rooms.add(new Room(getString(R.string.double_bed_room), count++));
                rooms.add(new Room(getString(R.string.king_bed_room), count++));
                rooms.add(new Room(getString(R.string.single_room), count++));
                adapter.setItems(rooms);
                mlistView.setSelection(count - 1);
                break;
            case R.id.listview_btn_del:
                count = rooms.size();
                int start = count - 5;
                while (count > 5 && count > start) {
                    rooms.remove(count - 1);
                    count--;
                }
                adapter.setItems(rooms);
                mlistView.setSelection(count - 1);
                break;
            default:
                break;
        }
    }

    private class RoomAdapter extends BaseAdapter implements View.OnClickListener {
        private final List<Room> rooms = new ArrayList<Room>();

        private final LayoutInflater inflater;

        private RoomAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        void setItems(List<Room> items) {
            this.rooms.clear();
            if (items != null) {
                this.rooms.addAll(items);
            }
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return rooms.size();
        }

        @Override
        public Room getItem(int position) {
            return rooms.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.book_room_item, parent, false);
                convertView.setTag(R.id.id_holder, holder = new Holder());

                holder.typeTv = convertView.findViewById(R.id.type_tv);
                holder.priceTv = convertView.findViewById(R.id.price_tv);
                holder.bookBtn = convertView.findViewById(R.id.book_btn);
                holder.img = convertView.findViewById(R.id.img);

                convertView.setOnClickListener(this);
            } else {
                holder = (Holder) convertView.getTag(R.id.id_holder);
            }

            Room room = getItem(position);

            holder.typeTv.setText(room.type);
            holder.priceTv.setText(String.valueOf(room.price));
            holder.bookBtn.setTag(R.id.id_object, room);

            holder.typeTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.priceTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.bookBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            return convertView;
        }

        @Override
        public void onClick(View v) {
            TextView priceTV = v.findViewById(R.id.price_tv);
            int index = -1;
            if (mlistView != null) {
                index = mlistView.getPositionForView(v);
            }
            Log.i("DDD", "onClick:" + index + " ," + priceTV.getText());
        }
    }

    public static class Holder {
        TextView typeTv;
        TextView priceTv;
        TextView bookBtn;
        ImageView img;
    }

    private static class Room {
        String type;

        int price;

        Room(String type, int price) {
            this.price = price;
            this.type = type;
        }
    }
}
