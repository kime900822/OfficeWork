package com.office.windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.office.windows.writeoff.WriteOff;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("办公小程序");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("成本单冲销");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open("成本单冲销", null, new WriteOff(), "", false, tabbedPane);
			}
		});
		menuBar.add(mnNewMenu);
	}
	
	
    /**
    * 打开某个界面
    * @param title标题
    * @param icon图片
    * @param panel
    * @param tip提示
    * @param b是否创建一个新的界面,如果为ture的话，表示panel无论在tabbedPanel是否已经存在都将创建一个新的界面
    */
   public static void open(String title, Icon icon, Object panel, String tip,boolean b,JTabbedPane tabbedPane) {
       if (!b) {
//tabbedPane.getTabCount():获取tabbedPane上标签数
           for (int i = 0, n = tabbedPane.getTabCount(); i < n; i++) {
               if (tabbedPane.getComponentAt(i).getClass().equals(
                       panel.getClass())) {
//tabbedPane.setSelectedIndex(i):设置第i个位当前激活界面
                   tabbedPane.setSelectedIndex(i);
                   tabbedPane.setEnabledAt(i, true);
                   return;
               }
           }
       }
       if (panel instanceof JPanel) {
           //tabbedPane.addTab(title, icon, (JPanel) panel, tip):添加一个panel
           tabbedPane.addTab(title, icon, (JPanel) panel, tip);
           tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
           tabbedPane.setEnabledAt(tabbedPane.getTabCount() - 1, true);
       } else {
    	   JOptionPane.showMessageDialog(null, "非法参数:" + panel.getClass()); 
       }
   }
}
