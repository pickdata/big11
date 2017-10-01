package com.pickdata.beta;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Beta {
	
	String key = null;
	Double beta = 0.0;
	Double minBeta = 0.0;
	
	public Map<String, Double> mapt13() {
		
		Map<String, Double> mapt13 = new HashMap<String, Double>();
		
		mapt13.put("bx", 0.0);
		mapt13.put("bo", -0.9493);
		mapt13.put("bk", -1.3525);
		mapt13.put("bg", 0.8241);
		mapt13.put("br", 0.0);
	
		return mapt13;
	}
	
	public Map<String, Double> mapc11() {
		
		Map<String, Double> mapc11 = new HashMap<String, Double>();

		Double[] betas = new Double[] { 1.8613, 0.6827, 0.1108, -0.4673, -0.752, -1.0232, -1.2449, -2.5241, -1.2892,
				-1.3312, -1.5922, 0.0 };

		for (int i = 0; i < betas.length; i++) {
			String name = "b" + i;
			Double value = betas[i];
			mapc11.put(name, value);
		}
		
		return mapc11;
	}
	
	public Map<String, Double> mapc3() {
		
		Map<String, Double> mapc3 = new HashMap<String, Double>();

		Double[] betas = new Double[] { -4.2021,	-3.0299, -2.2288, -1.7538, -1.1574, -0.8809,	-0.7598, 0.0 };

		for (int i = 0; i < betas.length; i++) {
			String name = "b" + i;
			Double value = betas[i];
			mapc3.put(name, value);
		}
		
		return mapc3;
	}
	
	public Map<String, Double> mapc9() {
		
		Map<String, Double> mapc9 = new HashMap<String, Double>();

		Double[] betas = new Double[] { -0.1807,	-0.2529, 0.4859, 	0.644,	0.8846, 1.1339, 1.2745,	0.7857, -0.1499, 0.4584, 0.1351, 0.0};

		for (int i = 0; i < betas.length; i++) {
			String name = "b" + i;
			Double value = betas[i];
			mapc9.put(name, value);
		}
		
		return mapc9;
	}
	
	public Map<String, Double> mapi19() {
		
		Map<String, Double> mapi19 = new HashMap<String, Double>();

		Double[] betas = new Double[] { -2.3813, -2.1266, -2.0, -1.6275, -1.4356, -1.2816, -1.2377, -0.5328, 0.0};

		for (int i = 0; i < betas.length; i++) {
			String name = "b" + i;
			Double value = betas[i];
			mapi19.put(name, value);
		}
		
		return mapi19;
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
