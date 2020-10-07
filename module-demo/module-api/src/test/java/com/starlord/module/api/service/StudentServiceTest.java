package com.starlord.module.api.service;

import com.starlord.module.common.student.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("h2db")
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void save() {
        String studentName = "starlord";
        Student savedOne = studentService.saveStudent();
        assertThat(savedOne.getName(), is(studentName));
    }

}