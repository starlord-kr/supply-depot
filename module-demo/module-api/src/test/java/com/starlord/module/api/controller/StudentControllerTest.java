package com.starlord.module.api.controller;

import com.starlord.module.api.service.StudentService;
import com.starlord.module.common.student.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void saveTest() throws Exception {

        given(studentService.saveStudent()).willReturn(Student.builder().id(1L).name("starlord").email("slowstarter.dev@gmail.com").build());

        ResultActions result = mvc.perform(post("/v1/student/save")
                .contentType(MediaType.APPLICATION_JSON))
//                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"starlord\",\"email\":\"slowstarter.dev@gmail.com\"}"))
                .andDo(print());

        assertThat("{\"id\":1,\"name\":\"starlord\",\"email\":\"slowstarter.dev@gmail.com\"}", is(result.andReturn().getResponse().getContentAsString()));
    }
}
