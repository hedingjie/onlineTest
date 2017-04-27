package com.iweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.iweb.dao.impl.QuestionDAO;
import com.iweb.entity.Judgement;
import com.iweb.entity.Question;
import com.iweb.entity.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.MARSHAL;


public class TestServlet implements Servlet{

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
		String type = request.getParameter("type");
		String content=request.getParameter("content");
		String num = request.getParameter("num");
		QuestionDAO questionDAO = new QuestionDAO();
		if(type.equals("0")){
			//单选题
			List<Question> questionsAll = null;
			try {
				if(content.equals("0")){
					//内务
					questionsAll=questionDAO.neiwuSingle();
				}
				else if(content.equals("1")){
					//纪律
					questionsAll=questionDAO.jilvSingle();
				}
				else if(content.equals("2")){
					//队列
					questionsAll=questionDAO.duilieSingle();
				}
				else if(content.equals("3")){
					//基层建设
					questionsAll=questionDAO.jiansheSingle();
				}
				else if(content.equals("4")){
					//军兵种
					questionsAll=questionDAO.junzhongSingle();
				}
				else if(content.equals("5")){
					//军事高技术
					questionsAll=questionDAO.jishuSingle();
				}
				else if(content.equals("6")){
					//军事理论
					questionsAll=questionDAO.lilunSingle();
				}
				else if(content.equals("7")){
					//作战
					questionsAll=questionDAO.zuozhanSingle();
				}
				else if(content.equals("8")){
					//训练
					questionsAll=questionDAO.xunlianSingle();
				}
				else{
					questionsAll = questionDAO.single();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Question> questions=new ArrayList<Question>();
			for(int i=0;i<Integer.valueOf(num);i++){
				questions.add(questionsAll.get(i));
			}
			((HttpServletRequest)request).getSession().setAttribute("questions", questions);
			((HttpServletRequest)request).getSession().setAttribute("content", content);
			((HttpServletRequest)request).getSession().setAttribute("type", type);
			List<Question> q = (List<Question>)((HttpServletRequest)request).getSession().getAttribute("questions");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("	<h1 align='center'>欢迎进入考试系统！</h1>");
			out.println("<form action=\"score.action\" method=\"post\">");
			out.println("	<ol id='question'>");
			for(Question single : questions){
				out.println("<li>");
				out.println(single.getQuestion() + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"A\">" + single.getCheck()[0] + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"B\">" + single.getCheck()[1] + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"C\">" + single.getCheck()[2] + "<br/>");
				if(!single.getCheck()[3].equals("")){
					out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"D\">" + single.getCheck()[3] + "<br/>");
				}
				if(!single.getCheck()[4].equals("")){
					out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"E\">" + single.getCheck()[4] + "<br/>");
				}
				if(!single.getCheck()[5].equals("")){
					out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"F\">" + single.getCheck()[5] + "<br/>");
				}
				out.println("</li>");
			}
			out.println("	</ol>");
			out.println("	<input type=\"submit\" value='提交'>");
			out.println("</form>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		else if(type.equals("1")){
			//多选题
			List<Question> questionsAll = null;
			try {
				if(content.equals("0")){
					//内务
					questionsAll=questionDAO.neiwuMulti();
				}
				else if(content.equals("1")){
					//纪律
					questionsAll=questionDAO.jilvMulti();
				}
				else if(content.equals("2")){
					//队列
					questionsAll=questionDAO.duilieMulti();
				}
				else if(content.equals("3")){
					//基层建设
					questionsAll=questionDAO.jiansheMulti();
				}
				else if(content.equals("4")){
					//军兵种
					questionsAll=questionDAO.junzhongMulti();
				}
				else if(content.equals("5")){
					//军事高技术
					questionsAll=questionDAO.jishuMulti();
				}
				else if(content.equals("6")){
					//军事理论
					questionsAll=questionDAO.lilunMulti();
				}
				else if(content.equals("7")){
					//作战
					questionsAll=questionDAO.zuozhanMulti();
				}
				else if(content.equals("8")){
					//训练
					questionsAll=questionDAO.xunlianMulti();
				}
				else{
					questionsAll = questionDAO.single();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Question>questions=new ArrayList<Question>();
			for(int i=0;i<Integer.valueOf(num);i++){
				questions.add(questionsAll.get(i));
			}
			((HttpServletRequest)request).getSession().setAttribute("questions", questions);
			((HttpServletRequest)request).getSession().setAttribute("content", content);
			((HttpServletRequest)request).getSession().setAttribute("type", type);
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("	<h1 align='center'>欢迎进入考试系统！</h1>");
			out.println("<form action=\"score.action\" method=\"post\">");
			out.println("	<ol id='question'>");

			for(Question multiple : questions){
				out.println("<li>");
				out.println(multiple.getQuestion() + "<br/>");
				out.println( multiple.getCheck()[0] + "<br/>");
				out.println( multiple.getCheck()[1] + "<br/>");
				out.println( multiple.getCheck()[2] + "<br/>");
				if(!multiple.getCheck()[3].equals("")){
					out.println( multiple.getCheck()[3] + "<br/>");
				}
				if(!multiple.getCheck()[4].equals("")){
					out.println( multiple.getCheck()[4] + "<br/>");
				}
				if(!multiple.getCheck()[5].equals("")){
					out.println( multiple.getCheck()[5] + "<br/>");
				}
				out.println("请按序输入答案："+"<input type='text' name='"+multiple.getQid()+"'value=''>");
				out.println("</li>");
			}
			out.println("	</ol>");
			out.println("	<input type=\"submit\" value='提交'>");
			out.println("</form>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		else if(type.equals("2")){
			//判断题
			List<Judgement> judgementsAll = null;
			try {
				if(content.equals("0")){
					//内务
					judgementsAll=questionDAO.neiwuJudgement();
				}
				else if(content.equals("1")){
					//纪律
					judgementsAll=questionDAO.jilvJudgement();
				}
				else if(content.equals("2")){
					//队列
					judgementsAll=questionDAO.duilieJudgement();
				}
				else if(content.equals("3")){
					//基层建设
					judgementsAll=questionDAO.jiansheJudgement();
				}
				else if(content.equals("4")){
					//军兵种
					judgementsAll=questionDAO.junzhongJudgement();
				}
				else if(content.equals("5")){
					//军事高技术
					judgementsAll=questionDAO.jishuJudgement();
				}
				else if(content.equals("6")){
					//军事理论
					judgementsAll=questionDAO.lilunJudgement();
				}
				else if(content.equals("7")){
					//作战
					judgementsAll=questionDAO.zuozhanJudgement();
				}
				else if(content.equals("8")){
					//训练
					judgementsAll=questionDAO.xunlianJudgement();
				}
				else{
//					judgements = questionDAO.single();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			List<Judgement> judgements=new ArrayList<Judgement>();
			for(int i=0;i<Integer.valueOf(num);i++){
				judgements.add(judgementsAll.get(i));
			}
			((HttpServletRequest)request).getSession().setAttribute("judgements", judgements);
			((HttpServletRequest)request).getSession().setAttribute("content", content);
			((HttpServletRequest)request).getSession().setAttribute("type", type);
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("	<h1 align='center'>欢迎进入考试系统！</h1>");
			out.println("<form action=\"score.action\" method=\"post\">");
			out.println("	<ol id='judgement'>");
			for(Judgement judgement : judgements){
				out.println("<li>");
				out.println(judgement.getQuestion() + "<br/>");
				out.println("<input type='radio' name='"+judgement.getQid()+"' value='1'>对<br/>");
				out.println("<input type='radio' name='"+judgement.getQid()+"' value='0'>错<br/>");
				out.println("</li>");
			}
			out.println("	</ol>");
			out.println("<input type=\"submit\" value='提交'>");
			out.println("</form>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		else {
			//错误参数处理
		}
	}
		// TODO Auto-generated method stub

		
	}

