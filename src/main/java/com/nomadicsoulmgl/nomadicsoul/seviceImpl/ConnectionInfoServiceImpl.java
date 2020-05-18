package com.nomadicsoulmgl.nomadicsoul.seviceImpl;

import com.alibaba.fastjson.JSON;
import com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean;
import com.nomadicsoulmgl.nomadicsoul.mapper.ConnectionInfoMapper;
import com.nomadicsoulmgl.nomadicsoul.service.ConnectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 包青格乐图
 */
@Service
public class ConnectionInfoServiceImpl implements ConnectionInfoService {

    @Autowired
    private ConnectionInfoMapper connectionInfoMapper;

    @Override
    public List<ConnectionInfoBean> queryConnection() {
        return connectionInfoMapper.queryConnection();
    }

    private static final String LOCAL_IP_1 = "127.0.0.1";
    private static final String LOCAL_IP_2 = "0:0:0:0:0:0:0:1";
    private static final int LOCAL_IP_2_LEN = 15;
    private static final String UNKNOWN = "unknown";
    private static final String INDEX_OF_SYMBOL = ",";

    @Override
    public Map<String, Object> getConnectionIpAddr(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || UNKNOWN.equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (LOCAL_IP_1.equals(ipAddress) || LOCAL_IP_2.equals(ipAddress)) {
                //根据网卡取本机配置的IP
                InetAddress inept = null;
                try {
                    inept = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                if (inept != null) {
                    ipAddress = inept.getHostAddress();
                }
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        // "***.***.***.***".length() = 15
        if (ipAddress != null && ipAddress.length() > LOCAL_IP_2_LEN) {
            if (ipAddress.indexOf(INDEX_OF_SYMBOL) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(INDEX_OF_SYMBOL));
            }
        }
        map.put("ipStr", ipAddress);
        map.put("addStr", getConnectionInfoByIp(ipAddress));
        return map;
    }

    private static final String T_IP_SERVICE_KEY = "GCZBZ-6UACF-YQIJM-JZ5VJ-FU7EZ-OLBEZ";


    private static Map getConnectionInfoByIp (String ipStr) {

        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = "https://apis.map.qq.com/ws/location/v1/ip?key=" + T_IP_SERVICE_KEY + "&ip=" + ipStr;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return JSON.parseObject(result.toString(), Map.class);
    }

}
