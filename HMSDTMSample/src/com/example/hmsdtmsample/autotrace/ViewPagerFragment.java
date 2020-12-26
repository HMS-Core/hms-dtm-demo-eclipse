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

import com.example.hmsdtmsample.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {
    static final String KEY_TITLE = "title";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_pager_body, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv = view.findViewById(R.id.title_tv);
        Button btn = view.findViewById(R.id.btn);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString(KEY_TITLE);
            if (!TextUtils.isEmpty(title)) {
                tv.setText(title + " TextView");
                btn.setText(title + " Button");
            } else {
                tv.setText(R.string.app_name);
            }
        } else {
            tv.setText(R.string.app_name);
        }
    }
}
