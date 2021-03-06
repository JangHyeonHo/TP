package action.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import action.Action;
import svc.question.QuestionService;
import vo.ActionForward;

public class QuestionDeleteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;//게시글 번호
		int Question_num = Integer.parseInt(request.getParameter("question_num")); //문의글 번호
		System.out.println(Question_num);
		
		String input = request.getParameter("input");//비번인데 일딴 넣어봄
		System.out.println(input);
		
		QuestionService questionService = new QuestionService();
		String passwd = questionService.getPass(Question_num);
		System.out.println(passwd);
		
		/* 안쓰나?
		 * if("ajax".equals(request.getParameter("Handler"))){
		 * 
		 * }
		 */
		
		if(passwd.equals(input)) {
			questionService.questionDelete(Question_num);
			JSONObject result = new JSONObject();
			result.put("result", "success");
			String jsonInfo = result.toJSONString();
			request.setAttribute("jsonInfo", jsonInfo);
			
		}else {
			JSONObject result = new JSONObject();
			result.put("result","fail");
			String jsonInfo = result.toJSONString();
			request.setAttribute("jsonInfo", jsonInfo);
			
		}
		
		
		
		return forward;
	}

	
}
