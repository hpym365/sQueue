import com.senyint.squeue.App;
import com.senyint.squeue.rabbitmq.utils.RabbitMQDAO;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.mapping.TextScore;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hpym365@gmail.com
 * @Description
 * @Date 17-5-22 上午8:55
 */
//@SpringBootConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
//@SpringBootConfiguration
public class Testa {

    @Autowired
    RabbitMQDAO dao;

    @org.junit.Test
    public void test(){
        dao.sendMessage("test","asdf","adfadsf");
        System.out.println("123");
    }
}
