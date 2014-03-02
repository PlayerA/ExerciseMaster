package com.fei.exercicemaster.util;

import java.util.Arrays;
import java.util.List;

public class MyStringUtil {
	private static final String SPILCT = "|";

	public static String combineNum(List<String> numList) {
		StringBuilder sb = new StringBuilder();
		if (numList != null && numList.size() > 0) {
			for (int i = 0; i < numList.size(); i++) {
				if (i == numList.size() - 1) {
					sb.append(numList.get(i));
				} else {
					sb.append(numList.get(i)).append(SPILCT);
				}
			}
			return sb.toString();
		} else {
			return "";
		}
	}
	
	public static List<String> devideNum(String numStr) {
		return Arrays.asList(numStr.split("\\" + SPILCT));
	}
	
	public static String devideNumToStr(String srcStr,String newSplit) {
		return	srcStr.replace(SPILCT, newSplit);
	}
}
