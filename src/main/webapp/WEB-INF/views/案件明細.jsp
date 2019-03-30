<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>案件明細</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>


</head>
<body>
	<script>
	$(function() {
		$("#back_btn").click(function() {
		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/back案件検索");
		    $("#fbean").submit();
		});

		$("#save_btn").click(function() {
			if("${モード}" == "編集"){
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/案件update");
			    $("#fbean").submit();

			}else{
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/案件save");
			    $("#fbean").submit();
			}
		});

	});

	</script>

	<form id ="fbean" name="fbean" method="post">

	<h1>${titleName}</h1>

	<input type="hidden" value="${s_ID}" name="s_ID"/>

	<div>
		<label>案件名称</label>
		<input type="text" value="${案件名称}" name="案件名称"/>
		<input type="hidden" value="${案件名称}" name="old_案件名称" />
	</div>
	<br>
	<div>
		<label>案件概要</label>
		<input type="text" value="${案件概要}" name="案件概要" />
		<input type="hidden" value="${案件概要}" name="old_案件概要" />
	</div>
	<br>
	<div>
		<label>案件場所</label>
		<input type="text" value="${案件場所}" name="案件場所" />
		<input type="hidden" value="${案件場所}" name="old_案件場所" />
	</div>
	<br>
	<div>
		<label>職種</label>
		<input type="text" value="${職種}" name="職種" />
		<input type="hidden" value="${職種}" name="old_職種" />
	</div>
	<br>
	<div>
		<label>工程</label>
		<input type="text" value="${工程}" name="工程" />
		<input type="hidden" value="${工程}" name="old_工程" />
	</div>
	<br>
	<div>
		<label>案件開始日</label>
		<input type="text" value="${案件開始日}"
			placeholder="YYYY/MM/DD"
			type="text" name="案件開始日"/>
		<input type="hidden" value="${案件開始日}" name="old_案件開始日" />
	</div>
	<br>
	<div>
		<label>予定終了日</label>
		<input type="text" value="${予定終了日}"
			placeholder="YYYY/MM/DD"
			type="text" name="予定終了日"/>
		<input type="hidden" value="${予定終了日}" name="old_予定終了日" />
	</div>
	<br>
	<div>
		<label>実際終了日</label>
		<input type="text" value="${実際終了日}"
			placeholder="YYYY/MM/DD"
			type="text" name="実際終了日"/>
		<input type="hidden" value="${実際終了日}" name="old_実際終了日" />
	</div>
	<br>
	<div>
		<label>人数</label>
		<input type="text" Value="${人数}" name="人数"
			placeholder="例。2"
			type="text"/>
		<input type="hidden" value="${人数}" name="old_人数" />
	</div>
	<br>
	<div>
		<input type="button" id="back_btn" Value="戻る">
	</div>
	<br>

	<div>
		<input type="button" id="save_btn" Value="登録">
	</div>

	<h1>${errorMsg}</h1>
</form>
</body>
</html>
