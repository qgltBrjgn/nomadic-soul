package com.nomadicsoulmgl.nomadicsoul.seviceImpl;

import com.nomadicsoulmgl.nomadicsoul.bean.ConnectionInfoBean;
import com.nomadicsoulmgl.nomadicsoul.mapper.ConnectionInfoMapper;
import com.nomadicsoulmgl.nomadicsoul.service.ConnectionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



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
}
