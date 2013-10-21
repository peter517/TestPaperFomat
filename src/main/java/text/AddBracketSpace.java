package text;

public class AddBracketSpace extends Rule {

	@Override
	public String process(String srcStr) {
		char[] strArr = new char[srcStr.length() * 2];
		int k = 0;
		for (int i = 0; i < srcStr.length(); i++) {
			char c = srcStr.charAt(i);
			if (i != srcStr.length() - 1 && c == '(' && srcStr.charAt(i + 1) == ')') {
				strArr[k++] = c;
				strArr[k++] = '\t';
			} else {
				strArr[k++] = c;
			}
		}
		return new String(strArr).trim();

	}

}
