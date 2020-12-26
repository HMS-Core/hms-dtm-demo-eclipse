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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AutoTraceActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_trace);
    }
    
    public void onAutoTraceBtnClick(View view) {
    	switch (view.getId()) {
	    	case R.id.fragment_btn:
	            onFragmentBtnClick();
	            break;
	    	case R.id.scroll_view_v_btn:
	            onScrollViewVBtnClick();
	            break;
	        case R.id.scroll_view_h_btn:
	            onScrollViewHBtnClick();
	            break;
	        case R.id.list_view_btn:
	        	onListViewBtnClick();
	            break;
	        case R.id.recycler_view_btn:
                onRecyclerViewBtnClick();
                break;
	        case R.id.view_pager_btn:
                onViewPagerBtnClick();
                break;
	        case R.id.tab_host_btn:
                onTabHostClick();
                break;
            default:
                break;
        }
    }
    
    private void onFragmentBtnClick() {
        startActivity(new Intent(this, FragmentActivity.class));
    }
    
    private void onScrollViewVBtnClick() {
        startActivity(new Intent(this, ScrollViewVActivity.class));
    }

    private void onScrollViewHBtnClick() {
        startActivity(new Intent(this, ScrollViewHActivity.class));
    }

    private void onListViewBtnClick() {
    	startActivity(new Intent(this, ListViewActivity.class));
    }
    
    private void onRecyclerViewBtnClick() {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
    
    private void onViewPagerBtnClick() {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }
    
    private void onTabHostClick() {
        startActivity(new Intent(this,TabHostActivity.class));
    }
}
