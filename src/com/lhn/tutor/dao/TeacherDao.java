package com.lhn.tutor.dao;

import java.util.List;

import com.lhn.tutor.entity.Teacher;

public interface TeacherDao {

	//通过学科查找
	public List<Teacher> querybysubject(String pro);
	
	//通过技能查找
	public List<Teacher> querybyskill();
}
