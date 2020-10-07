package com.starlord.module.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.starlord.*")
//@EnableJpaRepositories("com.starlord.*") // TEST case에서 @WebMvcTest 와 같은 경우 에러발생함..
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }
}
