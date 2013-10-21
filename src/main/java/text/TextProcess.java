package text;

import java.util.ArrayList;
import java.util.List;

public class TextProcess {

	private static List<Rule> ruleList = new ArrayList<Rule>();
	static {
		ruleList.add(new DeleteAllSpaceAndTab());
		ruleList.add(new AddTabRule());
		ruleList.add(new AddBracketSpace());
	}

	public static String formatSingleLine(String str) {

		str.trim();
		for (Rule rule : ruleList) {
			str = rule.process(str);
		}

		return str;
	}
}
