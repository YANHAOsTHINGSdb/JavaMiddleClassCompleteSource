package com.mycompany.myapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.mycompany.myapp.service.impl.AndCalc;
import com.mycompany.myapp.service.impl.Calc;
import com.mycompany.myapp.service.impl.NotCalc;

public class 親Service {

	@SuppressWarnings("unchecked")
	protected List<String> get最終結果_by中間結果(Map<String,List<String>> 中間結果List) {

		List<String> 最終結果list = new ArrayList<String>();

		Calc calc = null;

		boolean isFirst = true;

		//for (List<String> 中間List : 中間結果List) {
		for (Entry<String, List<String>> 中間結果 : 中間結果List.entrySet()) {

			List 中間List = 中間結果.getValue();
			String sKey = 中間結果.getKey();

			if (StringUtils.equals(sKey, "削除年月日")) {
				calc = new NotCalc();
			}else {
				calc = new AndCalc();
			}

			// 如果中間結果为空，不需要进行論理計算，所以continue
			if (中間List == null) {

				continue;

			}

			// 第一个中間結果，不需要进行論理計算，所以continue
			if (isFirst == true) {

				最終結果list = new ArrayList<String>(中間List);
				isFirst = false;

				continue;
			}

			// 其他情况，需要进行【論理計算】
			// 論理計算：
			//           {1,2,3} and {2,3,4} = {2,3}
			//           {1,2,3} or {2,3,4}  = {1,2,3,4}
			//           {1,2,3} not {2,3,4} = {1}
			//           {2,3,4} not {1,2,3} = {4}

			最終結果list = calc.論理計算(最終結果list, 中間List);
		}

		return 最終結果list;
	}
/**
 *
 * @param s業務名 例　"案件名称"
 * @return
 */
	protected String ID採番(文件db file_db, String s項目名) {

		try {
			// ①採番
			return file_db.採番(file_db.getSPath() + s項目名 + ".txt")+1 +"";

		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 将str转成List
	 * 背景：因为我们要对应一对多的情况，就是一个ID要对应其他项目的多个ID的情况，所以会有内容为ID群的情况
	 * @param strs
	 * @return
	 */
	protected List<String> stringToList(String strs){
		String str[] = strs.split("\\t");
		return Arrays.asList(str);
	}

	/**
	 * 将List转成str
	 * 背景：因为我们要对应一对多的情况，就是一个ID要对应其他项目的多个ID的情况，所以会有内容为ID群的情况
	 * @param list
	 * @return
	 */
	protected String listToStr(List<String> list) {

		String listString = "";
		for (String s : list)
		{
		    listString += s + "\t";
		}
		return listString;
	}
}
