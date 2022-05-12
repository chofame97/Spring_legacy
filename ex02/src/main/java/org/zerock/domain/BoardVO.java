package org.zerock.domain;

import java.util.Date;

import lombok.Data;
import lombok.extern.log4j.Log4j;


@Data
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	
	
}
