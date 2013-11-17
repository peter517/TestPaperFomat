package com.pengjun.tpf.rule;

public class DeleteAllSpaceAndTabRule extends BaseRule {

	@Override
	public String process(String srcStr) {
		char[] strArr = new char[srcStr.length()];
		int k = 0;

		for (int i = 0; i < srcStr.length(); i++) {
			char c = srcStr.charAt(i);
			if (c == '\t' || c == '#') {
				continue;
			}
			if ((c == ' ') && (i != 0 && i != srcStr.length() - 1)
					&& srcStr.charAt(i + 1) == ' ') {
				continue;
			}
			strArr[k++] = c;
		}

		return new String(strArr);
	}

}
