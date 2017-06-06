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
    public List findQueueByToken(Map param) {
        return dao.selectQueueByToken(param);
    }

    @Override
    public void updateQueue(Map param) {

    }

    @Override
    public void insertQueue(Map param) {
        List list = dao.selectQueue(param);
        System.out.println(list);
        if(list.size()==0){
            dao.insertQueue(param);
        }else{
            System.out.println("插入失败重复了");
        }
    }

    @Override
    public List findQueue(Map param) {
       return dao.selectQueue(param);
    }

    @Override
    public Map findQueueByQueueNum(Map param) {
        return dao.selectQueueByQueueNum(param);
    }


}
