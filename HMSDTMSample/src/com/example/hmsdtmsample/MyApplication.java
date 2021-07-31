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

import java.io.IOException;
import java.io.InputStream;

import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	protected void attachBaseContext(Context context) {
		super.attachBaseContext(context);
		AGConnectServicesConfig config = AGConnectServicesConfig.fromContext(context);
		config.overlayWith(new LazyInputStream(context) {
			public InputStream get(Context context) {
				try {
					return context.getAssets().open("agconnect-services.json");
				} catch (IOException e) {
					return null;
				}
			}
		});
	}
}
