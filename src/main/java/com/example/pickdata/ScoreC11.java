package com.example.pickdata;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.pickdata.beta.Beta;

public class ScoreC11 {
	Double offset;
	int pod = 20;
	double score;
	
	//단순히 계산을 위해 숫자 변경한 것
//	final double log2 = 0.30102999566;
	final double log2 = 0.30102;

	Double beta;
	Double minBeta;
	
	/*
	 * 특정 범주에 해당하는 offset을 뽑아 내기 위해서 매개 변수 대입
	 * 여기서 매개 변수는 '특정 범주에 해당하는 베타'가 되어야 한다고 판단
	 */

	public Double offsetC11(Double beta) {
		
		Beta betaClass = new Beta();
		Map<String, Double> mapc11 = betaClass.mapc11();

		minBeta = betaClass.minBeta(mapc11);

		offset = (beta) - (minBeta);

		return offset;
	}

	/*
	 * getter 사용해서 offsetC11 메소드에서 구한(저장한) offset 값을 사용
	 * offset 값으로 score 계산
	 */
	public double scoreCal(Double offset) {
		offset = getOffset();
		Double score = offset * pod / log2;

		return score;
	}

	public Double getOffset() {
		return offset;
	}

	public void setOffset(Double offset) {
		this.offset = offset;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	
}