package com.senyint.squeue.queue.service;

import java.util.List;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-5 下午3:39
 */
public interface QueueService {

    public List findQueue(Map param);

    public void updateQueue(Map param);

    public void insertQueue(Map param);

}
