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

package com.example.hmsdtmsample;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.hmsdtmsample.autotrace.AutoTraceActivity;
import com.huawei.hms.analytics.HiAnalytics;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.huawei.hms.analytics.HiAnalyticsTools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	private HiAnalyticsInstance instance;
	private TextView reportTV;
	private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // get HiAnalyticsInstance instance
    	instance = HiAnalytics.getInstance(this);
        HiAnalyticsTools.enableLog();
        
        reportTV = (TextView) this.findViewById(R.id.report_tv);
    }
    
    public void onClick(View view) {
    	switch (view.getId()) {
	    	case R.id.auto_trace_btn:
	    		startActivity(new Intent(this, AutoTraceActivity.class));
	            break;
	    	case R.id.report_btn:
	    		reportData();
	            break;
	    	default:
	            break;
    	}
    }
    
    private void reportData() {
    	count++;
    	
    	// developers can report custom event
        // event name is "Purchase"
        String eventName = "Purchase";

        // three fields in Bundle
        Bundle bundle = new Bundle();
        bundle.putDouble("price", 7.88);
        bundle.putLong("quantity", 700L);
        bundle.putString("currency", "CNY");

        // report
        if (instance != null) {
            instance.onEvent(eventName, bundle);
            if (reportTV != null) {
            	String text = getCurrentDateTime() + "\n第" + count + "次上报数据"; 
            	text = text + "\n\nprice: 7.99\nquantity: 700L\ncurrency: CNY";
            	reportTV.setText(text);
            }
        }
    }
    
    @SuppressLint("SimpleDateFormat")
	private String getCurrentDateTime() {
    	Date date = new Date(System.currentTimeMillis());
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	return dateFormat.format(date);
    }
}
