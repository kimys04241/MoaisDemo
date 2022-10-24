package com.moais.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReviewScore {
	
	private int reviewNo;
	private int scoreSheetNo;
	private double score;
	@Builder
	public ReviewScore(int reviewNo, int scoreSheetNo, double score) {
		this.reviewNo = reviewNo;
		this.scoreSheetNo = scoreSheetNo;
		this.score = score;
	}

}
