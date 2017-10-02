package com.example.pickdata;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;


public class BigContestParser {

	public Map<Object, Object> map = new HashMap<Object, Object>();

	// parsing 작업
	public BigContestParser(Text text) {
//	public BigContestParser(String text) {
		
		String[] columns = text.toString().split(",");

		// id, y
		map.put("id", columns[0]);
		map.put("y", columns[1]);

		// c1~c14
		for (int i = 1; i < 15; i++) {
			map.put("c" + i, columns[i + 1]);
		}

		// i1 ~ i36
		// i1
		map.put("i1", columns[16]);
		// i2 ~ i6
		for (int i = 2; i < 7; i++) {
			map.put("i" + i, columns[i + 15]);
		}
		map.put("i7", columns[22]);
		// i8 ~ i18
		for (int i = 8; i < 19; i++) {
			map.put("i" + i, columns[i + 15]);
		}
		if ("0".equals(columns[34])) {
			map.put("i19", "0");
		} else if ("10미만".equals(columns[34])) {
			map.put("i19", "9");
		} else if ("20미만".equals(columns[34])) {
			map.put("i19", "19");
		} else if ("30미만".equals(columns[34])) {
			map.put("i19", "29");
		} else if ("40미만".equals(columns[34])) {
			map.put("i19", "39");
		} else if ("50미만".equals(columns[34]) ){
			map.put("i19", "49");
		} else if ("60미만".equals(columns[34])) {
			map.put("i19", "59");
		} else if ("70미만".equals(columns[34])) {
			map.put("i19", "69");
		} else if ("80미만".equals(columns[34])) {
			map.put("i19", "79");
		} else if ("90미만".equals(columns[34])) {
			map.put("i19", "89");
		} else if ("90이상".equals(columns[34])) {
			map.put("i19", "99");
		}
		// i8 ~ i18
		for (int i = 20; i < 37; i++) {
			map.put("i" + i, Double.parseDouble(columns[i + 15]));
		}

		map.put("age", columns[52]);
		map.put("sex", columns[53]);

		// t1 ~ t2
		for (int i = 1; i < 3; i++) {
			map.put("t" + i, columns[i + 53]);
		}
		map.put("t3", columns[56]);
		// t4 ~ t5
		for (int i = 4; i < 6; i++) {
			map.put("t" + i, columns[i + 53]);
		}
		map.put("t6", columns[59]);
		// t7 ~ t12
		for (int i = 7; i < 13; i++) {
			map.put("t" + i, columns[i + 53]);
		}
		for (int i = 13; i < 15; i++) {
			map.put("t" + i, columns[i + 53]);
			map.put("t15", columns[68]);
		}
	}
}