package text;

public class DeleteAllSpaceAndTab extends Rule {

	@Override
	public String process(String srcStr) {
		char[] strArr = new char[srcStr.length()];
		int k = 0;
		for (int i = 0; i < srcStr.length(); i++) {
			char c = srcStr.charAt(i);
			if (c == ' ' || c == '\t') {
				continue;
			}
			strArr[k++] = c;
		}

		return new String(strArr);
	}

}
