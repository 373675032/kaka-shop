package world.xuewei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 应用程序启动类
 *
 * @author XUEW
 */
@SpringBootApplication
@MapperScan(basePackages = {"world.xuewei.mapper"})
public class KakaShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaShopApplication.class, args);
    }

}
