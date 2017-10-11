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
		List<Teacher> mathList=teacherDao.querybysubject("数学");
		if(mathList!=null&&mathList.size()>0){
			session.setAttribute("mathlist", mathList);
		}
		List<Teacher> chineseList=teacherDao.querybysubject("语文");
		if(chineseList!=null&&chineseList.size()>0){
			session.setAttribute("chineselist", chineseList);
		}
		List<Teacher> englishList=teacherDao.querybysubject("英语");
		if(englishList!=null&&englishList.size()>0){
			session.setAttribute("englishlist", englishList);
		}
		List<Teacher> physicsList=teacherDao.querybysubject("物理");
		if(physicsList!=null&&physicsList.size()>0){
			session.setAttribute("physicslist", physicsList);
		}
		List<Teacher> chemistryList=teacherDao.querybysubject("化学");
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
