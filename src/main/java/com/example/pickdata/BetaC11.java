package com.example.pickdata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BetaC11 {
	
	String key = null;
	Double beta = 0.0;
	Double minBeta = 0.0;
	
	public Map<String, Double> mapc11() {
		
		Map<String, Double> mapc11 = new HashMap<String, Double>();

		Double[] betas = new Double[] { 1.8613, 
											 0.6827, 
											 0.1108, 
											-0.4673,
											-0.752,
											-1.0232,
											-1.2449,
											-2.5241,
											-1.2892,
											-1.3312,
											-1.5922,
											0.0 };

		for (int i = 0; i < betas.length; i++) {
			
			//name: 변수에 해당하는 범주 | value는 범주에 해당하는 beta 값
			String name = "b"+i;
			Double value = betas[i];
			mapc11.put(name, value);
		}
		
		return mapc11;
	}


	public Double minBeta(Map<String, Double> map) {
		
		Set<Map.Entry<String, Double>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Double>> entryIterator = entrySet.iterator();
		
		while (entryIterator.hasNext()) {
			Map.Entry<String, Double> entry = entryIterator.next();
			beta = entry.getValue();
			if (beta <= minBeta) {
				minBeta = beta;
			}
		}
		return minBeta;
	}
}
