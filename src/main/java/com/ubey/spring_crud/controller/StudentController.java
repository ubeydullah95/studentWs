package com.ubey.spring_crud.controller;

import com.ubey.spring_crud.model.Student;
import com.ubey.spring_crud.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/student"})
public class StudentController {

    private StudentRepository repository;

    StudentController(StudentRepository studentRepository) {
        this.repository = studentRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Student> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return repository.save(student);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") long id,
                                          @RequestBody Student student){
        return repository.findById(id)
                .map(record -> {
                    record.setName(student.getName());
                    record.setEmail(student.getEmail());
                    record.setPhone(student.getPhone());
                    record.setDepartment(student.getDepartment());
                    record.setFaculty(student.getFaculty());
                    Student updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}