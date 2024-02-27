import org.example.config.Config;
import org.example.axe.Axe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestID {
    static AnnotationConfigApplicationContext ctx;

    @BeforeAll
    static void init(){
        System.out.println("初始化");
        ctx = new AnnotationConfigApplicationContext(Config.class);
    }

    @Test
    void IOC() {
        Axe axe = ctx.getBean(Axe.class);
        assertEquals("我是斧头",axe.toString());
    }
}
