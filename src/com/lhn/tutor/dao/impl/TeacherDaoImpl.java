package com.lhn.tutor.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lhn.tutor.dao.TeacherDao;
import com.lhn.tutor.db.MyHibernateSessionFactory;
import com.lhn.tutor.entity.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	private Transaction transaction=null;
	private List<Teacher> tList;
	private String hql;
	
	public List<Teacher> querybysubject(String pro) {
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			hql="From Teacher where firstteach like'%?%' or secondteach like'%?%' limit 4";
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setString(0, pro);
			query.setString(1, pro);
			tList=query.list();
			transaction.commit();
			return tList;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return tList;
		}
		finally{
			if(transaction!=null){
				transaction=null;
			}
		}
	}

	public List<Teacher> querybyskill() {
		try{
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			hql="FROM Teacher WHERE id NOT IN(SELECT id FROM Teacher WHERE " +
					"firstteach LIKE'%��ѧ%' OR secondteach LIKE'%��ѧ%' OR firstteach " +
					"LIKE'%����%' OR secondteach LIKE'%����%' OR firstteach LIKE'%Ӣ��%' " +
					"OR secondteach LIKE'%Ӣ��%' OR firstteach LIKE'%����%' OR secondteach " +
					"LIKE'%����%' OR firstteach LIKE'%��ѧ%' OR secondteach LIKE'%��ѧ%' OR " +
					"firstteach LIKE'%����%' OR secondteach LIKE'%����%') limit 4";
			transaction=session.beginTransaction();
			Query query=session.createQuery(hql);
			tList=query.list();
			transaction.commit();
			return tList;
		}
		catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return tList;
		}
		finally{
			if(transaction!=null){
				transaction=null;
			}
		}
	}
	
}
