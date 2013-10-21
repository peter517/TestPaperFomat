package text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// BigDecimal big = new BigDecimal(700000000000000000.000f);
		// big.setScale(10, 2);
		// System.out.println(big);
		// System.out.println(big.setScale(8, 2));
		// System.out.println(big.setScale(9, 2));
		// System.out.println(big.setScale(12, BigDecimal.ROUND_CEILING));
		//
		// DecimalFormat df = new DecimalFormat("#,##0.00");
		// Double d = 700000000000000000.0;
		// df.format(d);
		// System.out.println(String.format("%.1f", d));

		// String str = "language 		 Specification"; // 要去空格的字符串
		// String str2 = ""; // 去空格后的字符串
		// str.replace(" ", "");
		// System.out.println(str);
		// str.replace("\t", "");
		// System.out.println(str);
		//
		// char[] strArr = new char[str.length()];
		// int k = 0;
		// for (int i = 0; i < str.length(); i++) {
		// char c = str.charAt(i);
		// if (c == ' ' || c == '\t') {
		// continue;
		// }
		// strArr[k++] = c;
		// }

		try {
			File f = new File("test.txt");
			InputStreamReader read = new InputStreamReader(new FileInputStream(f), "gbk");
			BufferedReader br = new BufferedReader(read);
			FileWriter fw = new FileWriter("result.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);

			String s1 = null;
			List<Rule> ruleList = new ArrayList<Rule>();
			ruleList.add(new DeleteAllSpaceAndTab());
			ruleList.add(new AddTabRule());
			ruleList.add(new AddBracketSpace());

			while ((s1 = br.readLine()) != null) {

				for (Rule rule : ruleList) {
					s1 = rule.process(s1);
				}
				System.out.println(s1);
				bw.write(s1);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			fw.close();
			br.close();
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
