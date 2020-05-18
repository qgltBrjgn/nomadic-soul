package com.nomadicsoulmgl.nomadicsoul.service;


import com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


/**
 * @author 包青格乐图
 */
public interface ConnectionInfoService {
    /**
    *@Description queryConnection
    *@Param []
    *@Return java.util.List<com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean>
    *@Author Qglt
    *@Date 2020/5/14
    *@Time 9:20
    */
    List<ConnectionInfoBean> queryConnection();
    /**
    *@Description getConnectionIpAddr
    *@Param [request]
    *@Return void
    *@Author Qglt
    *@Date 2020/5/14
    *@Time 9:21
     * @return
    */
    Map<String, Object> getConnectionIpAddr(HttpServletRequest request);
}
