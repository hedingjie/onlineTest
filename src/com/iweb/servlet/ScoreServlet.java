package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iweb.entity.Question;
import com.iweb.entity.User;

public class ScoreServlet implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int score = 0;
		int i=0;
		List<Question> questions = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questions");
		String type=(String)((HttpServletRequest)request).getSession().getAttribute("type");
//		System.out.println("type:"+type);
		List<Question> errors=new ArrayList<Question>();
		System.out.println("score" + questions.size());
		User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("	<head>");
		out.println("	</head>");
		out.println("	<body>");
		for(Question question : questions){
			System.out.println((i++)+"."+request.getParameter(Integer.toString(question.getQid())));
			if(question.getAnswer().equals(request.getParameter(Integer.toString(question.getQid())))){
				score++;
			}else{
				if(type.equals("0")&&request.getParameter(Integer.toString(question.getQid()))!=null){
					//单选题
					out.println("<li>");
					out.println(question.getQuestion() + "<br/>");
					out.println("A" + question.getCheck()[0] + "<br/>");
					out.println("B" + question.getCheck()[1] + "<br/>");
					out.println("C" + question.getCheck()[2] + "<br/>");
					out.println("D" + question.getCheck()[3] + "<br/>");
					if(!question.getCheck()[4].equals("")){
						out.println("E" + question.getCheck()[4] + "<br/>");
					}
					if(!question.getCheck()[5].equals("")){
						out.println("F" + question.getCheck()[5] + "<br/>");
					}
					out.print("您的答案："+request.getParameter(Integer.toString(question.getQid()))+"<br/>");
					out.print("正确答案："+question.getAnswer()+"<br/>");
					out.println("</li>");
				}
				else if(type.equals("1")&&request.getParameter(Integer.toString(question.getQid()))!=null){
					//多选题
					out.println("<li>");
					out.println(question.getQuestion() + "<br/>");
					out.println("<input type=\"radio\" name=\"" + question.getQid() + "\" value=\"A\">" + question.getCheck()[0] + "<br/>");
					out.println("<input type=\"radio\" name=\"" + question.getQid() + "\" value=\"B\">" + question.getCheck()[1] + "<br/>");
					out.println("<input type=\"radio\" name=\"" + question.getQid() + "\" value=\"C\">" + question.getCheck()[2] + "<br/>");
					out.println("<input type=\"radio\" name=\"" + question.getQid() + "\" value=\"D\">" + question.getCheck()[3] + "<br/>");
					if(!question.getCheck()[4].equals("")){
						out.println("<input type=\"radio\" name=\"" + question.getQid() + "\" value=\"E\">" + question.getCheck()[4] + "<br/>");
					}
					if(!question.getCheck()[5].equals("")){
						out.println("<input type=\"radio\" name=\"" + question.getQid() + "\" value=\"F\">" + question.getCheck()[5] + "<br/>");
					}
					out.print("您的答案："+request.getParameter(Integer.toString(question.getQid()))+"<br/>");
					out.print("正确答案："+question.getAnswer()+"<br/>");
					out.println("</li>");
				}
				else if(type.equals("2")){
					//判断题
				}
				else {
					//错误
				}
			}
		}
		out.println("	<h1 align='center'>您的得分为：" + score + "</h1>");
		out.println("	</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}

}
