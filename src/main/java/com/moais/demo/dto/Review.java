package com.moais.demo.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Review {
	
	private int no;
	private String userId;
	private int goodsNo;
	private String contents;
	private String image;
	private int width;
	private int height;
	private int like;
	private Timestamp createAt;
	private Timestamp updateAt;
	
	@Builder
	public Review(int no, String userId, int goodsNo, String contents, String image, int width, int height, int like,
					Timestamp createAt, Timestamp updateAt) {
		this.no = no;
		this.userId = userId;
		this.goodsNo = goodsNo;
		this.contents = contents;
		this.image = image;
		this.width = width;
		this.height = height;
		this.like = like;
		this.createAt = createAt;
		this.updateAt =updateAt;
	}
}
