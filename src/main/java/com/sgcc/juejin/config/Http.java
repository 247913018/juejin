package com.sgcc.juejin.config;

import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {

   static String baseUrl = "https://api.juejin.cn";

    /**
     *
     * @param urls 请求接口
     * @param request 请求方法
     * @return
     * @throws IOException
     */
    public static JSONObject HttpPostOrGet(String urls,String request,String cookie) throws IOException {
        URL url = new URL(baseUrl + urls);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod(request);
        httpURLConnection.setRequestProperty("cookie", cookie);
        InputStream inputStream = httpURLConnection.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = 0;
        while (true) {
            len = inputStream.read(b);
            if (len == -1) {
                break;
            }
            byteArrayOutputStream.write(b, 0, len);
        }
        String s = byteArrayOutputStream.toString();
        JSONObject jsonObject = JSONObject.parseObject(s);
        return jsonObject;
    }


}
