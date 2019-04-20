package com.mycompany.myapp.service.impl;

import java.util.List;

import com.mycompany.myapp.bean.技術者Bean;
import com.mycompany.myapp.service.文件db;
import com.mycompany.myapp.service.親Service;

public class 技術者Service  extends 親Service{
	// "名称" 必须放在0号位，否则全件检索时会出问题
	String[] fileName = { "技術者ID", "技術項目_ID", "技術者_社員CD", "生年月日", "最終卒業学校名", "最終学位", "卒業技能", "会社名", "募集人数", "チーム人数", "開発言語" , "FrameWork", "ツール", "OS", "DB"};

	文件db file_db = new 文件db("案件");

	public String 追加技術者_by技術者Bean(技術者Bean bean) {
//		文件db file_db = new 文件db("技術者");
//
//		// ①チェック入力
//		file_db.情報読み込み(fileName);

		// ②追加処理
		追加技術者_byFile_db_技術者Bean(bean);

		return "";
	}

	private void 追加技術者_byFile_db_技術者Bean(技術者Bean bean) {

		// 先对技术者采番
		String 技术者ID = ID採番(file_db, "技术者ID");

		// 再该技术者所有经验案件登陆了，取得经验案件ID
		案件Service 案件service = new 案件Service();
		List 经验案件IDlist = 案件service.登陆案件情報List(bean.get経験_案件情報());

		// 再把技术者所有技术情报登陆了，取得技术情报ID
		技術情報Service 技術情報service = new 技術情報Service();
		List 技术情报IDlist = 技術情報service.登陆技術情报List(bean.get技術項目_情報());

		// 然后把技术者ID与经验案件ID登陆

		// 然后把技术者ID与技术情报ID登陆

		// 最后把技术者ID与其他信息登陆
	}

}
