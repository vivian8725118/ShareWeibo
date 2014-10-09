package com.xiaoniu.shareinfotoweibo;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.weibo.TencentWeibo;

public class MainActivity extends Activity {

	private Button button1, button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button1 = (Button) findViewById(R.id.shareButton1);
		button2 = (Button) findViewById(R.id.shareButton2);
		// 1.初始化
		ShareSDK.initSDK(getApplicationContext());

		button1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shareToTxWeiBo();
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shareToSinaWeiBo();
			}
		});

	}

	private void shareToSinaWeiBo() {
		// TODO Auto-generated method stub
		// 2.创建制定平台
		final Platform platform = ShareSDK.getPlatform(SinaWeibo.NAME);
		// 3.为平台添加监听器
		platform.setPlatformActionListener(new PlatformActionListener() {

			@Override
			public void onError(Platform arg0, int arg1, Throwable arg2) {
				// TODO 发生错误时
				Log.d("", "错误信息：" + arg2.getLocalizedMessage());
			}

			@Override
			public void onComplete(Platform arg0, int arg1,
					HashMap<String, Object> arg2) {
				// TODO 完成时触发
				// 分享参数对象
				SinaWeibo.ShareParams shareParams = new SinaWeibo.ShareParams();
				// 设置分享内容
				shareParams.setText("我的分享---农夫四拳");
				// shareParams
				// .setImageUrl("http://su.bdimg.com/static/superplus/img/logo_white.png?v=md5");
				platform.share(shareParams);

			}

			@Override
			public void onCancel(Platform arg0, int arg1) {
				// TODO 取消时

			}
		});
		// 授权平台
		platform.authorize();
	}

	private void shareToTxWeiBo() {
		// TODO Auto-generated method stub
		// 2.创建制定平台
		final Platform platform = ShareSDK.getPlatform(TencentWeibo.NAME);
		// 3.为平台添加监听器
		platform.setPlatformActionListener(new PlatformActionListener() {

			@Override
			public void onError(Platform arg0, int arg1, Throwable arg2) {
				// TODO 发生错误时
				Log.d("", "错误信息22222：" + arg2.getLocalizedMessage());
			}

			@Override
			public void onComplete(Platform arg0, int arg1,
					HashMap<String, Object> arg2) {
				// TODO 完成时触发
				// 分享参数对象
				TencentWeibo.ShareParams shareParams = new TencentWeibo.ShareParams();
				// 设置分享内容
				shareParams.setText("我的分享");
				shareParams
						.setImageUrl("http://su.bdimg.com/static/superplus/img/logo_white.png?v=md5");
				platform.share(shareParams);

			}

			@Override
			public void onCancel(Platform arg0, int arg1) {
				// TODO 取消时

			}
		});
		// 授权平台
		platform.authorize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
