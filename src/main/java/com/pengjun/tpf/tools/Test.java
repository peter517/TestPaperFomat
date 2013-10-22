package com.pengjun.tpf.tools;

import java.io.File;
import java.io.IOException;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "d://test1.docx";
		System.out.println(new File(str).getParent());
		try {
			System.out.println(new File(str).getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		// try {
		// File f = new File("test.txt");
		// InputStreamReader read = new InputStreamReader(new
		// FileInputStream(f), "gbk");
		// BufferedReader br = new BufferedReader(read);
		// FileWriter fw = new FileWriter("result.txt", false);
		// BufferedWriter bw = new BufferedWriter(fw);
		//
		// String s1 = null;
		// List<Rule> ruleList = new ArrayList<Rule>();
		// ruleList.add(new DeleteAllSpaceAndTab());
		// ruleList.add(new AddTabRule());
		// ruleList.add(new AddBracketSpace());
		//
		// while ((s1 = br.readLine()) != null) {
		//
		// for (Rule rule : ruleList) {
		// s1 = rule.process(s1);
		// }
		// System.out.println(s1);
		// bw.write(s1);
		// bw.newLine();
		// bw.flush();
		// }
		// bw.close();
		// fw.close();
		// br.close();
		// read.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// String str = "A.asdfaB.adfC.asdg";
		// System.out.println(str.contains("A."));
		// System.out.println(str.contains("B."));
		// System.out.println(str.contains("C."));
		// List<String> strList = POIUtils.readWordDocx("d://test.docx");
		//
		// List<Rule> ruleList = new ArrayList<Rule>();
		// ruleList.add(new DeleteAllSpaceAndTabRule());
		// ruleList.add(new AddTabRule());
		// ruleList.add(new AddBracketSpaceRule());
		//
		// List<String> resultList = new ArrayList<String>();
		// for (String str : strList) {
		// String tempStr = new DeleteAllSpaceAndTabRule().process(str);
		// if ((tempStr.contains("A.") && tempStr.contains("B.") && tempStr
		// .contains("C."))) {
		// for (Rule rule : ruleList) {
		// str = rule.process(str);
		// }
		// }
		// resultList.add(str);
		//
		// }
		//
		// POIUtils.writeWordDocx("d://test1.docx", resultList);

	}
}
