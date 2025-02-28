package org.example.deekseek_backend;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.stp.StpUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengyiyang
 */
@SpringBootApplication
@MapperScan("org.example.deekseek_backend.dal.dao.mapper")
public class DeekseekBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeekseekBackendApplication.class, args);
        System.out.println("Sa-token start with: " + SaManager.getConfig());
    }

}
