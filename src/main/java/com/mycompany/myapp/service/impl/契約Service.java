package com.mycompany.myapp.service.impl;

import java.util.List;
import java.util.Map;

import com.mycompany.myapp.bean.契約Bean;
import com.mycompany.myapp.bean.検索契約Bean;
import com.mycompany.myapp.service.文件db;

/**
 * 完成后对【契约】信息的增删改查处理
 *
 * by 张大宝，张子怡，陈老师，朱老师，唐老师 2019-2-16
 */
public class 契約Service {
	/**
	 * fileName完全参照式样书的数据结构中的项目
	 */
	String[] fileName = { "契约ID", "单价", "开始日期", "契约期", "契约种别", "结算币种", "契约实际终了日",
			"契约CD", "含交通费", "备考说明", "甲方契约者ID", "乙方契约者ID" };

	/**
	 * 在Service中需要【文件db】提供服务
	 *
	 * 注：
	 * 文件db是公用的，已经写好了，不需要你去写了。
	 * 你所要做的工作就到此为止了。
	 */
	文件db file_db = new 文件db();

	/**
	 * 完成检索任务
	 * 具体可以参考其它页面。
	 * @param 検索bean 画面的条件信息
	 * @return List<契约Bean>
	 */
	public List<契約Bean> 検索契約_by検索Bean(検索契約Bean 検索bean) {
		file_db.情報読み込み(fileName);

		Map<String,List<String>> 中間結果IDList = get中間結果_by社員検索Bean(検索bean);

		List<String> 最終結果IDList = get最終結果_by中間結果(中間結果IDList);

		return 取得検索結果_by最終結果(最終結果IDList);
	}

	private Map<String, List<String>> get中間結果_by社員検索Bean(検索契約Bean 検索bean) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private List<String> get最終結果_by中間結果(Map<String, List<String>> 中間結果idList) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	private List<契約Bean> 取得検索結果_by最終結果(List<String> 最終結果idList) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
