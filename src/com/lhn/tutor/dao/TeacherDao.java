package com.lhn.tutor.dao;

import java.util.List;

import com.lhn.tutor.entity.Teacher;

public interface TeacherDao {

	//ͨ��ѧ�Ʋ���
	public List<Teacher> querybysubject(String pro);
	
	//ͨ�����ܲ���
	public List<Teacher> querybyskill();
}
