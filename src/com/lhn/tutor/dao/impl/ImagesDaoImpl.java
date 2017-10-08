package com.lhn.tutor.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lhn.tutor.dao.ImagesDao;
import com.lhn.tutor.db.MyHibernateSessionFactory;
import com.lhn.tutor.entity.Images;

public class ImagesDaoImpl implements ImagesDao {

	Transaction transaction = null;
	String hql = "";

	public boolean saveImg(Images img) {
		img.setId(getNewid());
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(img);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return false;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}
	
	//保存到相应的user表下
	public boolean savetouser(String user_id,String img_id){
		try {
			Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction=session.beginTransaction();
			hql="UPDATE User SET identity_id=? WHERE id=?";
			Query query=session.createQuery(hql);
			query.setParameter(0, img_id);
			query.setParameter(1, user_id);
			query.executeUpdate();
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return false;
		}finally{
			if(transaction!=null){
				transaction=null;
			}
		}
	}

	// 生成id号
	private String getNewid() {
		String id = null;
		try {
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			// 获得当前id号
			hql = "select max(id) from Images";
			Query query = session.createQuery(hql);
			id = (String) query.uniqueResult();
			if (id == null || "".equals(id)) {
				// 给一个默认的最大id
				id = "P0000000001";
			} else {
				String temp = id.substring(1);// 取后面的10位
				int i = Integer.parseInt(temp);// 转为数字
				i++;
				// 再还原字符串
				temp = String.valueOf(i);
				int len = temp.length();
				// 凑够七位
				for (int j = 0; j < 10 - len; j++) {
					temp = "0" + temp;
				}
				id = "P" + temp;
			}
			transaction.commit();
			return id;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.commit();
			return id;
		} finally {
			if (transaction != null) {
				transaction = null;
			}
		}
	}

}
