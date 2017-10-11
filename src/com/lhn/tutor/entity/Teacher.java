package com.lhn.tutor.entity;

public class Teacher {

	private String id;// ��ʦ��
	private String name;// ����
	private String profile;// ���
	private String price;// ��ʱ��
	private String tel;// ��ϵ��ʽ
	private String firstteach;// ��һ���ڿ�Ŀ
	private String secondteach;// �ڶ����ڿ�Ŀ

	public Teacher(String id, String name, String profile, String price,
			String tel, String firstteach, String secondteach) {
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.price = price;
		this.tel = tel;
		this.firstteach = firstteach;
		this.secondteach = secondteach;
	}

	public Teacher() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFirstteach() {
		return firstteach;
	}

	public void setFirstteach(String firstteach) {
		this.firstteach = firstteach;
	}

	public String getSecondteach() {
		return secondteach;
	}

	public void setSecondteach(String secondteach) {
		this.secondteach = secondteach;
	}
}
