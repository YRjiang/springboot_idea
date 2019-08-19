package com.example.security.utils;


import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * 使用HttpClient模拟发送（http/https）请求
 *
 * @author arron
 * @version 1.0
 */
public class HttpClientUtil{

    // 发送GET请求
    public static String getRequest(String path, List<NameValuePair> parametersBody) throws Exception, URISyntaxException { // RestApiException
        URIBuilder uriBuilder = new URIBuilder(path);
        uriBuilder.setParameters(parametersBody);
        HttpGet get = new HttpGet(uriBuilder.build());
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(get);
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400)
                throw new RuntimeException((new StringBuilder()).append("Could not access protected resource. Server returned http code: ").append(code).toString());
            return EntityUtils.toString(response.getEntity());
        }
        catch (ClientProtocolException e) {
            throw new Exception("postRequest -- Client protocol exception!", e);
        }
        catch (IOException e) {
            throw new Exception("postRequest -- IO error!", e);
        }
        finally {
            get.releaseConnection();
        }
    }

    // 发送POST请求（普通表单形式）
    public static String postForm(String path, List<NameValuePair> parametersBody) throws Exception { // RestApiException
        HttpEntity entity = new UrlEncodedFormEntity(parametersBody, Charsets.UTF_8);
        return postRequest(path, "application/x-www-form-urlencoded", null, entity);
    }

    // 发送POST请求（JSON形式）
    public static String postJSON(String path, String json) throws Exception { // RestApiException
        StringEntity entity = new StringEntity(json, Charsets.UTF_8);
        return postRequest(path, "application/json", null, entity);
    }

    // 发送POST请求
    public static String postRequest(String path, String mediaType, String Authorization, HttpEntity entity) throws Exception { // RestApiException
        //logger.debug("[postRequest] resourceUrl: {}", path);
        HttpPost post = new HttpPost(path);
        post.addHeader("Content-Type", mediaType);
        post.addHeader("Accept", "application/json");
        if (Authorization != null) {
            post.addHeader("Authorization", Authorization);
        }
        post.setEntity(entity);
        // post.setEntity(new StringEntity(paramStr, Charset.forName("UTF-8"))); // 此方法是将 String 直接转 Entity 再 setEntity
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code >= 400)
                throw new Exception(EntityUtils.toString(response.getEntity()));
            return EntityUtils.toString(response.getEntity());
        }
        catch (ClientProtocolException e) {
            throw new Exception("postRequest -- Client protocol exception!", e);
        }
        catch (IOException e) {
            throw new Exception("postRequest -- IO error!", e);
        }
        finally {
            post.releaseConnection();
        }
    }
}
