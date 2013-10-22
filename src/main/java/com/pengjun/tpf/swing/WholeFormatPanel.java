package com.pengjun.tpf.swing;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileSystemView;

import com.pengjun.tpf.tools.TestPaperTools;

public class WholeFormatPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String choosePath = FileSystemView.getFileSystemView()
			.getHomeDirectory().getAbsolutePath();
	private final static String CHOOSE_FILE = "选择文件";
	private final static String START_FORMAT = "开始转化";
	private final static String FORMAT_OK = "转化成功";
	private JFileChooser fcDoc = new JFileChooser();
	private JProgressBar pbFormat = new JProgressBar();
	private JButton btStart = new JButton(CHOOSE_FILE);

	public WholeFormatPanel() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		pbFormat.setBounds(20, 20, 500, 500);
		JScrollPane pFomat = new JScrollPane(pbFormat);

		this.add(pFomat);

		JPanel pStart = new JPanel();
		pStart.add(btStart);
		this.add(pStart);

		this.btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btStart.getText().equals(CHOOSE_FILE)) {

					fcDoc.setCurrentDirectory(new File(choosePath));
					fcDoc.showOpenDialog(WholeFormatPanel.this);

					String filePath = fcDoc.getSelectedFile().getAbsolutePath();
					if (!filePath.equals("") || !filePath.startsWith(FORMAT_OK)) {
						pbFormat.setStringPainted(true);
						pbFormat.setString(filePath);
						choosePath = filePath;
						btStart.setText(START_FORMAT);
					} else {
						btStart.setText(CHOOSE_FILE);
					}
				} else if (btStart.getText().equals(START_FORMAT)) {

					final String filePath = pbFormat.getString();
					btStart.setText(CHOOSE_FILE);
					pbFormat.setIndeterminate(true);
					pbFormat.setStringPainted(true);
					pbFormat.setString("正在转化，请稍等……");
					new Thread(new Runnable() {

						@Override
						public void run() {
							pbFormat.setString(FORMAT_OK + ", 转化文件路径为 ："
									+ TestPaperTools.formatWholeDoc(filePath));
							pbFormat.setIndeterminate(false);
						}
					}).start();

				}

			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
