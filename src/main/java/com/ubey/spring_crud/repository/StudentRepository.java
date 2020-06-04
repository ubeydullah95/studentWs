package com.ubey.spring_crud.repository;

import com.ubey.spring_crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> { }
