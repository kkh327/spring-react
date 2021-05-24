package com.kian.springfullstack.student;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.kian.springfullstack.student.Gender.*;

@RestController
@RequestMapping(path = "api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private  final StudentService studentService;
    @GetMapping
    public List<Student> getAllStudents() {
        // List<Student> studentsImmutable = Collections.singletonList(new Student(1L, "Jamila", "jamila@amigoscode.edu", FEMALE));
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addStudent (@RequestBody @Valid Student student) {
        studentService.addStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
