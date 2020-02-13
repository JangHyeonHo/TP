<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>inquiry 문의</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/question/css/inquiry.css">
</head>
<body>
	<article>
		<div class="inquiry_wrap">
			<div class="inquiry_input">
				<h1 align="center">1:1 문의하기</h1>
				<form action="${pageContext.request.contextPath}/inquiryPro.do" method="post" id="inquiry_form">
					<table>
						<tr>
							<th>작성자</th>
							<td>
								<input type="text" id="writer" name="writer">
							</td>
						</tr>
						<tr>
							<th scope="row">상담분류</th>
							<td>
								<select style="width:280px; height:30px" title="문의분야 선택" class="select_st">
									<option value="">뭐</option>
									<option value="">하</option>
									<option value="">지</option>
									<option value="">?</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>문의제목</th>
							<td>
								<input type="text" id="subject" name="subject">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td>
								<textarea rows="30" cols="10" id="content" name="content"></textarea>
							</td>
						</tr>
					</table>
					<div class="inquiry_button">
						<input class="button" id="inquiry_submit" type="button" value="등록">
						<input class="button" type="reset" value="다시쓰기">
						<input class="button" type="button" value="목록" onclick="javascript:history.go(-1)">
					</div>
					
				</form>
			</div>
		</div>
	</article>
		<script src="${pageContext.request.contextPath}/notice_board/js/jquery-3.4.1.min.js"></script>
		<script src="${pageContext.request.contextPath}/notice_board/js/writing.js"></script>

</body>
</html>