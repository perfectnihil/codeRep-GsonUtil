package com.mc.gsonutil.test;

import java.util.List;

import com.mc.gsonutil.GsonUtil;
import com.mc.gsonutil.R;
import com.mc.gsonutil.StreamUtil;
import com.mc.gsonutil.TheBean;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * use jsonToJava To generate your javaBean quickly
 * @author The_One_Su
 */
public class TestActivity extends Activity{
	private TextView tv_result;
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.mmainlayout);
		tv_result = (TextView) findViewById(R.id.tv_show);
	}
   public void doTestGsonArray(){
		String jsonString = StreamUtil.doGetStringFromRaw(this, R.raw.jsonarray);
		List<TheBean> mBeans  = GsonUtil.getBeanListFromString(TheBean.class, jsonString);
		tv_result.setText(mBeans.toString());
	}
	public void doTestGsonObj(){
		String jsonString = StreamUtil.doGetStringFromRaw(this, R.raw.jsonobj);
		TheBean bean = GsonUtil.getBeanFromString(TheBean.class,  jsonString);
		tv_result.setText(bean.toString());
	}
	public void doParseObj(View viw){
		doTestGsonObj();
	}
	public void doParseArray(View viw){
		doTestGsonArray();
	}
}
