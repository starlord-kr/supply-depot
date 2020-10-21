package com.starlord.module.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
//@EntityScan("com.starlord.*")
//@EnableJpaRepositories("com.starlord.*") // TEST case에서 @WebMvcTest 와 같은 경우 에러발생함..
public class ModuleApidApplicationWithCommandLineRunner implements CommandLineRunner {

    Logger LOG = LoggerFactory.getLogger(ModuleApidApplicationWithCommandLineRunner.class);

    public ModuleApidApplicationWithCommandLineRunner() {
    }

    @Override
    public void run(String... args) {
    }

    public static void main(String[] args) {
        SpringApplication.run(ModuleApidApplicationWithCommandLineRunner.class, args);
    }
}
