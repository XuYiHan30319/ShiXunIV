import com.alibaba.druid.pool.DruidDataSource;
import org.example.Axe.Axe;
import org.example.config.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestService {
    static ApplicationContext ctx;
    @BeforeAll
    static void init() {
        System.out.println("初始化");
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    void IOC() {
        Axe axe = ctx.getBean("defaultAxe",Axe.class);
        assertEquals("hello world 斧子",axe.toString());
    }

    @Test
    void TestDBConnect(){
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        assertNotNull(dataSource, "数据源连接不能为空");
        System.out.println("链接成功");
    }

    @Test
    void getID(){
        Axe axe = ctx.getBean("defaultAxe", Axe.class);
        assertEquals("hello world 斧子",axe.toString());

        axe = ctx.getBean("customAxe", Axe.class);
        assertEquals("hello world 自定义斧子",axe.toString());

    }

    @AfterAll
    static void after(){
        System.out.println("结束喽");
    }
}

