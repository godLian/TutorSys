package com.lhn.tutor.action;

import com.lhn.tutor.dao.ImagesDao;
import com.lhn.tutor.dao.impl.ImagesDaoImpl;

public class ImageAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String authenticate(){
		String img_id=request.getParameter("img_id");
		String user_id=(String) session.getAttribute("user_id");
		
		System.out.println("imagesAction="+img_id+user_id);
		
		ImagesDao imagesDao=new ImagesDaoImpl();
		imagesDao.savetouser(user_id, img_id);
		return "authenticate_success";
	}

}
