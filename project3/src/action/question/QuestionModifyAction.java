package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionModifyAction  implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int num = Integer.parseInt(request.getParameter("question_num")); //������ �۹�ȣ
		
		QuestionService questionService = new QuestionService();
		QuestionBean article = questionService.getModifyArticle(num);//������ �Խñ�����
		
		request.setAttribute("article", article);

		forward = new ActionForward();
		forward.setPath("/question/modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	
}
