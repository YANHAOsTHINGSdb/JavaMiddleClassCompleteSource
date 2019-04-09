<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript">
    //取得指定id的对象
    function getObj(id){
        return document.getElementById(id);
    }
    //添加行函数
    function add技术情報Row(tabName){
        //取得table的对象
        var tab=getObj(tabName);
        //添加行
        var row=tab.insertRow(tab.rows.length);
        //添加三列
        var 技术方向Cell=row.insertCell(row.cells.length);
        var 技术项目Cell=row.insertCell(row.cells.length);
        var 资格等级Cell=row.insertCell(row.cells.length);
		var 年数Cell=row.insertCell(row.cells.length);
		var 开始年月Cell=row.insertCell(row.cells.length);
		var 技术备考说明Cell=row.insertCell(row.cells.length);

        //给name输入栏和address输入栏赋值
        nameCell.innerHHTML="张三"; // 最好有下拉框并附上选项，同时还可以编辑
        addressCell.innerHTML="北京";
        //在第三列加上删除当前列按钮        

        buttonCell.innerHTML='<input value="删除"type="button"onclick="deleteRow(this)"/>';
    }
    //删除列函数，删除方法传入参数为行的索引
    function deleteRow(obj){
        var row=obj.parentNode.parentNode;
        var tab=row.parentNode;
        tab.deleteRow(row.rowIndex);
    }
</script>

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
			<label>出生年月</label> <input id="生年月日" name="生年月日" type="text" value="">
		</div>
		<div>
			<label>毕业院校</label> <input id="最終卒業学校名" name="最終卒業学校名" type="text" value="">
		</div>
		<div>
			<label>会社名</label> <input id="会社名" name="会社名" type="text" value="">
		</div>
		<div>
			<label>TEL</label> <input id="TEL" name="TEL" type="text" value="">
		</div>
		<div>
			<label>FAX</label> <input id="FAX" name="FAX" type="text" value="">
		</div>
		<div>
			<label>最寄駅</label> <input id="最寄駅" name="最寄駅" type="text" value="">
		</div>
		<div>
			<label>最終学位</label> <input id="最終学位" name="最終学位" type="text" value="">
		</div>
		<div>
			<label>就職開始年月</label> <input id="就職開始年月" name="就職開始年月" type="text" value="">
		</div>
		<div>
			<label>日本語読み能力</label> <input id="日本語読み能力" name="日本語読み能力" type="text" value="">
		</div>
		<div>
			<label>日本語書き能力</label> <input id="日本語書き能力" name="日本語書き能力" type="text" value="">
		</div>
		<div>
			<label>日本語会話能力</label> <input id="日本語会話能力" name="日本語会話能力" type="text" value="">
		</div>
		<div>
			<label>日本語レベル</label> <input id="日本語レベル" name="日本語レベル" type="text" value="">
		</div>

		<div>
			<label>英語読み能力</label> <input id="英語読み能力" name="英語読み能力" type="text" value="">
		</div>
		<div>
			<label>英語書き能力</label> <input id="英語書き能力" name="英語書き能力" type="text" value="">
		</div>
		<div>
			<label>英語会話能力</label> <input id="英語会話能力" name="英語会話能力" type="text" value="">
		</div>
		<div>
			<label>英検点数</label> <input id="英検点数" name="英検点数" type="text" value="">
		</div>
		<br>
		<div>
			<label>仕事(留学)経験有無</label> <input id="仕事_留学_経験有無" name="仕事_留学_経験有無" type="text" value="">
		</div>
		<div>
			<label>仕事(留学)経験開始年月</label> <input id="仕事_留学_経験開始年月" name="仕事_留学_経験開始年月" type="text" value="">
		</div>

<input type="button" value="添加技术情報"  onclick="add技术情報Row('tab')"/><!-- 注意这里是用id唯一识别 -->
<table width="350" height="36" border="1" id="tab">
	<tr>
		<th width="64" height="30" scope="col">技术方向</th>
		<th width="64" scope="col">技术项目</th>
		<th width="60" scope="col">资格-等级</th>
		<th width="60" scope="col">年数</th><!-- 年数与开始年月、任填其一即可，但不允许有矛盾的存在 -->
		<th width="60" scope="col">开始年月</th><!-- 年数与开始年月、任填其一即可，但不允许有矛盾的存在 -->
		<th width="120" scope="col">技术备考说明</th>
	</tr>
</table>
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