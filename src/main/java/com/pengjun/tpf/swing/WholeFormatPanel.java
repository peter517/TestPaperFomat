package com.pengjun.tpf.swing;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	private final static String FORMAT_FAILED = "转化失败";
	private JFileChooser fcDoc = new JFileChooser();
	private JProgressBar pbFormat = new JProgressBar();
	private JButton btChooseFile = new JButton(CHOOSE_FILE);
	private JButton btStart = new JButton(CHOOSE_FILE);

	public WholeFormatPanel() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JScrollPane pFomat = new JScrollPane(pbFormat);

		this.add(pFomat);

		btStart.setEnabled(false);
		btStart.setText(START_FORMAT);
		btChooseFile.setText(CHOOSE_FILE);

		JPanel pStart = new JPanel();
		pStart.add(btChooseFile);
		pStart.add(btStart);
		this.add(pStart);

		this.btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final String filePath = pbFormat.getString();

				pbFormat.setIndeterminate(true);
				pbFormat.setStringPainted(true);
				pbFormat.setString("正在转化，请稍等……");
				btStart.setEnabled(false);

				new Thread(new Runnable() {

					@Override
					public void run() {

						String dstFilePath = null;
						try {
							dstFilePath = TestPaperTools
									.formatWholeDoc(filePath);
						} catch (FileNotFoundException e1) {
							pbFormat.setString(FORMAT_FAILED + ",请先关闭相关文件");
							pbFormat.setIndeterminate(false);
							e1.printStackTrace();
							return;

						}

						try {
							Desktop.getDesktop().open(new File(dstFilePath));
						} catch (IOException e) {
							e.printStackTrace();
						}

						pbFormat.setString(FORMAT_OK + ", 转化文件路径为 ：" + filePath);
						pbFormat.setIndeterminate(false);
						btStart.setEnabled(false);
					}
				}).start();
			}
		});

		this.btChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btChooseFile.getText().equals(CHOOSE_FILE)) {

					fcDoc.setCurrentDirectory(new File(choosePath));
					fcDoc.showOpenDialog(WholeFormatPanel.this);
					pbFormat.setString("");

					String filePath = fcDoc.getSelectedFile().getAbsolutePath();
					if (!filePath.equals("")) {
						pbFormat.setStringPainted(true);
						pbFormat.setString(filePath);
						choosePath = filePath;
						btStart.setEnabled(true);
					}
				}
			}
		});
	}

}
