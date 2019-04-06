<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>技術者検索</h1>
		<br>
		<div>
			<input id="s_ID" name="s_ID" type="hidden" Value="">
		</div>
		<br>
		<div>
			<label>技术方向</label> <input id="技术方向" name="技术方向" type="text" value="">
		</div>
		<div>
			<label>技术项目</label> <input id="技术项目" name="技术项目" type="text" value="">
		</div>
		<div>
			<label>资格-等级</label> <input id="资格-等级" name="资格-等级" type="text" value="">
		</div>
		<div>
			<label>年数-开始年月</label> <input id="年数-开始年月" name="年数-开始年月" type="text" value="">
		</div>
		<div>
			<label>技术备考说明</label> <input id="技术备考说明" name="技术备考说明" type="text" value="">
		</div>
		<br>
		<div>
			<label>经验案件名</label> <input id="经验案件名" name="经验案件名" type="text" value="">
		</div>
		<div>
			<label>经验案件概要</label> <input id="经验案件概要" name="经验案件概要" type="text" value="">
		</div>
		<div>
			<label>经验案件地点</label> <input id="经验案件地点" name="经验案件地点" type="text" value="">
		</div>
		<div>
			<label>担当职种</label> <input id="担当职种" name="担当职种" type="text" value="">
		</div>
		<div>
			<label>所在工程</label> <input id="所在工程" name="所在工程" type="text" value="">
		</div>
		<div>
			<label>开始时间</label> <input id="开始时间" name="开始时间" type="text" value="">
		</div>
		<div>
			<label>经验月数</label> <input id="经验月数" name="经验月数" type="text" value="">
		</div>
		<br>
		<div>
			<input type="button" id="search_btn" value="検索"> <input type="submit" id="add_btn" value="追加">
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