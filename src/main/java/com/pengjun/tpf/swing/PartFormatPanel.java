package com.pengjun.tpf.swing;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.pengjun.tpf.tools.TestPaperTools;

public class PartFormatPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextArea taContent = new JTextArea(30, 10);
	private JButton btStart = new JButton("开始转换");

	public PartFormatPanel() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JScrollPane spTextArea = new JScrollPane(taContent);
		this.add(spTextArea);

		JPanel pStart = new JPanel();
		pStart.add(btStart);
		this.add(pStart);

		this.btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] contentArr = getTextStr().split("\n");
				List<String> strList = new ArrayList<String>();
				for (String str : contentArr) {
					strList.add(TestPaperTools.formatSingleLine(str));
				}
				StringBuffer sb = new StringBuffer();
				for (String str : strList) {
					sb.append(str);
					sb.append("\n");
				}

				setTextStr(sb.toString());
			}
		});
	}

	public String getTextStr() {
		return taContent.getText();
	}

	public void setTextStr(String str) {
		taContent.setText(str);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
