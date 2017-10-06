package com.pickdata.beta;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ScoreT13 {
	Double offset;
	int pod = 20;
	double score;
	final double log2 = 0.30102999566;

	Double beta;
	Double minBeta;

	public void offset() {
		Beta betaClass = new Beta();

		Map<String, Double> mapt13beta = betaClass.mapt13();
		minBeta = betaClass.minBeta(mapt13beta);

		Set<String> keySet = mapt13beta.keySet();
		Iterator<String> iterator = keySet.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			beta = mapt13beta.get(key);
			offset = (beta) - (minBeta);
			System.out.println(beta + " - " + minBeta + " = " + offset);
		}

	}

	public Double scoreCal() {
		return score = offset * pod / log2;
	}

}