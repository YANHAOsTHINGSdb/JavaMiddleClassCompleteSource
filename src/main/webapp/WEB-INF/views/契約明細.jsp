<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--HTML 5対応--%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>契約明細</title>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.json.js"></script>

<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>


</head>
<body>
	<script>
	$(function() {
		$("#back_btn").click(function() {
		    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/back契約検索");
		    $("#fbean").submit();
		});

		$("#save_btn").click(function() {
			if("${モード}" == "編集"){
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/契約update");
			    $("#fbean").submit();

			}else{
			    $("#fbean").attr("action","http://localhost:8080/JavaMiddleClassCompleteSource/契約save");
			    $("#fbean").submit();
			}
		});

	});



	</script>

	<form id ="fbean" name="fbean" method="post">

	<h1>${titleName}</h1>

	<input type="text" value="${契約_ID}" name="契約_ID"/>(隐藏项目=契約_ID，调试用)

	<div>
		<label>契约CD</label>
		<input type="text" value="${契约CD}" name="契约CD"/>
		<input type="hidden" value="${契约CD}" name="old_契约CD" />

		<select id="単位" name="単位" style="width: 60px">
		<option value="円">円</option>
		<option value="万円">万円</option>
		</select>
	</div>
	<br>
	<div>
					<label>结算币种</label>
					<select id="结算币种" name="结算币种" style="width: 60px">
						<option value="日元">日元</option>
						<option value="美元">美元</option>
						<option value="人民币">人民币</option>
					</select>
	</div>
	<br>
	<div>
			<label>含交通费</label> <select id="含交通费" name="含交通费" style="width: 60px">
				<option value="" selected="selected"></option>
				<option value="是">是</option>
				<option value="否">否</option>
			</select>
	</div>
	<br>
	<div>
			<label>契约期</label> <input id="契约期" type="text" Value=""
				placeholder="例，1月" type="text">
			<label></label> <select id="契约期" name="契约期" style="width: 60px">
				<option value="年">年</option>
				<option value="月">月</option>
				<option value="长期有效">长期有效</option>
			</select>
	</div>
	<br>
	<div>
			<label>契约实际终了日</label>
			<input id="契约实际终了日" type="text" Value=""
					placeholder="YYYY/MM/DD" type="text">
	</div>
	<br>
		<div>
			<label>契约种别</label> <select id="契约种别" name="契约种别"
				style="width: 150px">
				<option value="一般雇佣">一般雇佣</option>
				<option value="一括">一括</option>
				<option value="請負">請負</option>
				<option value="其他">其他</option>
			</select>
		</div>
	<br>
		<div>

			<label>甲方</label> <input id="甲方" name="甲方" type="text" Value=""
			placeholder="例，宏扬株式会社" type="text" disabled>

			<input type="button" id="search_btn1" Value="参照">
		</div>
		<br>

		<div>

			<label>乙方</label> <input id="乙方" name="乙方" type="text" Value=""
			placeholder="例，颜老师" type="text" disabled>
			<input type="button" id="search_btn2" Value="参照">
		</div>
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
