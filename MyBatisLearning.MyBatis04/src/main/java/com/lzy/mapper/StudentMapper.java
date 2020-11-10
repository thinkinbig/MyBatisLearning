package com.lzy.mapper;

import com.lzy.bean.Student;
import com.lzy.bean.Teacher;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudents();

    Teacher getTeacher(int tid);
}
