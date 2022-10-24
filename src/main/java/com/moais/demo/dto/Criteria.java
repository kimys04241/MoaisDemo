package com.moais.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Criteria {

	private int pageNum;
	private int amount;
	private int goodsNo;
	private int scoreType;
	
	
	@Builder
	public Criteria(int pageNum, int amount, int goodsNo, int scoreType) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.goodsNo = goodsNo;
		this.scoreType = scoreType;
	}
	
	public void vaild() {
		pageNum = pageNum < 0? 1 : pageNum;
		amount = amount < 0? 10 : amount;
	}
}
