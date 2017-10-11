package com.lhn.tutor.action;

import java.util.List;

import com.lhn.tutor.dao.TeacherDao;
import com.lhn.tutor.dao.impl.TeacherDaoImpl;
import com.lhn.tutor.entity.Teacher;

public class TeacherAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String querybyteach() {
		TeacherDao teacherDao=new TeacherDaoImpl();
		List<Teacher> mathList=teacherDao.querybysubject("��ѧ");
		if(mathList!=null&&mathList.size()>0){
			session.setAttribute("mathlist", mathList);
		}
		List<Teacher> chineseList=teacherDao.querybysubject("����");
		if(chineseList!=null&&chineseList.size()>0){
			session.setAttribute("chineselist", chineseList);
		}
		List<Teacher> englishList=teacherDao.querybysubject("Ӣ��");
		if(englishList!=null&&englishList.size()>0){
			session.setAttribute("englishlist", englishList);
		}
		List<Teacher> physicsList=teacherDao.querybysubject("����");
		if(physicsList!=null&&physicsList.size()>0){
			session.setAttribute("physicslist", physicsList);
		}
		List<Teacher> chemistryList=teacherDao.querybysubject("��ѧ");
		if(chemistryList!=null&&chemistryList.size()>0){
			session.setAttribute("chemistrylist", chemistryList);
		}
		List<Teacher> skillList=teacherDao.querybyskill();
		if(skillList!=null&&skillList.size()>0){
			session.setAttribute("skillList", skillList);
		}
		return "query_success";
	}
}
