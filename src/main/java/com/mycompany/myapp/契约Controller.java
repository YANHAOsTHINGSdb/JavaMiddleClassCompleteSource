package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myapp.bean.契約Bean;
import com.mycompany.myapp.bean.契約検索Bean;
import com.mycompany.myapp.service.impl.契約Service;

@Controller
public class 契约Controller {

	private static final Logger logger = LoggerFactory.getLogger(契约Controller.class);

	/**
	 * 输入一下网址，会到这里
	 * 【http://localhost:8080/JavaMiddleClassCompleteSource/契约】
	 * 第五课时会讲到这里！
	 *
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/契約", method = RequestMethod.GET)
	public String 契約(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("モード", "0");

		return "契約検索";  // 注意SPRINGMVC会自动去找 契约検索.jsp 这个文件！！！ 2019-2-10
	}


	/**
	 * 当检索按钮按下时回到这里！
	 * @param 検索契约Bean  就是将检索页面所有的信息都放到这个class里
	 * @return 契约Bean    就是将检索结果都放到这个Class里，
	 *                    注意，是List<契约Bean>结构，为什么，
	 *                    因为每个契约Bean就是一条记录
	 *                    会有多条结果，就会是List。
	 */
	@RequestMapping(value = "契约getTestData", method = RequestMethod.POST)
	@ResponseBody //将返回结果转成Json
	public List<契約Bean> 契約getTestData(@RequestBody 契約検索Bean 検索bean) {//@RequestBody 将Json转成Java对象

	    logger.info("call 契约getTestData");

	    契約Service 契約service = new 契約Service();

	    return 契約service.検索契約_by検索Bean(検索bean); // 这里可以采用先上车后买票的方法
	                                                   // 先把bean定义完之后，再实装这里。
	}
}
