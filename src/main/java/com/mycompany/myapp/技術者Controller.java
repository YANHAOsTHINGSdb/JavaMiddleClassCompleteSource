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
}
