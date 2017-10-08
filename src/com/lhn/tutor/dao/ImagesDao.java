package com.lhn.tutor.dao;

import com.lhn.tutor.entity.Images;

public interface ImagesDao {

	//图片上传保存
	public boolean saveImg(Images img);
	
	//认证图片
	public boolean savetouser(String user_id,String img_id);
}
