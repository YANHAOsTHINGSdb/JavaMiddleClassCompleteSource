package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.bean.案件Bean;

@Controller
public class 技術者Controller {

	private static final Logger logger = LoggerFactory.getLogger(技術者Controller.class);

	@RequestMapping(value = "/技術者", method = RequestMethod.GET)
	public String 案件(Locale locale, Model model) {
		logger.info("call 技術者");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("モード", "0");

		return "技術者検索"; // 技術者検索.jsp
	}

	@RequestMapping(value = "技術者edit", method = RequestMethod.GET)
	public String 案件edit(案件Bean bean, Model model) {
		logger.info("call 案件edit");

		model.addAttribute("titleName", "案件編集");
		model.addAttribute("モード", "編集");
		model.addAttribute("s_ID", bean.getS_ID());
		model.addAttribute("案件名称", bean.get案件名称());
		model.addAttribute("案件概要", bean.get案件概要());
		model.addAttribute("案件場所", bean.get案件場所());
		model.addAttribute("担当職種", bean.get担当職種());
		model.addAttribute("所在工程", bean.get所在工程());
		model.addAttribute("作業開始年月日", bean.get作業開始年月日());
		model.addAttribute("作業预计终了年月", bean.get作業预计终了年月());
		model.addAttribute("作業实际终了年月", bean.get作業实际终了年月());
		model.addAttribute("募集人数", bean.get募集人数());

		return "案件明細";

	}
}
