package testentity;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;

import com.lhn.tutor.dao.ImagesDao;
import com.lhn.tutor.dao.impl.ImagesDaoImpl;
import com.lhn.tutor.db.MyHibernateSessionFactory;
import com.lhn.tutor.entity.Images;

public class TestImg {

	@Test
	public void testadd() {
		Images img=new Images();
		img.setImgpath("E:/images/img1-lg.jpg");
		ImagesDao userDao=new ImagesDaoImpl();
		Assert.assertEquals(true, userDao.saveImg(img));
	}
	
	@Test
	public void testupdate(){
		ImagesDaoImpl userDao=new ImagesDaoImpl();
		Assert.assertEquals(true, userDao.savetouser("J0000000001","P0000000002"));
//		Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
//		Transaction transaction=session.beginTransaction();
//		String hql="UPDATE User SET identity_id='P0000000001' WHERE id='J0000000001'";
//		Query query=session.createQuery(hql);
//		query.executeUpdate();
//		transaction.commit();
	}
	
	@Test
	public void test(){
		Session session=MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		Transaction transaction=session.beginTransaction();
		String hql="From User where id='J0000000001'";
		Query query=session.createQuery(hql);
		System.out.println(query.list().size());
		transaction.commit();
	}
	
	public String cRandom() { // 产生1个长度为m只含有字母的随机字符串
        char[] chs = new char[6];
        for (int i = 0; i < 6; i++) {
            chs[i] = cNumOrCharRandom();
        }
        return new String(chs);
    }
	
	public static char cNumOrCharRandom() { // 产生一个随机数字或字母
        String temp = "0123456789qwertyuiopasdfghjklzxcvbnm";
        return (char) temp.charAt(iRandom(0, 35));
    }
	
	public static int iRandom(int m, int n) { // 产生一个[m,n)之间的随机整数
        Random random = new Random();
        int small = m > n ? n : m;
        int big = m <= n ? n : m;
        return small + random.nextInt(big - small);
    }
}
