package com.lhn.tutor.entity;

public class Images {

	private String id;// ͼƬid
	private String imgpath;// ͼƬ

	public Images() {
	}

	public Images(String id, String imgpath) {
		super();
		this.id = id;
		this.imgpath = imgpath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}

}
