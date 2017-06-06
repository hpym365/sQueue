package com.senyint.squeue.base.component;

import com.senyint.squeue.queue.dao.QueueDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-5 下午4:44
 */
@Configuration
public class DaoComponent {

    @Autowired
    SqlSession sqlSession;

    @Bean
    public QueueDao getQueueDao(){
        return sqlSession.getMapper(QueueDao.class);
    }
}
