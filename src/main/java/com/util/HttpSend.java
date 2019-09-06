package com.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSend {

    private static String BASE_URL = "http://open.memobird.cn/home" ;

    private static String ak = "" ;

    private static String memobirdID = "" ;


    private static String sendRequest(String url) {
        URL u ;
        HttpURLConnection httpURLConnection ;
        BufferedReader bf ;
        String response = "" ;
        String readLine  ;
        try{
            u = new URL(url) ;
            httpURLConnection = (HttpURLConnection)u.openConnection() ;
            int responsecode = httpURLConnection.getResponseCode() ;  // 返回码
            if(responsecode==200) {
                bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while ((readLine = bf.readLine()) != null) {
                    response += readLine += "\r\n";
                }
            }else{
                System.out.println("NOT  "+responsecode);
            }
        }catch(Exception e){
            System.out.println("Exception->"+e);
        }
        return response ;
    }


    public static String setUserBind(String time){
        String url = BASE_URL + "/setuserbind?ak=" + ak + "&timestamp="+ time +"&memobirdID=" + memobirdID  + "&useridentifying=6886550";
        return sendRequest(url) ;
    }

    public static String printPaper(String content,String userId,String time) {
        String url = BASE_URL + "/printpaper?ak=" + ak + "&timestamp="+time+"&printcontent=T:" + content + "&memobirdID=" + memobirdID + "&userId=" + userId ;
        return sendRequest(url);
    }

}
