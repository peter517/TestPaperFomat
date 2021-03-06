package com.pengjun.tpf.rule;

public class AddTabRule extends BaseRule {

	@Override
	public String process(String srcStr) {

		char[] strArr = new char[srcStr.length() * 2];
		int k = 0;
		for (int i = 0; i < srcStr.length(); i++) {
			char c = srcStr.charAt(i);
			if ((c == 'B' || c == 'C' || c == 'D')
					&& (i != 0 && i != srcStr.length() - 1)
					&& srcStr.charAt(i + 1) == '.') {
				strArr[k++] = '#';
			}
			strArr[k++] = c;
		}
		return new String(strArr).trim();
	}
}
