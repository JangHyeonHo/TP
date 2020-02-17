package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.question.QuestionService;
import vo.ActionForward;
import vo.QuestionBean;

public class QuestionDetailAuction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		int num = Integer.parseInt(request.getParameter("num"));
		
		QuestionService questionDetailService = new QuestionService();
		QuestionBean article = questionDetailService.getArticle(num);
		
		
		request.setAttribute("article", article);
		
		forward.setPath("/question/post.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	
}
