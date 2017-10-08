package com.lhn.tutor.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

//����Action�����ĸ���
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletResponse response;//��Ӧ����
	protected HttpServletRequest request;//�������
	protected HttpSession session;//�Ự����
	protected ServletContext application;//ȫ�ֶ���
	
	public void setServletContext(ServletContext application) {
		this.application=application;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		this.session=this.request.getSession();
	}

}