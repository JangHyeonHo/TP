package svc.question;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardBean;
import vo.PageInfo;
import vo.QuestionBean;

import static db.JdbcUtil.*;

public class QuestionService {

	// �� �Խñ� ��
	public int getListCount() throws Exception{
		int listCount =0;
		Connection con = getConnection();
		QuestionDAO questionDAO = getConnection();
		questionDAO.setConnection(con);
		listCount = questionDAO.selectListCount();
		close(con);
		
		return listCount;
		
	}
	
	//�Խñ� ����Ʈ
	public ArrayList<QuestionBean> getArticleList(int page, int limit) throws Exception{
		
		ArrayList<QuestionBean> articleList =null;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		articleList = questionDAO.selectArticleList(page,limit);
		close(con);
		
		return articleList;
		
		
	}
	
	//�Խñ� ����
	
	public boolean registArticle(QuestionBean questionBean) {
		
		boolean isWriteSuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int insertCount = questionDAO.insertArticle(questionBean);
		
		if(insertCount >0) isWriteSuccess =true;
		
		close(con); 
		
		return isWriteSuccess;
	}
	
	
	//��� ���� �ʿ����
	
	//�Խñ� �󼼺���(��ȸ���ʿ����)
	
	public QuestionBean getArticle(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUP(num);
		close(con);
		
		return bean;
	}
	
	//������ �Խñ� �� ����
	public QuestionBean getModifyArticle(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		QuestionBean bean = questionDAO.contentLookUP(num);
		close(con);
		
		return bean;
		
	}
	
	//��й�ȣ �ʿ����
	
	//�Խñ� ����
	
	public void questionDelete(int num) {
		
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		questionDAO.questionDelete(num);
		
		close(con);
	}
	
	public boolean modifyArticle(QuestionBean questionBean) {
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		QuestionDAO questionDAO =QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		int isertCount = boardDAO.updateModifyArticle(questionBean);
		
		if(insertCount >0) isModifySuccess = true;
		
		close(con);
		
		return isModifySuccess;
		
	}
	public ArrayList<QuestionBean> boardSearch(String choice, String input) {

		ArrayList<QuestionBean> articleList = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);

		if("subject".equals(choice)) articleList = questionDAO.subjectSearchList(input);
		else if("board_name".equals(choice)) articleList = questionDAO.nameSearchList(input);
		
		close(con);
		
		return articleList;
		
	}

	public PageInfo searchPageInfo(String choice, String input) {
		
		PageInfo pageInfo = null;
		Connection con = getConnection();
		QuestionDAO questionDAO = QuestionDAO.getInstance();
		questionDAO.setConnection(con);
		
		if("subject".equals(choice)) pageInfo = questionDAO.subjectSearchCount(input);
		else if("board_name".equals(choice)) pageInfo = questionDAO.nameSearchCount(input);
		
		return pageInfo;
	}
	
	
	
}
