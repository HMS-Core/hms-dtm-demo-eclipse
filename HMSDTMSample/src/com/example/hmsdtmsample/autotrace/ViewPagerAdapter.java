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

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragments = new ArrayList<Fragment>();

    ViewPagerAdapter(FragmentManager fm) {
        super(fm);

        fragments.add(new ViewPagerFragment());
        fragments.add(new ViewPagerFragment());
        fragments.add(new ViewPagerFragment());
        fragments.add(new ViewPagerFragment());
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        String title = String.valueOf(position);
        bundle.putString(ViewPagerFragment.KEY_TITLE, title);
        Fragment fragment = fragments.get(position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
