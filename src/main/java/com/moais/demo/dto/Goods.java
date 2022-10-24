package com.moais.demo.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Goods {
	
	private int no;
	private int brandCd;
	private int goodsTypeCd;
	private String title;
	private String contents;
	private String image;
	private int width;
	private int height;
	private Timestamp createAt;
	private Timestamp updateAt;
	
	@Builder
	public Goods(int no, int brandCd, int goodsTypeCd, String title, String contents, String image, int width, int height,
				Timestamp createAt, Timestamp updateAt) throws Exception {
		this.no = no;
		this.brandCd = brandCd;
		this.goodsTypeCd = goodsTypeCd;
		this.title = title;
		this.contents = contents;
		this.image = image;
		this.width = width;
		this.height = height;
		this.createAt = createAt;
		this.updateAt = updateAt;
		
	}
	

}
