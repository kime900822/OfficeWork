package com.office.windows.writeoff;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.xml.sax.SAXException;

import com.office.utils.BigExcelReader;
import com.office.utils.ExcelUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WriteOff extends JPanel {

	private File file;
	private List<com.office.model.WriteOff> lWriteOff;
	private List<com.office.model.WriteOff> outLWriteOff;
	
	
	/**
	 * Create the panel.
	 */
	public WriteOff() {
		setLayout(new BorderLayout(0, 0));
		
		JProgressBar progressBar = new JProgressBar();
		add(progressBar,BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		add(panel,BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnExecute = new JButton("执行");
		btnExecute.setEnabled(false);
		
		
		btnExecute.setBounds(327, 2, 117, 29);
		panel.add(btnExecute);
		
		JLabel lblSvae = new JLabel("保存地址:");
		lblSvae.setBounds(8, 35, 313, 16);
		panel.add(lblSvae);
		
		JTextPane textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBounds(8, 63, 436, 191);
		panel.add(textPane);
		
		JButton btnClose = new JButton("关闭");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClose.setBounds(327, 30, 117, 29);
		panel.add(btnClose);
		
		JLabel lblFile = new JLabel("点击选择文件导入:");
		lblFile.setBounds(8, 7, 313, 16);
		panel.add(lblFile);
		
		lblFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//文件删选
				JFileChooser jFileChooser=new JFileChooser();
				//去除所有文件删选
				jFileChooser.setAcceptAllFileFilterUsed(false); 
				//增加excel格式删选
				FileNameExtensionFilter filter = new FileNameExtensionFilter("excel(*.xls)","xls");
				FileNameExtensionFilter filter1 = new FileNameExtensionFilter("excel(*.xlsx)","xlsx");
				jFileChooser.addChoosableFileFilter(filter);
				jFileChooser.addChoosableFileFilter(filter1);
				
				int i = jFileChooser.showOpenDialog(null);
				 if(i== jFileChooser.APPROVE_OPTION){ //打开文件
                     String path = jFileChooser.getSelectedFile().getAbsolutePath();
                     String name = jFileChooser.getSelectedFile().getName();
                     file=jFileChooser.getSelectedFile();
                     lblFile.setText("当前文件路径："+path+";\n当前文件名："+name);
                     textPane.setText("开始导入文件："+path);
						
                     
 
                     lWriteOff=new ArrayList<>();
             
                     
                     new Thread(new Runnable() {
						
						@Override
						public void run() {
							try {
								try {							
									BigExcelReader reader;
									reader = new BigExcelReader(path) {  
									     @Override  
									     protected void outputRow(String[] datas, int[] rowTypes, int rowIndex) {  
									        try {
												com.office.model.WriteOff writeOff=com.office.model.WriteOff.stringsToWriteOff(datas);
												lWriteOff.add(writeOff);
							                    SwingUtilities.invokeLater(new Runnable(){
							                        @Override
							                        public void run() {
							                        	textPane.setText("正在导入第"+ rowIndex+"笔资料");
							                        }
							                    });
											} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
									     }  
									 };
									 // 执行解析  
				                     reader.parse();  
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (OpenXML4JException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (SAXException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
			                    SwingUtilities.invokeLater(new Runnable(){
			                        @Override
			                        public void run() {
			                        	textPane.setText("一共导入："+lWriteOff.size()+"笔资料");
			                        	btnExecute.setEnabled(true);
			                        }
			                    });							
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null,e.getMessage());
							}
							
						}
					}).start();
                     
                 }else{
                	 lblFile.setText("未选择文件");
                 }
			}
		});

		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//文件删选
				JFileChooser jFileChooser=new JFileChooser();
				//去除所有文件删选
				jFileChooser.setAcceptAllFileFilterUsed(false); 
				//增加excel格式删选
				FileNameExtensionFilter filter = new FileNameExtensionFilter("excel(*.xls)","xls");
				FileNameExtensionFilter filter1 = new FileNameExtensionFilter("excel(*.xlsx)","xlsx");
				jFileChooser.addChoosableFileFilter(filter);
				jFileChooser.addChoosableFileFilter(filter1);
				
				int i = jFileChooser.showSaveDialog(null);
				if(i== jFileChooser.APPROVE_OPTION){ //打开文件
                    String path = jFileChooser.getSelectedFile().getAbsolutePath();
                    String name = jFileChooser.getSelectedFile().getName();
                    file=jFileChooser.getSelectedFile();
                    lblFile.setText("当前文件路径："+path+";\n当前文件名："+name);
                    
                    outLWriteOff=new ArrayList<>();
                    textPane.setText("开始处理...");
                    
                    new Thread(new Runnable() {
						
						@Override
						public void run() {
							try {
							outLWriteOff=Execute(lWriteOff);
							
				            //第一步，创建一个webbook，对应一个Excel文件
							XSSFWorkbook wb = new XSSFWorkbook();
				            //第二步，在webbook中添加一个sheet，对应Excel文件中的 sheet
				            XSSFSheet sheet = wb.createSheet("用户信息");
				            //第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数有限制
				            XSSFRow row = sheet.createRow(0);

				            //第五步，创建表头单元格，并设置样式
				            XSSFCell cell;

				            cell = row.createCell(0);
				            cell.setCellValue("清单ID");
				            cell = row.createCell(1);
				            cell.setCellValue("业务日期");
				            cell = row.createCell(2);
				            cell.setCellValue("采购订单号");
				            cell = row.createCell(3);
				            cell.setCellValue("供应商名称");
				            cell = row.createCell(4);
				            cell.setCellValue("供应商编号");
				            cell = row.createCell(5);
				            cell.setCellValue("物料编码");
				            cell = row.createCell(6);
				            cell.setCellValue("生产厂家");
				            cell = row.createCell(7);
				            cell.setCellValue("规格编号");
				            cell = row.createCell(8);
				            cell.setCellValue("物料名称");
				            cell = row.createCell(9);
				            cell.setCellValue("物资服务编码");
				            cell = row.createCell(10);
				            cell.setCellValue("计量单位");
				            cell = row.createCell(11);
				            cell.setCellValue("数量");
				            cell = row.createCell(12);
				            cell.setCellValue("不含税单价");
				            cell = row.createCell(13);
				            cell.setCellValue("不含税总金额");
				            cell = row.createCell(14);
				            cell.setCellValue("含税总价");
				            cell = row.createCell(15);
				            cell.setCellValue("成本确认进度（%）");
				            cell = row.createCell(16);
				            cell.setCellValue("税金");
				            cell = row.createCell(17);
				            cell.setCellValue("当期成本确认金额");
				            cell = row.createCell(18);
				            cell.setCellValue("工程项目编码");
				            cell = row.createCell(19);
				            cell.setCellValue("工程项目名称");
				            cell = row.createCell(20);
				            cell.setCellValue("站址编码");
				            cell = row.createCell(21);
				            cell.setCellValue("站址名称");
				            cell = row.createCell(22);
				            cell.setCellValue("核算组织");
				            cell = row.createCell(23);
				            cell.setCellValue("单据类别");
				            cell = row.createCell(24);
				            cell.setCellValue("制单人");
				            cell = row.createCell(25);
				            cell.setCellValue("是否装配");
				            cell = row.createCell(26);
				            cell.setCellValue("是否分摊");
				            cell = row.createCell(27);
				            cell.setCellValue("是否转资");
				            cell = row.createCell(28);
				            cell.setCellValue("时间戳");
				            cell = row.createCell(29);
				            cell.setCellValue("科目编号");
				            cell = row.createCell(30);
				            cell.setCellValue("科目名称");
				            cell = row.createCell(31);
				            cell.setCellValue("订单类型");
				            
				            for (int j = 0; j < 32; j++) {
				            	sheet.setColumnWidth(i,3000);
				            }
				            int i=0;
				            for (com.office.model.WriteOff w : outLWriteOff) {
				            	i++;
				            	row = sheet.createRow(i);
				            	row.createCell(0).setCellValue(w.getId());
				            	row.createCell(1).setCellValue(w.getDate());
				            	row.createCell(2).setCellValue(w.getPurchaseNum());
				            	row.createCell(3).setCellValue(w.getSupplierName());
				            	row.createCell(4).setCellValue(w.getSupplierNum());
				            	row.createCell(5).setCellValue(w.getMaterielNum());
				            	row.createCell(6).setCellValue(w.getManufacturer());
				            	row.createCell(7).setCellValue(w.getSpecificationNumber());
				            	row.createCell(8).setCellValue(w.getMaterielName());
				            	row.createCell(9).setCellValue(w.getMaterialServiceNum());
				            	row.createCell(10).setCellValue(w.getUnit());
				            	row.createCell(11).setCellValue(w.getNumber());
				            	row.createCell(12).setCellValue(w.getPriceWithoutTax());
				            	row.createCell(13).setCellValue(w.getTotalPriceWithoutTax());
				            	row.createCell(14).setCellValue(w.getTotalPrice());
				            	row.createCell(15).setCellValue(w.getCost());
				            	row.createCell(16).setCellValue(w.getTax());
				            	row.createCell(17).setCellValue(w.getCurrentAmountOfCostConfirmation());
				            	row.createCell(18).setCellValue(w.getProjectNum());
				            	row.createCell(19).setCellValue(w.getProjectName());
				            	row.createCell(20).setCellValue(w.getSiteNum());
				            	row.createCell(21).setCellValue(w.getSiteName());
				            	row.createCell(22).setCellValue(w.getAccountOrganization());
				            	row.createCell(23).setCellValue(w.getBillType());
				            	row.createCell(24).setCellValue(w.getBillPerson());
				            	row.createCell(25).setCellValue(w.getIsAssembling());
				            	row.createCell(26).setCellValue(w.getIsShare());
				            	row.createCell(27).setCellValue(w.getIsARCD());
				            	row.createCell(28).setCellValue(w.getTimeStamp());
				            	row.createCell(29).setCellValue(w.getSubjectNum());
				            	row.createCell(30).setCellValue(w.getSubjectName());
				            	row.createCell(31).setCellValue(w.getOrderType());
				            	
							}
							
				            
				            
								OutputStream out = new FileOutputStream(path);
								wb.write(out);						 
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
			                    SwingUtilities.invokeLater(new Runnable(){
			                        @Override
			                        public void run() {
			                        	textPane.setText("异常："+e.getMessage());
			                        }
			                    });
							} 
							
							SwingUtilities.invokeLater(new Runnable(){
		                        @Override
		                        public void run() {
		                        	textPane.setText("导出成功！");
		                        }
		                    });
						}
					}).start();
                    
                    
                }else{
               	 lblFile.setText("未选择文件");
                }
			}
		});

		

	}
	
	public static List Execute(List<com.office.model.WriteOff> list){

		List out=new ArrayList<>();	
		for (int i = 1; i < list.size(); i++) {
			boolean flag=false;
				for (int j = 1; j < list.size(); j++) {
					if (check(list.get(i),list.get(j))) {
						flag=true;
						break;
					}									
				}
			if (!flag) {
				out.add(list.get(i));
			}
			System.out.println(i);
		}
		
		
		return out;
	}
	
	public static boolean check(com.office.model.WriteOff writeOff1,com.office.model.WriteOff writeOff2){
		if (writeOff1.getPurchaseNum().equals(writeOff2.getPurchaseNum())
				&&writeOff1.getSupplierNum().equals(writeOff2.getSupplierNum())
				&&writeOff1.getMaterielNum().equals(writeOff2.getMaterielNum())
				&&writeOff1.getProjectNum().equals(writeOff2.getProjectNum())
				&&writeOff1.getProjectName().equals(writeOff2.getProjectName())
				&&writeOff1.getSiteNum().equals(writeOff2.getSiteNum())
				&&writeOff1.getSiteName().equals(writeOff2.getSiteName())
				&&writeOff1.getAccountOrganization().equals(writeOff2.getAccountOrganization())
				&&writeOff1.getBillType().equals(writeOff2.getBillType())
				&&writeOff1.getSubjectName().equals(writeOff2.getSubjectName())) {
			
			double num1;
			double num2;
			if (writeOff1.getNumber()!=null&&!"".equals(writeOff1.getNumber())) {
				num1=Double.parseDouble(writeOff1.getNumber());
			}else{
				num1=0;
			}
			if (writeOff2.getNumber()!=null&&!"".equals(writeOff2.getNumber())) {
				num2=Double.parseDouble(writeOff2.getNumber())*-1;
			}else{
				num2=0;
			}
			
			double amount1=Double.parseDouble(writeOff1.getTotalPriceWithoutTax())*-1;
			double amount2=Double.parseDouble(writeOff2.getTotalPriceWithoutTax());
			
			
			if (num1==num2&&amount1==amount2) {
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		

	}
	 
}