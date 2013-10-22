package com.pengjun.tpf.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.pengjun.utils.SwingUtils;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {

		JTabbedPane jp = new JTabbedPane();
		jp.addTab("片段转化", null, new PartFormatPanel(), "片段转化");
		jp.addTab("文档转化", null, new WholeFormatPanel(), "文档转化");
		this.add(jp, BorderLayout.CENTER);

	}

	public static void main(String[] args) {

		MainFrame frame = new MainFrame();

		SwingUtils.createFrame(frame, 800, 600);
		SwingUtils.setFrameCenter(frame);

	}

}
