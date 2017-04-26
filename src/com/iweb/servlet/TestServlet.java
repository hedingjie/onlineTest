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
			List<Question> questions = null;
			try {
				if(content.equals("0")){
					//内务
					questions=questionDAO.neiwuSingle();
				}
				else if(content.equals("1")){
					//纪律
					questions=questionDAO.jilvSingle();
				}
				else if(content.equals("2")){
					//队列
					questions=questionDAO.duilieSingle();
				}
				else if(content.equals("3")){
					//基层建设
					questions=questionDAO.jiansheSingle();
				}
				else if(content.equals("4")){
					//军兵种
					questions=questionDAO.junzhongSingle();
				}
				else if(content.equals("5")){
					//军事高技术
					questions=questionDAO.jishuSingle();
				}
				else if(content.equals("1")){
					//军事理论
					questions=questionDAO.lilunSingle();
				}
				else if(content.equals("1")){
					//作战
					questions=questionDAO.zuozhanSingle();
				}
				else if(content.equals("1")){
					//训练
					questions=questionDAO.xunlianSingle();
				}
				else{
					questions = questionDAO.single();
				}
			} catch (Exception e) {
				e.printStackTrace();
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
			int flag = Integer.valueOf(num);
			int order=1;
			JSONObject json=new JSONObject();
			List<Map>  list=new ArrayList<Map>();
			for(Question single : questions){
				out.println("<li>");
				out.println(single.getQuestion() + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"A\">" + single.getCheck()[0] + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"B\">" + single.getCheck()[1] + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"C\">" + single.getCheck()[2] + "<br/>");
				out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"D\">" + single.getCheck()[3] + "<br/>");
				if(!single.getCheck()[4].equals("")){
					out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"E\">" + single.getCheck()[4] + "<br/>");
				}
				if(!single.getCheck()[5].equals("")){
					out.println("<input type=\"radio\" name=\"" + single.getQid() + "\" value=\"F\">" + single.getCheck()[5] + "<br/>");
				}
				out.println("</li>");
				order++;
				flag--;
				if(flag == 0 ){
					break;
				}
			}
			out.println("	</ol>");
			out.println("	<a href=\"/testweb/score.action\"><input type=\"submit\" value=提交></a>");
			out.println("</form>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		else if(type.equals("1")){
			//多选题
			List<Question> questions = null;
			try {
				if(content.equals("0")){
					//内务
					questions=questionDAO.neiwuMulti();
				}
				else if(content.equals("1")){
					//纪律
					questions=questionDAO.jilvMulti();
				}
				else if(content.equals("2")){
					//队列
					questions=questionDAO.duilieMulti();
				}
				else if(content.equals("3")){
					//基层建设
					questions=questionDAO.jiansheMulti();
				}
				else if(content.equals("4")){
					//军兵种
					questions=questionDAO.junzhongMulti();
				}
				else if(content.equals("5")){
					//军事高技术
					questions=questionDAO.jishuMulti();
				}
				else if(content.equals("1")){
					//军事理论
					questions=questionDAO.lilunMulti();
				}
				else if(content.equals("1")){
					//作战
					questions=questionDAO.zuozhanMulti();
				}
				else if(content.equals("1")){
					//训练
					questions=questionDAO.xunlianMulti();
				}
				else{
					questions = questionDAO.single();
				}
			} catch (Exception e) {
				e.printStackTrace();
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
			int flag = Integer.valueOf(num);
			int order=1;
			JSONObject json=new JSONObject();
			List<Map>  list=new ArrayList<Map>();
			for(Question multiple : questions){
				out.println("<li>");
				out.println(multiple.getQuestion() + "<br/>");
				out.println( multiple.getCheck()[0] + "<br/>");
				out.println( multiple.getCheck()[1] + "<br/>");
				out.println( multiple.getCheck()[2] + "<br/>");
				if(!multiple.getCheck()[4].equals("")){
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
				order++;
				flag--;
				if(flag == 0 ){
					break;
				}
			}
			out.println("	</ol>");
			out.println("	<a href=\"/testweb/score.action\"><input type=\"submit\" value=提交></a>");
			out.println("</form>");
			out.println("	</body>");
			out.println("</html>");
			out.flush();
			out.close();
		}
		else if(type.equals("2")){
			//判断题
			List<Judgement> judgements = null;
			try {
				if(content.equals("0")){
					//内务
					judgements=questionDAO.neiwuJudgement();
				}
				else if(content.equals("1")){
					//纪律
					judgements=questionDAO.jilvJudgement();
				}
				else if(content.equals("2")){
					//队列
					judgements=questionDAO.duilieJudgement();
				}
				else if(content.equals("3")){
					//基层建设
					judgements=questionDAO.jiansheJudgement();
				}
				else if(content.equals("4")){
					//军兵种
					judgements=questionDAO.junzhongJudgement();
				}
				else if(content.equals("5")){
					//军事高技术
					judgements=questionDAO.jishuJudgement();
				}
				else if(content.equals("1")){
					//军事理论
					judgements=questionDAO.lilunJudgement();
				}
				else if(content.equals("1")){
					//作战
					judgements=questionDAO.zuozhanJudgement();
				}
				else if(content.equals("1")){
					//训练
					judgements=questionDAO.xunlianJudgement();
				}
				else{
//					judgements = questionDAO.single();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			((HttpServletRequest)request).getSession().setAttribute("judgements", judgements);
			((HttpServletRequest)request).getSession().setAttribute("content", content);
			((HttpServletRequest)request).getSession().setAttribute("type", type);
			List<Judgement> q = (List<Judgement>)((HttpServletRequest)request).getSession().getAttribute("judgements");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("	<h1 align='center'>欢迎进入考试系统！</h1>");
			out.println("<form action=\"score.action\" method=\"post\">");
			out.println("	<ol id='question'>");
			int flag = Integer.valueOf(num);
			int order=1;
			JSONObject json=new JSONObject();
			List<Map>  list=new ArrayList<Map>();
			for(Judgement judgement : judgements){
				out.println("<li>");
				out.println(judgement.getQuestion() + "<br/>");
				out.println("<input type='radio' name='"+judgement.getQid()+"'value='1'>对<br/>");
				out.println("<input type='radio' name='"+judgement.getQid()+"'value='0'>错<br/>");
				out.println("</li>");
				order++;
				flag--;
				if(flag == 0 ){
					break;
				}
			}
			out.println("	</ol>");
			out.println("	<a href=\"/testweb/score.action\"><input type=\"submit\" value=提交></a>");
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

