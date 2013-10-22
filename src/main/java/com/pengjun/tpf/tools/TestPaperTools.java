package com.pengjun.tpf.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.pengjun.tpf.rule.AddBracketSpaceRule;
import com.pengjun.tpf.rule.AddTabRule;
import com.pengjun.tpf.rule.BaseRule;
import com.pengjun.tpf.rule.DeleteAllSpaceAndTabRule;
import com.pengjun.utils.FileUtils;
import com.pengjun.utils.POIUtils;

public class TestPaperTools {

	private static List<BaseRule> ruleList = new ArrayList<BaseRule>();
	static {
		ruleList.add(new DeleteAllSpaceAndTabRule());
		ruleList.add(new AddTabRule());
		ruleList.add(new AddBracketSpaceRule());
	}

	public static String formatSingleLine(String str) {

		for (BaseRule rule : ruleList) {
			str = rule.process(str);
		}

		return str;
	}

	public static String formatWholeDoc(String filePath)
			throws FileNotFoundException {

		List<String> strList = POIUtils.readWordDocx(filePath);

		List<String> resultList = new ArrayList<String>();
		for (String str : strList) {
			String tempStr = new DeleteAllSpaceAndTabRule().process(str);
			if ((tempStr.contains("A.") && tempStr.contains("B.") && tempStr
					.contains("C."))) {
				for (BaseRule rule : ruleList) {
					str = rule.process(str);
				}
			}
			resultList.add(str);

		}

		File file = new File(filePath);
		String dstPath = file.getParent() + File.separator
				+ FileUtils.getFileNameNoEx(file.getName()) + "_format."
				+ FileUtils.getExtensionName(file.getName());

		POIUtils.writeWordDocx(dstPath, resultList);

		return dstPath;
	}
}
