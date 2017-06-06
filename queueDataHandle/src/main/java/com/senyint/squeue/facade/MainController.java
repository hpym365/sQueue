package com.senyint.squeue.facade;

import com.senyint.squeue.queue.service.QueueService;
import com.senyint.squeue.result.Result;
import com.senyint.squeue.util.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-6-6 上午10:50
 */
@RestController
@RequestMapping("/data")
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QueueService queueService;

    /**
     * @param param the param
     * @return the Result
     * @Version 1.0
     * @Date 20170606 10:53:19
     * @Author hpym365 @gmail.com
     * @Description Find  queue by token list.根据token","queueNum查找队列
     */
    @RequestMapping("/findQueue")
    public Result findQueue(@RequestBody(required = false) Map param) throws Exception {
        RestUtils.checkParamNotNull(param,"token","queueNum");
        List queueByToken = queueService.findQueue(param);
        Result result = Result.succResult();
        result.setData(queueByToken);
        return result;
    }

}
