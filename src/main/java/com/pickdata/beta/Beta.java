package com.pickdata.beta;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Beta {

	String key = null;
	Double beta = 0.0;
	Double minBeta = 0.0;

	public Map<String, Double> mapPutter(Double[] betas) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = 0; i < betas.length; i++) {
			String name = i+"";
			Double value = betas[i];
			map.put(name, value);
		}
		return map;
	}
	public Map<String, Double> mapPutter(Double[] betas, int initialValue, int columnPlusValue) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = initialValue; i < betas.length; i++) {
			String name = i+columnPlusValue+"";
			Double value = betas[i];
			map.put(name, value);
		}
		return map;
	}
	public Map<String, Double> mapPutter(Double[] betas, int initialValue, String logisticName) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (int i = initialValue; i < betas.length; i++) {
			String name = i+logisticName+"";
			Double value = betas[i];
			map.put(name, value);
		}
		return map;
	}
	public Map<String, Double> map(String columnName) {
		Map<String, Double> returnMap = new HashMap<String, Double>();
		Map<String, Double> mapT13 = new HashMap<String, Double>();
//		Double[] betasT13 = new Double[] { 1.8613, 0.6827, 0.1108, -0.4673, -0.752, -1.0232, -1.2449, -2.5241, -1.2892,
//				-1.3312, -1.5922, 0.0 };
		mapT13.put("X", 0.0);
		mapT13.put("O", -0.9493);
		mapT13.put("K", -1.3525);
		mapT13.put("G", 0.8241);
		mapT13.put("R", 0.0);

		// C11 범주값 0 ~ 11 증가값(+1)
		Map<String, Double> mapC11 = new HashMap<String, Double>();
		Double[] betasC11 = new Double[] { 1.8613, 0.6827, 0.1108, -0.4673, -0.752, -1.0232, -1.2449, -2.5241, -1.2892,	-1.3312, -1.5922, 0.0 };
		mapC11 = mapPutter(betasC11);
		
		// C3 범주값 0 ~ 7 증가값(+1)
		Map<String, Double> mapC3 = new HashMap<String, Double>();
		Double[] betasC3 = new Double[] { -4.2021, -3.0299, -2.2288, -1.7538, -1.1574, -0.8809, -0.7598, 0.0 };
		mapC3 = mapPutter(betasC3);

		// C9  범주값 0, 1 ~ 121 증가값(+12) 
		Map<String, Double> mapC9 = new HashMap<String, Double>();
		Double[] betasC9 = new Double[] { -0.1807, -0.2529, 0.4859, 0.644, 0.8846, 1.1339, 1.2745, 0.7857, -0.1499,	0.4584, 0.1351, 0.0 };
		// method overloading
		mapC9 = mapPutter(betasC9,1,12);
		mapC9.put("0", betasC9[0]);
		
		// I19 범주값 0,10미만,20미만,30미만,40미만,50미만,60미만,70미만,80미만,90미만,90이상
		Map<String, Double> mapI19 = new HashMap<String, Double>();
		Double[] betasI19 = new Double[] { -2.3813, -2.1266, -2.0, -1.6275, -1.4356, -1.2816, -1.2377, -0.5328, 0.0 };
		// method overloading
		mapI19 = mapPutter(betasI19,1,"0미만");
//		mapI19.put("90이상", betasI19[betasI19.length]);
		mapI19.put("90이상", betasI19[8]);
		mapI19.put("0", betasI19[0]);
		
		if(columnName.equals("t13")||columnName.equals("T13")){
			returnMap = mapT13;
		} else if(columnName.equals("c11")||columnName.equals("C11")){
			returnMap = mapC11;
		} else if(columnName.equals("c3")||columnName.equals("C3")){
			returnMap = mapC3;
		} else if(columnName.equals("c9")||columnName.equals("C9")){
			returnMap = mapC9;
		} else if(columnName.equals("i19")||columnName.equals("I19")){
			returnMap = mapI19;
		}
		return returnMap; 
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