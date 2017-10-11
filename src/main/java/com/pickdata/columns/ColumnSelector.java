package com.pickdata.columns;

import java.util.ArrayList;
import java.util.List;

public class ColumnSelector {
	public List<String> categoryData = new ArrayList<String>();
	public List<String> numericData = new ArrayList<String>();
	public ColumnSelector(){
		// 범주형
		categoryData.add("c1");
		categoryData.add("c2");
		
		// 수치형
		numericData.add("c5");
		
	}

}
