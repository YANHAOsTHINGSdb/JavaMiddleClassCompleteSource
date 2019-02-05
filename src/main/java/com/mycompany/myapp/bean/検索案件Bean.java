package com.mycompany.myapp.bean;

import lombok.Data;

@Data
public class 検索案件Bean {
	String s_ID;
	String 名称;
	String 概要;
	String 場所;
	String 時期終了;
	String 時期開始;
	String 最少人数;
	String 最大人数;
}