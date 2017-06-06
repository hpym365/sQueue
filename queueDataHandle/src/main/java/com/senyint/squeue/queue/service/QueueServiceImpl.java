package com.senyint.squeue.queue.service;

import com.senyint.squeue.queue.dao.QueueDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-5 下午3:41
 */
@Service
public class QueueServiceImpl implements QueueService {


    @Autowired
    QueueDao dao;

    @Override
    public void updateQueue(Map param) {

    }

    @Override
    public void insertQueue(Map param) {
        dao.insertQueue(param);
    }

    @Override
    public List findQueue(Map param) {
        return dao.selectQueue(param);
    }


}
