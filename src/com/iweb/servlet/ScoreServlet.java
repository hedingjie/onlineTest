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

import com.iweb.entity.Judgement;
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

		String type=(String)((HttpServletRequest)request).getSession().getAttribute("type");
//		System.out.println("type:"+type);
		List<Question> errors=new ArrayList<Question>();
//		System.out.println("score" + questions.size());
		User user = (User)((HttpServletRequest)request).getSession().getAttribute("user");
		if(type.equals("1")||type.equals("0")){
			List<Question> questions = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questions");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("	<h1>错误题目</h1>");
			for(Question question : questions){
				System.out.println((i++)+"."+request.getParameter(Integer.toString(question.getQid())));
				if(question.getAnswer().equals(request.getParameter(Integer.toString(question.getQid())))){
					score++;
				}else{
					//单选题和多选题
					out.println("<li>");
					out.println(question.getQuestion() + "<br/>");
					out.println( question.getCheck()[0] + "<br/>");
					out.println( question.getCheck()[1] + "<br/>");
					out.println( question.getCheck()[2] + "<br/>");
					if(!question.getCheck()[3].equals("")){
						out.println( question.getCheck()[3] + "<br/>");
					}
					if(!question.getCheck()[4].equals("")){
						out.println( question.getCheck()[4] + "<br/>");
					}
					if(!question.getCheck()[5].equals("")){
						out.println( question.getCheck()[5] + "<br/>");
					}
					out.print("您的答案："+request.getParameter(Integer.toString(question.getQid()))+"<br/>");
					out.print("正确答案：<font color='red'>"+question.getAnswer()+"</font><br/>");
					out.println("</li>");
				}
			}
			out.println("	<h1 align='center'>总分为："+questions.size()+"分，您的得分为：<font color='red'>" + score + "</h1>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		else if(type.equals("2")){
			//判断题
			List<Judgement> judgements = (List<Judgement>)((HttpServletRequest)request).getSession().getAttribute("judgements");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("	<h1>错误题目</h1>");
			for(Judgement judgement : judgements){
				System.out.println((i++)+"."+request.getParameter(Integer.toString(judgement.getQid())));
				if(judgement.getAnswer().equals(request.getParameter(Integer.toString(judgement.getQid())))){
					score++;
				}else if(request.getParameter(Integer.toString(judgement.getQid()))!=null){
					//判断题
					out.println("<li>");
					out.println(judgement.getQuestion() + "<br/>");
					out.print("您的答案："+(request.getParameter(Integer.toString(judgement.getQid())).equals("1")?"对":"错")+"<br/>");
					out.print("正确答案：<font color='red'>"+(judgement.getAnswer().equals("1")?"对":"错")+"</font><br/>");
					out.println("</li>");
				}
				else{
					//判断题
					out.println("<li>");
					out.println(judgement.getQuestion() + "<br/>");
					out.print("您的答案：null<br/>");
					out.print("正确答案：<font color='red'>"+(judgement.getAnswer().equals("1")?"对":"错")+"</font><br/>");
					out.println("</li>");
				}
			}
			out.println("	<h1 align='center'>总分为："+judgements.size()+"分，您的得分为：<font color='red'>" + score + "</font></h1>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
	}

}
