package com.nomadicsoulmgl.nomadicsoul.service;


import com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean;

import java.util.List;


/**
 * @author 包青格乐图
 */
public interface ConnectionInfoService {
    List<ConnectionInfoBean> queryConnection();
}
