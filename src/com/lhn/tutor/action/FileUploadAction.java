package com.lhn.tutor.action;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.lhn.tutor.dao.ImagesDao;
import com.lhn.tutor.dao.impl.ImagesDaoImpl;
import com.lhn.tutor.entity.Images;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File upload;

	private String uploadContentType;
	
	private String uploadFileName;
	
	private String result;
	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String execute() throws Exception {
		String path = "E:/images";
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		
		//��ȡ�ļ����ĺ�׺
		int beginIndex = uploadFileName.lastIndexOf(".");
		int endIndex = uploadFileName.length();
		String suffix = uploadFileName.substring(beginIndex, endIndex);
		
		//�µ�����
		String newname=cRandom(6)+suffix;
		
		//���ϴ����ļ����浽����
		FileUtils.copyFile(upload, new File(file,newname));
		
		String savepath=path+"/"+newname;
		Images images=new Images();
		images.setImgpath(savepath);
		ImagesDao imagesDao=new ImagesDaoImpl();
		imagesDao.saveImg(images);
		String img_id=images.getId();
		
		File renameFile=new File(savepath);
		if(renameFile.exists()){
			renameFile.renameTo(new File(path+""));
		}
		
		
		result=img_id;
		
		System.out.println(result);
		
		return SUCCESS;
	}
	
	
	
	//��������ַ�������
	private String cRandom(int m) { // ����1������Ϊmֻ������ĸ������ַ���
        char[] chs = new char[m];
        for (int i = 0; i < m; i++) {
            chs[i] = cNumOrCharRandom();
        }
        return new String(chs);
    }
	
	private char cNumOrCharRandom() { // ����һ��������ֻ���ĸ
        String temp = "0123456789qwertyuiopasdfghjklzxcvbnm";
        return (char) temp.charAt(iRandom(0, 35));
    }
	
	private int iRandom(int m, int n) { // ����һ��[m,n)֮����������
        Random random = new Random();
        int small = m > n ? n : m;
        int big = m <= n ? n : m;
        return small + random.nextInt(big - small);
    }
	
}
