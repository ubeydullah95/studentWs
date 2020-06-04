package com.ubey.spring_crud;

import com.ubey.spring_crud.model.Student;
import com.ubey.spring_crud.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class SpringCrudWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudWsApplication.class, args);
    }

}



