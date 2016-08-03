package com.imooc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.MaintainService;

public class DeleteOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
		String idStr = req.getParameter("id");
		try {
			MaintainService maintainService = new MaintainService();
			maintainService.deleteOne(idStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//请求转发向页面跳转
		req.getRequestDispatcher("/list.action").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
