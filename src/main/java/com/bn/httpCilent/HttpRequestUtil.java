package com.bn.httpCilent;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: xiongjianjian
 * @Description:
 * @Date: 2019/11/20 9:40
 * @Modified: xiongjianjian
 **/
public class HttpRequestUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    private static final String TESTURL="http://10.20.9.86:8080/SSM_war_exploded/student/findAll";

    private static final String DHURL = "http://10.20.9.130:8080/ssm_war_exploded/basketball/delete/1";
    private static final String SJURL = "http://10.20.9.150:8080/sap_data_web/task/postParam?id=1";


   /* public Map<String,Object> httpRequest() throws ParseException {
        String url=TESTURL;
        List<NameValuePair> paramsList=new ArrayList<NameValuePair>();
        paramsList.add(new BasicNameValuePair("键","值"));
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity(paramsList, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httpCommon(url,entity);
    }*/

    public static void main(String[] args) {
        String url=SJURL;
       /* List<NameValuePair> paramsList=new ArrayList<NameValuePair>();
        paramsList.add(new BasicNameValuePair("键","值"));*/
        UrlEncodedFormEntity entity = null;
    /*    try {
            entity = new UrlEncodedFormEntity(paramsList, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
            Map<String,Object> map = httpCommon(url,entity,"GET");
            System.out.println(map.get("result"));

    }

    /**
     * @Author: xiongjianjian
     * @Description: 传入访问地址，参数，请求方式
     * @Date: 2019/11/20 14:02
     * @Modified: xiongjianjian
     **/
    public static Map<String,Object> httpCommon(String url, UrlEncodedFormEntity entity,String httpMethod){
        String result = "";
        HttpPost httpPost = null;
        HttpGet httpGet = null;
        HttpDelete httpDelete = null;
        CloseableHttpResponse response = null;

        if("POST".equals(httpMethod)){
            httpPost = new HttpPost(url);//建立HttpPost对象
        }else if ("GET".equals(httpMethod)){
             httpGet = new HttpGet(url);//建立HttpGet对象
        }else if ("DELETE".equals(httpMethod)){
            httpDelete = new HttpDelete(url);
        }

        CloseableHttpClient client = HttpClients.createDefault();//创建httpcilent对象
        try {
            //设置请求与传输时长
            RequestConfig.Builder builder = RequestConfig.custom();

            builder.setSocketTimeout(120000);
            builder.setConnectTimeout(6000);

            RequestConfig requestConfig = builder.build();
            if("POST".equals(httpMethod)){
                if (entity != null) {
                    httpPost.setEntity(entity);
                }
                httpPost.setConfig(requestConfig);
                //发送post请求
                response = client.execute(httpPost);
            }else if ("GET".equals(httpMethod)){
                httpGet.setConfig(requestConfig);
                //发送GET请求
                response = client.execute(httpGet);
            }else if ("DELETE".equals(httpMethod)){
                httpDelete.setConfig(requestConfig);
                //发送GET请求
                response = client.execute(httpDelete);
            }
            //获取响应值
            HttpEntity httpEntity = response.getEntity();
            if(httpEntity != null){
                result = EntityUtils.toString(httpEntity,"UTF-8");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                client.close();
                if("POST".equals(httpMethod)){
                     httpPost.releaseConnection();
                }else if ("GET".equals(httpMethod)){
                    httpGet.releaseConnection();
                }else if ("DELETE".equals(httpMethod)){
                    httpDelete.releaseConnection();
                }
            }catch (IOException e){
                logger.info(e.toString(),e);
            }
        }
        Map map = new HashMap();
        map.put("result",result);
        return map;
    }
}
