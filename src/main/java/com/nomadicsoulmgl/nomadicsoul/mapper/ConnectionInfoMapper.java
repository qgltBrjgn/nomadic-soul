package com.nomadicsoulmgl.nomadicsoul.mapper;

import com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 包青格乐图
 */
@Repository
public interface ConnectionInfoMapper {

    /**
    *@Description queryConnection
    *@Param []
    *@Return java.util.List<com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean>
    *@Author Qglt
    *@Date 2020/5/12
    *@Time 14:40
    */
    List<ConnectionInfoBean> queryConnection();
}
