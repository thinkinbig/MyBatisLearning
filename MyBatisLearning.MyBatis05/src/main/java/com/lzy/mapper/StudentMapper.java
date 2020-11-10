package com.lzy.mapper;

import com.lzy.bean.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudents();
    Student getStudentById(int id);
}
