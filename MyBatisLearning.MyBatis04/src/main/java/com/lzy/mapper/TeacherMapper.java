package com.lzy.mapper;

import com.lzy.bean.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeachers();

    Teacher getTeacherById(int tid);


}
