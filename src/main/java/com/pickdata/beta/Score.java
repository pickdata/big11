package com.pickdata.beta;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Score {
	Double offset;
	int pod = 20;
	double score;
	final double log2 = 0.30102999566;

	Double beta;
	Double minBeta;

	public void offset() {
		Beta betaClass = new Beta();

		Map<String, Double> mapt13 = betaClass.mapc11();
		minBeta = betaClass.minBeta(mapt13);

		Set<String> keySet = mapt13.keySet();
		Iterator<String> iterator = keySet.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			beta = mapt13.get(key);
			offset = (beta) - (minBeta);
			System.out.println(beta + " - " + minBeta + " = " + offset);
		}

	}

	public void scoreCal() {
		score = offset * pod / log2;
	}

}