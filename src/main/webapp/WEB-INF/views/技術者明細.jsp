<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>技術者追加編集照会</h1>
		<br>
		<div>
			<input id="s_ID" name="s_ID" type="hidden" Value="">
		</div>
		<br>
		<div>
			<label>社員CD</label> <input id="社員CD" name="社員CD" type="text" value=""><input type="button" id="search_btn" value="検索">
		</div>
		<br>
		<div>
			<label>姓名</label> <input id="姓名" name="姓名" type="text" value="">
		</div>
		<div>
			<label>性别</label> <input id="性别" name="性别" type="text" value="">
		</div>
		<div>
			<label>出生年月</label> <input id="出生年月" name="出生年月" type="text" value="">
		</div>
		<div>
			<label>毕业院校</label> <input id="毕业院校" name="毕业院校" type="text" value="">
		</div>
		<br>
		<div>
			<input type="submit" id="add_btn" value="追加"> <input type="button" id="delete_btn" value="削除">
		</div>
		<br>
		<br>
		<div>
			<input type="button" id="login_btn" value="登録">
		</div>
		<div>
			<input type="button" id="back_btn" value="戻る">
		</div>
		<br>
		<div>
			<table id="emlist" style="width: 70%">
				<thead>
					<tr>
						<th></th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
		</div>
		<br>
		<div>
		    <div id="example-table"></div>
		</div>
</body>
</html>