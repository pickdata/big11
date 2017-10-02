package com.pickdata.beta;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Beta2 {
	
	String key = null;
	Double beta = 0.0;
	Double minBeta = 0.0;
	Double[] c11 = new Double[] { 1.8613, 0.6827, 0.1108, -0.4673, -0.752, -1.0232, -1.2449, -2.5241, -1.2892,
			-1.3312, -1.5922, 0.0 };
	Double[] c3 = new Double[] { -4.2021,	-3.0299, -2.2288, -1.7538, -1.1574, -0.8809,	-0.7598, 0.0 };
	Double[] c9 = new Double[] { -0.1807,	-0.2529, 0.4859, 	0.644,	0.8846, 1.1339, 1.2745,	0.7857, -0.1499, 0.4584, 0.1351, 0.0};
	Double[] i19 = new Double[] { -2.3813, -2.1266, -2.0, -1.6275, -1.4356, -1.2816, -1.2377, -0.5328, 0.0};
	
	public Map<String, Double> map() {
		
		Map<String, Double> map = new HashMap<String, Double>();
		// t13만 매개변수가 없음.
		map.put("bx", 0.0);
		map.put("bo", -0.9493);
		map.put("bk", -1.3525);
		map.put("bg", 0.8241);
		map.put("br", 0.0);
	
		return map;
	}

	public Map<String, Double> map(Double[] betas) {
		
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 0; i < betas.length; i++) {
			String name = "b" + i;
			Double value = betas[i];
			map.put(name, value);
		}
		return map;
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
