package com.mycompany.myapp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myapp.bean.技術者Bean;
import com.mycompany.myapp.bean.案件Bean;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;

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

//		model.addAttribute("titleName", "技術者編集");
//		model.addAttribute("モード", "編集");
//		model.addAttribute("s_ID", bean.getS_ID());
//		model.addAttribute("案件名称", bean.get案件名称());
//		model.addAttribute("案件概要", bean.get案件概要());
//		model.addAttribute("案件場所", bean.get案件場所());
//		model.addAttribute("担当職種", bean.get担当職種());
//		model.addAttribute("所在工程", bean.get所在工程());
//		model.addAttribute("作業開始年月日", bean.get作業開始年月日());
//		model.addAttribute("作業预计终了年月", bean.get作業预计终了年月());
//		model.addAttribute("作業实际终了年月", bean.get作業实际终了年月());
//		model.addAttribute("募集人数", bean.get募集人数());

		return "技術者明細";

	}

    @RequestMapping(value="技術者report")
    @ResponseBody
    public String exportExcelTest(HttpServletResponse response, @ModelAttribute("fbean") 技術者Bean 技術者bean){
        // 获取workbook对象
        Workbook workbook = exportSheetByTemplate(技術者bean) ;
        // 判断数据
        if(workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        // String excelName = "测试excel" ;
        String excelName = "report" ;
        // 重置响应对象
        response.reset();
        // 当前日期，用于导出文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HH:mm:ss");
     //   String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
        String dateStr = excelName+"-"+sdf.format(new Date());
        // 指定下载的文件名--设置响应头
        response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xlsx");
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 写出数据输出流到页面
        try {
            OutputStream output = response.getOutputStream();
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "技術者明細";
    }

    /**
     * 模版单sheet导出示例
     * @return
     */
    public Workbook exportSheetByTemplate(技術者Bean 技術者bean){
        // 查询数据,此处省略
        // 设置导出配置
        // 获取导出excel指定模版
        TemplateExportParams params =
        		new TemplateExportParams(
        				"/Users/haoyan/Desktop/data/template/template技術者履歴書_kouyou.xlsx");
        // 标题开始行
        // params.setHeadingStartRow(0);
        // 标题行数
        // params.setHeadingRows(2);
        // 设置sheetName，若不设置该参数，则使用得原本得sheet名称
        // params.setSheetName("社員信息");
        params.setSheetName("sheet1");
        Map<String,Object> map = new HashMap<String,Object>() ;

        /**
         * 关于把数据到出到excle模版的问题，我也是瞎摸索了一番
         * 最后还是看到了帖子，得以解决：
         * https://note.youdao.com/ynoteshare1/index.html?id=26794c8eb4a285828663178c0ae854a2&type=note
         *     --20190407
         */
        map.put("作成日", "2019/04/01");
        map.put("姓名", 技術者bean.get姓名()==null?"":技術者bean.get姓名());
        map.put("性别", 技術者bean.get性别()==null?"":技術者bean.get性别());
        map.put("生年月日", 技術者bean.get生年月日()==null?"":技術者bean.get生年月日());
        map.put("最終卒業学校名", 技術者bean.get最終卒業学校名()==null?"":技術者bean.get最終卒業学校名());
        map.put("会社名", 技術者bean.get会社名()==null?"":技術者bean.get会社名());
        map.put("TEL", 技術者bean.getTEL()==null?"":技術者bean.getTEL());
        map.put("FAX", 技術者bean.getFAX()==null?"":技術者bean.getFAX());

        map.put("最寄駅", 技術者bean.get最寄駅()==null?"":技術者bean.get最寄駅());
        map.put("最終学位", 技術者bean.get最終学位()==null?"":技術者bean.get最終学位());
        map.put("就職開始年月", 技術者bean.getFAX()==null?"":技術者bean.get就職開始年月());
        map.put("日本語読み能力", 技術者bean.get日本語読み能力()==null?"":技術者bean.get日本語読み能力());
        map.put("日本語書き能力", 技術者bean.get日本語書き能力()==null?"":技術者bean.get日本語書き能力());
        map.put("日本語会話能力", 技術者bean.get日本語会話能力()==null?"":技術者bean.get日本語会話能力());
        map.put("日本語レベル", 技術者bean.get日本語レベル()==null?"":技術者bean.get日本語レベル());
        map.put("英語読み能力", 技術者bean.get英語読み能力()==null?"":技術者bean.get英語読み能力());
        map.put("英語書き能力", 技術者bean.get英語書き能力()==null?"":技術者bean.get英語書き能力());
        map.put("英語会話能力", 技術者bean.get英語会話能力()==null?"":技術者bean.get英語会話能力());
        map.put("英検点数", 技術者bean.get英検点数()==null?"":技術者bean.get英検点数());

        map.put("仕事_留学_経験有無", 技術者bean.get仕事_留学_経験有無()==null?"":技術者bean.get仕事_留学_経験有無());
        map.put("仕事_留学_経験開始年月", 技術者bean.get仕事_留学_経験開始年月()==null?"":技術者bean.get仕事_留学_経験開始年月());

        // 导出excel
        return ExcelExportUtil.exportExcel(params, map);
    }

}
