package com.iweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;







import com.iweb.dao.IQuestionDAO;
import com.iweb.entity.Judgement;
import com.iweb.entity.Question;

public class QuestionDAO extends BaseDAO implements IQuestionDAO {


//	从数据库中读取单选题
	@Override
	public List<Question> single() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  QUESTION_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
						) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//从数据库中读取判断题
	@Override
	public List<Question> judgement() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from QUESTION_JUDGMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
						) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//从数据库中读取多选题
	@Override
	public List<Question> multi() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from QUESTION_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	
	@Override
	public boolean remove(int id) throws Exception { 
		if(true)return true;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("delete from QUESTION_SINGLE where id=?");
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0 ? true :false;			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(null, pstmt, conn);
		}
		return false;

	}

	@Override
	public boolean addsingle(Question single) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into QUESTION_SINGLE(question,A,B,C,D,E,F,answer)values(?,?,?,?,?,?,?,?)");

			pstmt.setString(1, single.getQuestion());
			pstmt.setString(2, single.getCheck()[0]);
			pstmt.setString(3, single.getCheck()[1]);
			pstmt.setString(4, single.getCheck()[2]);
			pstmt.setString(5, single.getCheck()[3]);
			//pstmt.setString(6, single.getCheck()[4]);
			pstmt.setString(6, single.getAnswer());
			
			return pstmt.executeUpdate() > 0 ? true:false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close( null,pstmt,conn);
		}
		return false;
	}

	@Override
	public boolean addjudgement(Question judgement) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("insert into QUESTION_JUDGMENT(question,answer)values(?,?)");
			pstmt.setString(1, judgement.getQuestion());
			pstmt.setString(2, judgement.getAnswer());
			
			return pstmt.executeUpdate() > 0 ? true:false;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close( null,pstmt,conn);
		}
		return false;
	}

	//内务单选题
	public List<Question> neiwuSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  NEIWU_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//
	public List<Question> jilvSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JILV_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//队列单选题
	public List<Question> duilieSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  DUILIE_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//基层建设单选题
	public List<Question> jiansheSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JIANSHE_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//军兵种知识单选题
	public List<Question> junzhongSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JUNZHONG_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//军事高科技单选题
	public List<Question> jishuSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JISHU_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//军事理论单选题
	public List<Question> lilunSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  LILUN_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//作战基础知识单选题
	public List<Question> zuozhanSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  ZUOZHAN_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//训练基础理论单选题
	public List<Question> xunlianSingle() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  XUNLIAN_SINGLE order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	/**
	 *多选题
	 */
	//内务单选题
	public List<Question> neiwuMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  NEIWU_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//
	public List<Question> jilvMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JILV_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//队列单选题
	public List<Question> duilieMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  DUILIE_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//基层建设单选题
	public List<Question> jiansheMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JIANSHE_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//军兵种知识单选题
	public List<Question> junzhongMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JUNZHONG_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}

	//军事高科技单选题
	public List<Question> jishuMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JISHU_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//军事理论单选题
	public List<Question> lilunMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  LILUN_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//作战基础知识单选题
	public List<Question> zuozhanMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  ZUOZHAN_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	//训练基础理论单选题
	public List<Question> xunlianMulti() throws Exception {
		List<Question> questions = new ArrayList<Question>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  XUNLIAN_MULTI order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				questions.add(new Question(rs.getInt("id"),
						rs.getString("question"),
						new String[]{rs.getString("A"),rs.getString("B"),rs.getString("C"),rs.getString("D"),rs.getString("E"),rs.getString("F")},
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return questions;
	}
	/**
	 * 判断题
	 */
	//内务判断题
	public List<Judgement> neiwuJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  NEIWU_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}
	//纪律判断题
	public List<Judgement> jilvJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JILV_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}
	//队列判断题
	public List<Judgement> duilieJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  DUILIE_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}
	//建设判断题
	public List<Judgement> jiansheJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JIANSHE_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}

	//军种判断题
	public List<Judgement> junzhongJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JUNZHONG_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}

	//技术判断题
	public List<Judgement> jishuJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  JISHU_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}

	//理论判断题
	public List<Judgement> lilunJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  LILUN_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}

	//作战判断题
	public List<Judgement> zuozhanJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  ZUOZHAN_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}

	//训练判断题
	public List<Judgement> xunlianJudgement() throws Exception {
		List<Judgement> judgements = new ArrayList<Judgement>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		try{
			conn = getConn();
			pstmt = conn.prepareStatement("select * from  XUNLIAN_JUDGEMENT order by rand()");
			rs = pstmt.executeQuery();
			while(rs.next()){
				judgements.add(new Judgement(rs.getInt("id"),
						rs.getString("question"),
						rs.getString("answer")
				) );
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs,pstmt,conn);
		}
		return judgements;
	}
}
