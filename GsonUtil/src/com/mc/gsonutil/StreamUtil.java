package com.mc.gsonutil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;



import android.content.Context;

public class StreamUtil {
	
	public static String doGetStringFromRaw(Context context,int Resid){
		InputStream in = context.getResources().openRawResource(Resid);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte [] buffer = new byte [1024];
		int len = 0;
		try {
			while ((len=(in.read(buffer)))!=-1) {
				os.write(buffer,0,len);
			}
			return os.toString("utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(in!=null&&os!=null){
				try {
					in.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
		} 
		return null;
	}
	
//	
//	private void writeToJsonData(File cacheFile) {
//		try {
//			FileInputStream is = new FileInputStream(cacheFile);
//			ByteArrayOutputStream os = new ByteArrayOutputStream();
//			byte[] buffer = new byte[1024];
//
//			int len = 0;
//
//			while ((len = is.read(buffer)) != -1) {
//				os.write(buffer, 0, len);
//			}
//
//			is.close();
//			this.JsonData = os.toString();
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

}
