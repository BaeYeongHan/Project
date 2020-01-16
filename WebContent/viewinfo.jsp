<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewinfo</title>
</head>
<body>
<form method= post action="" class="contact_form" id="contact_form">
	<label> 제목</label>
							<input type="text" name ="title" class="contact_input" value="" required="required">
							<label> 작성자</label>
							<input type="text" name = "who" class="contact_input" value="" required="required"readonly>
							<label> 작성일자</label>
							<input type="text" class="contact_input" value=""readonly name="date">
							<input type="hidden" name= "id" class="contact_input" placeholder="">
							<label> 내용</label>
							<textarea class="contact_input contact_textarea" name="sub" placeholder="" required="required"></textarea>
							<input type= button class="contact_button" name="update" value="update"></button>
							<input type= button class="contact_button" name="delete" value="delete"></button>
						</form>
</body>
</html>