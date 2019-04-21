package com.mycompany.myapp.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.mycompany.myapp.bean.技術者Bean;
import com.mycompany.myapp.service.文件db;
import com.mycompany.myapp.service.親Service;

public class 技術者Service  extends 親Service{

	String[] fileName = {
			"技術者ID",
			"技術項目_ID",
			"経験_案件ID",
			"技術者_社員CD",
			"姓名",
			"性别",
			"生年月日",
			"最終卒業学校名",
			"最終学位",
			"卒業技能",
			"会社名",
			"TEL",
			"FAX",
			"最寄駅",
			"就職開始年月",
			"日本語読み能力",
			"日本語書き能力",
			"日本語会話能力",
			"日本語レベル",
			"英語読み能力",
			"英語書き能力",
			"英語会話能力",
			"英検点数",
			"仕事_留学_経験有無",
			"仕事_留学_経験開始年月"
			};

	文件db file_db = new 文件db("技術者");

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

		String path;
		// 1、对技术者采番
		String 技术者ID = ID採番(file_db, "技术者ID");

		// 2、登陆该技术者所有经验案件，取得经验案件ID
		案件Service 案件service = new 案件Service();
		List 经验案件IDlist = 案件service.登陆案件情報List(bean.get経験_案件情報());
		bean.set技術項目_ID(经验案件IDlist);

		// 3、登陆技术者所有技术情报，取得技术情报ID
		技術情報Service 技術情報service = new 技術情報Service();
		List 技术情报IDlist = 技術情報service.登陆技術情报List(bean.get技術項目_情報());
		bean.set技術項目_ID(技术情报IDlist);

		// 详细信息登陆
		for(String s文件名 : fileName) {

			path = file_db.getSPath() +  s文件名 + ".txt";

			switch(s文件名) {
			case "技術者ID":
				if(!StringUtils.isEmpty(bean.get技術者ID())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get技術者ID());
				}
				break;
			case "技術項目_ID":
				// 然后把技术者ID与经验案件ID登陆
				if(!CollectionUtils.isEmpty(bean.get技術項目_ID())) {
					file_db.文件書込(path, 技术者ID + "," + listToStr(bean.get技術項目_ID()));
				}
				break;
			case "経験_案件ID":
				// 然后把技术者ID与技术情报ID登陆
				if(!CollectionUtils.isEmpty(bean.get経験_案件ID())) {
					file_db.文件書込(path, 技术者ID + "," + listToStr(bean.get経験_案件ID()));
				}
				break;
				// 最后把技术者ID与其他信息登陆
			case "技術者_社員CD":
				if(!StringUtils.isEmpty(bean.get技術者_社員CD())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get技術者_社員CD());
				}
				break;
			case "生年月日":
				if(!StringUtils.isEmpty(bean.get生年月日())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get生年月日());
				}
				break;
			case "最終卒業学校名":
				if(!StringUtils.isEmpty(bean.get最終卒業学校名())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get最終卒業学校名());
				}
				break;
			case "最終学位":
				if(!StringUtils.isEmpty(bean.get最終学位())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get最終学位());
				}
				break;
			case "卒業技能":
				if(!StringUtils.isEmpty(bean.get卒業技能())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get卒業技能());
				}
				break;
			case "会社名":
				if(!StringUtils.isEmpty(bean.get会社名())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get会社名());
				}
				break;

			case "TEL":
				if(!StringUtils.isEmpty(bean.getTEL())) {
					file_db.文件書込(path, 技术者ID + "," + bean.getTEL());
				}
				break;
			case "FAX":
				if(!StringUtils.isEmpty(bean.getFAX())) {
					file_db.文件書込(path, 技术者ID + "," + bean.getFAX());
				}
				break;
			case "最寄駅":
				if(!StringUtils.isEmpty(bean.get最寄駅())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get最寄駅());
				}
				break;
			case "就職開始年月":
				if(!StringUtils.isEmpty(bean.get就職開始年月())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get就職開始年月());
				}
				break;


			case "日本語読み能力":
				if(!StringUtils.isEmpty(bean.get日本語読み能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語読み能力());
				}
				break;
			case "日本語書き能力":
				if(!StringUtils.isEmpty(bean.get日本語書き能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語書き能力());
				}
				break;
			case "日本語会話能力":
				if(!StringUtils.isEmpty(bean.get日本語会話能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語会話能力());
				}
				break;
			case "日本語レベル":
				if(!StringUtils.isEmpty(bean.get日本語レベル())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get日本語レベル());
				}
				break;
			case "英語読み能力":
				if(!StringUtils.isEmpty(bean.get英語読み能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英語読み能力());
				}
				break;
			case "英語書き能力":
				if(!StringUtils.isEmpty(bean.get英語書き能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英語書き能力());
				}
				break;
			case "英語会話能力":
				if(!StringUtils.isEmpty(bean.get英語会話能力())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英語会話能力());
				}
				break;
			case "英検点数":
				if(!StringUtils.isEmpty(bean.get英検点数())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get英検点数());
				}
				break;
			case "仕事_留学_経験有無":
				if(!StringUtils.isEmpty(bean.get仕事_留学_経験有無())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get仕事_留学_経験有無());
				}
				break;
			case "仕事_留学_経験開始年月":
				if(!StringUtils.isEmpty(bean.get仕事_留学_経験開始年月())) {
					file_db.文件書込(path, 技术者ID + "," + bean.get仕事_留学_経験開始年月());
				}
				break;
			}
		}
	}


}
