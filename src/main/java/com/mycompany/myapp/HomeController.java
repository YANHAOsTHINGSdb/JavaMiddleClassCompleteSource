package com.mycompany.myapp;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.myapp.bean.案件Bean;
import com.mycompany.myapp.bean.検索案件Bean;
import com.mycompany.myapp.bean.検索社員Bean;
import com.mycompany.myapp.bean.社員Bean;
import com.mycompany.myapp.service.impl.案件Service;
import com.mycompany.myapp.service.impl.社員Service;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("モード", "0");

		return "社員検索";
	}

	@RequestMapping(value = "/社員", method = RequestMethod.GET)
	public String 社員(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("モード", "0");

		return "社員検索";
	}

	@RequestMapping(value = "/案件", method = RequestMethod.GET)
	public String 案件(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("モード", "0");

		return "案件検索";
	}

	/**c
	 * テストデータの配列を返却する。
	 */
	@RequestMapping(value = "getTestData", method = RequestMethod.POST)
	@ResponseBody //将返回结果转成Json
	public List<社員Bean> getTestData(@RequestBody 検索社員Bean 検索社員bean) {//@RequestBody 将Json转成Java对象

	    logger.info("call getTestData");
	    List<社員Bean> result = new ArrayList<社員Bean>();

	    社員Service 社員service = new 社員Service();

	    return 社員service.検索社員_by検索Bean(検索社員bean);

	}

	@RequestMapping(value = "案件getTestData", method = RequestMethod.POST)
	@ResponseBody //将返回结果转成Json
	public List<案件Bean> 案件getTestData(@RequestBody 検索案件Bean 検索bean) {//@RequestBody 将Json转成Java对象

	    logger.info("call 案件getTestData");
	    List<案件Bean> result = new ArrayList<案件Bean>();

	    案件Service 案件service = new 案件Service();

	    return 案件service.検索案件_by検索Bean(検索bean);
	}

	@RequestMapping(value ="社員edit", method=RequestMethod.GET)
	public String 社員edit(社員Bean bean, Model model){
		model.addAttribute("titleName", "社員編集");
		model.addAttribute("モード", "編集");
		model.addAttribute("s_ID", bean.getS_ID());
		model.addAttribute("番号", bean.get番号());
		model.addAttribute("姓名", bean.get姓名());
		model.addAttribute("電話番号", bean.get電話番号());
		model.addAttribute("性別", bean.get性別());
		model.addAttribute("生年月日", bean.get生年月日());
		model.addAttribute("入社年月日", bean.get入社年月日());
		model.addAttribute("契約種類", bean.get契約種類());

	    return "社員明細";

	}

	@RequestMapping(value ="案件edit", method=RequestMethod.GET)
	public String 案件edit(案件Bean bean, Model model){
		model.addAttribute("titleName", "案件編集");
		model.addAttribute("モード", "編集");
		model.addAttribute("s_ID", bean.getS_ID());
		model.addAttribute("名称", bean.get名称());
		model.addAttribute("概要", bean.get概要());
		model.addAttribute("場所", bean.get場所());
		model.addAttribute("時期", bean.get時期());
		model.addAttribute("人数", bean.get人数());


	    return "案件明細";

	}

    @RequestMapping(value ="社員add", method=RequestMethod.GET)
    public ModelAndView add(){

        ModelAndView modelAndView = new ModelAndView("社員明細");
        modelAndView.getModel().put("titleName", "社員追加");

        return modelAndView;
	}

    @RequestMapping(value ="add案件", method=RequestMethod.GET)
    public ModelAndView add1(){

        ModelAndView modelAndView1 = new ModelAndView("add1案件追加");
        modelAndView1.getModel().put("titleName", "案件追加");

        return modelAndView1;
	}

    @RequestMapping(value ="社員save", method=RequestMethod.POST)
    public String save(@ModelAttribute("fbean") 社員Bean bean, Model model){

    	社員Service 社員service = new 社員Service();

    	String sMsg = 社員service.追加社員_by社員Bean(bean);
    	if (StringUtils.isEmpty(sMsg)) {
    		return "社員検索";
    	}else {
    		model.addAttribute("titleName", "社員追加");
    		model.addAttribute("s_ID", bean.getS_ID());
    		model.addAttribute("番号", bean.get番号());
    		model.addAttribute("姓名", bean.get姓名());
    		model.addAttribute("電話番号", bean.get電話番号());
    		model.addAttribute("性別", bean.get性別());
    		model.addAttribute("生年月日", bean.get生年月日());
    		model.addAttribute("入社年月日", bean.get入社年月日());
    		model.addAttribute("契約種類", bean.get契約種類());
    		model.addAttribute("errorMsg", sMsg);
    		return "社員明細";
    	}
    }
    	@RequestMapping(value ="案件save", method=RequestMethod.POST)
    	public String 案件save(@ModelAttribute("fbean") 案件Bean bean, Model model){

    		案件Service 案件service = new 案件Service();

    		String sMsg = 案件service.追加案件_by案件Bean(bean);
    		if (StringUtils.isEmpty(sMsg)) {
    			return "Home1案件検索";
    		}else {
    			model.addAttribute("titleName", "案件追加");
    			model.addAttribute("s_ID", bean.getS_ID());
    			model.addAttribute("名称", bean.get名称());
    			model.addAttribute("概要", bean.get概要());
    			model.addAttribute("時期", bean.get時期());
    			model.addAttribute("場所", bean.get場所());
    			model.addAttribute("人数", bean.get人数());
     			return "案件明細";
    		}
	}

    @RequestMapping(value ="社員update", method=RequestMethod.POST)
    public String update(@ModelAttribute("fbean") 社員Bean bean, HttpSession session, Model model){

    	社員Service 社員service = new 社員Service();

    	社員service.更新社員_by社員Bean(bean);
    	model.addAttribute("モード", "1");

	    return "社員検索";
	}

    @RequestMapping(value ="案件update", method=RequestMethod.POST)
    public String 案件update(@ModelAttribute("fbean") 案件Bean bean, HttpSession session, Model model){

    	案件Service 案件service = new 案件Service();

    	案件service.更新案件_by案件Bean(bean);
    	model.addAttribute("モード", "1");

	    return "案件検索";
	}
    @RequestMapping(value ="社員delete", method=RequestMethod.POST)
    public String delete(@RequestBody 社員Bean bean, HttpSession session){

    	社員Service 社員service = new 社員Service();

    	社員service.削除社員_by社員Bean(bean);

	    return "社員検索";
	}

    @RequestMapping(value ="back", method=RequestMethod.POST)
    public String back(){

	    return "社員検索";
	}
    @RequestMapping(value ="back案件検索", method=RequestMethod.POST)
    public String back案件検索(){

	    return "案件検索";
	}
}
