package com.pengjun.tpf.rule;

public class AddBracketSpaceRule extends BaseRule {

	@Override
	public String process(String srcStr) {
		char[] strArr = new char[srcStr.length() * 2];
		int k = 0;
		for (int i = 0; i < srcStr.length(); i++) {
			char c = srcStr.charAt(i);
			if (i != srcStr.length() - 2 && c == '('
					&& srcStr.charAt(i + 2) == ')') {
				strArr[k++] = c;
				strArr[k++] = ' ';
			} else {
				strArr[k++] = c;
			}
		}
		return new String(strArr).trim();

	}

}
