package com.starlord.module.api.controller;

import com.starlord.module.api.service.StudentService;
import com.starlord.module.common.student.Student;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/student")
public class StudentController {

    private static Logger LOG = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public Student save() {
        log.debug("-- save");
        return studentService.saveStudent();
    }

    @GetMapping("/{name}")
    public String findStudent(@PathVariable("name") String name) {
        log.debug("-- findStudent");
        return studentService.findStudent(name);
    }

    @GetMapping("/{name}/exist")
    public Boolean isExist(@PathVariable("name") String name) {
        return studentService.isExist(name);
    }
}
