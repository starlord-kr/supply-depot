package com.starlord.module.api.service;

import com.starlord.module.common.student.Student;
import com.starlord.module.common.student.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student saveStudent() {
        log.debug("-- saveStudent");
        Student test = new Student("starlord", "slowstarter.dev@gmail.com");
        Student savedOne = studentRepository.save(test);
        return savedOne;
    }

    public String findStudent(String name) {
        log.debug("-- findStudent");
        Student student = studentRepository.findByName(name);
        return student.getName();
    }

    public Boolean isExist(String name) {
        String student = findStudent(name);
        if(name.equals(student)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
