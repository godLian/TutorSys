package com.lhn.tutor.dao;

import com.lhn.tutor.entity.Images;

public interface ImagesDao {

	//ͼƬ�ϴ�����
	public boolean saveImg(Images img);
	
	//��֤ͼƬ
	public boolean savetouser(String user_id,String img_id);
}
