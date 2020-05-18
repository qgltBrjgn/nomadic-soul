package com.nomadicsoulmgl.nomadicsoul.controller;


import com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean;
import com.nomadicsoulmgl.nomadicsoul.service.ConnectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 包青格乐图
 */
@Controller
public class ConnectionInfoController {

    @Autowired
    private ConnectionInfoService connectionInfoService;


    @RequestMapping("/connectionInfo")
    public String connectionInfo() {
        return "connectionInfo";
    }


    @RequestMapping(value = "/getConnectionInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getConnectionInfo() {

        List<ConnectionInfoBean> connectionInfoBeans = connectionInfoService.queryConnection();
        Map<String, Object> map = new HashMap<>();
        map.put("connectionList", connectionInfoBeans);

        return map;
    }


    @RequestMapping(value = "/getConnectionIpAddr", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getConnectionIpAddr(HttpServletRequest request) {
        return connectionInfoService.getConnectionIpAddr(request);
    }


}

