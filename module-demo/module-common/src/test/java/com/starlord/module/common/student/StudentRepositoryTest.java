package com.starlord.module.common.student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void add() {
        studentRepository.save(new Student("starlord", "starlord@gmail.com"));
        Student firstStudent = studentRepository.findById(1l).get();
        assertThat(firstStudent.getName(), is("starlord"));
    }

}