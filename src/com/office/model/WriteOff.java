/**
 * 冲销对象
 * @author zhaozhouhao
 *
 */

package com.office.model;

public class WriteOff {
	
	/**
	 * 清单ID
	 */
	private String id;
	
	/**
	 * 业务日期
	 */
	private String date;
	
	/**
	 * 采购订单号
	 */
	private String purchaseNum;
	
	/**
	 * 供应商名称
	 */
	private String supplierName;
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}



	/**
	 * 供应商编号
	 */
	private String supplierNum;
	
	
	/**
	 * 物料编码
	 */
	private String materielNum;
	
	/**
	 * 生产厂家
	 */
	private String manufacturer;
	
	/**
	 * 规格编号
	 */
	private String specificationNumber;
	
	/**
	 * 物料名称
	 */
	private String materielName;
	
	/**
	 * 物资服务编码
	 */
	private String materialServiceNum;
;
	
	/**
	 * 计量单位
	 */
	private String unit;
	
	/**
	 * 数量
	 */
	private String number;
	
	/**
	 * 不含税单价
	 */
	private String priceWithoutTax;
	
	/**
	 * 不含税总金额
	 */
	private String totalPriceWithoutTax;
	
	/**
	 * 含税总价
	 */
	private String totalPrice;
	
	/**
	 * 成本确认进度
	 */
	private String cost;
	
	/**
	 * 税金
	 */
	private String tax;
	
	/**
	 * 当期成本确认金额
	 */
	private String currentAmountOfCostConfirmation;
	
	/**
	 * 工程项目编码
	 */
	private String projectNum;
	
	/**
	 * 工程项目名称
	 */
	private String projectName;
	
	
	/**
	 * 站址编码
	 */
	private String siteNum;
	
	
	/**
	 * 站址名称
	 */
	private String siteName;
	
	
	/**
	 * 核算组织
	 */
	private String accountOrganization;
	
	
	/**
	 * 单据类别
	 */
	private String billType;
	
	/**
	 * 制单人
	 */
	private String billPerson;
	
	/**
	 * 是否装配
	 */
	private String isAssembling;
	
	/**
	 * 是否分摊
	 */
	private String isShare;
	
	/**
	 * 是否转资
	 */
	private String isARCD;
	
	/**
	 * 时间戳
	 */
	private String timeStamp;
	
	/**
	 * 科目编码
	 */
	private String subjectNum;
	
	/**
	 * 科目名称
	 */
	private String subjectName;
	
	/**
	 * 订单类型
	 */
	private String orderType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public String getSupplierNum() {
		return supplierNum;
	}

	public void setSupplierNum(String supplierNum) {
		this.supplierNum = supplierNum;
	}

	public String getMaterielNum() {
		return materielNum;
	}

	public void setMaterielNum(String materielNum) {
		this.materielNum = materielNum;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSpecificationNumber() {
		return specificationNumber;
	}

	public void setSpecificationNumber(String specificationNumber) {
		this.specificationNumber = specificationNumber;
	}

	public String getMaterielName() {
		return materielName;
	}

	public void setMaterielName(String materielName) {
		this.materielName = materielName;
	}

	public String getMaterialServiceNum() {
		return materialServiceNum;
	}

	public void setMaterialServiceNum(String materialServiceNum) {
		this.materialServiceNum = materialServiceNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPriceWithoutTax() {
		return priceWithoutTax;
	}

	public void setPriceWithoutTax(String priceWithoutTax) {
		this.priceWithoutTax = priceWithoutTax;
	}

	public String getTotalPriceWithoutTax() {
		return totalPriceWithoutTax;
	}

	public void setTotalPriceWithoutTax(String totalPriceWithoutTax) {
		this.totalPriceWithoutTax = totalPriceWithoutTax;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getCurrentAmountOfCostConfirmation() {
		return currentAmountOfCostConfirmation;
	}

	public void setCurrentAmountOfCostConfirmation(String currentAmountOfCostConfirmation) {
		this.currentAmountOfCostConfirmation = currentAmountOfCostConfirmation;
	}

	public String getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(String projectNum) {
		this.projectNum = projectNum;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(String siteNum) {
		this.siteNum = siteNum;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAccountOrganization() {
		return accountOrganization;
	}

	public void setAccountOrganization(String accountOrganization) {
		this.accountOrganization = accountOrganization;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getBillPerson() {
		return billPerson;
	}

	public void setBillPerson(String billPerson) {
		this.billPerson = billPerson;
	}

	public String getIsAssembling() {
		return isAssembling;
	}

	public void setIsAssembling(String isAssembling) {
		this.isAssembling = isAssembling;
	}

	public String getIsShare() {
		return isShare;
	}

	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}

	public String getIsARCD() {
		return isARCD;
	}

	public void setIsARCD(String isARCD) {
		this.isARCD = isARCD;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getSubjectNum() {
		return subjectNum;
	}

	public void setSubjectNum(String subjectNum) {
		this.subjectNum = subjectNum;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	
	/**
	 * 数组转对象
	 * @param data
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static WriteOff stringsToWriteOff(String[] data) throws Exception{
		WriteOff writeOff=new WriteOff();
		writeOff.setId(data[0]);
		writeOff.setDate(data[1]);
		writeOff.setPurchaseNum(data[2]);
		writeOff.setSupplierName(data[3]);
		writeOff.setSupplierNum(data[4]);
		writeOff.setMaterielNum(data[5]);
		writeOff.setManufacturer(data[6]);
		writeOff.setSpecificationNumber(data[7]);
		writeOff.setMaterielName(data[8]);
		writeOff.setMaterialServiceNum(data[9]);
		writeOff.setUnit(data[10]);
		writeOff.setNumber(data[11]);
		writeOff.setPriceWithoutTax(data[12]);
		writeOff.setTotalPriceWithoutTax(data[13]);
		writeOff.setTotalPrice(data[14]);
		writeOff.setCost(data[15]);
		writeOff.setTax(data[16]);
		writeOff.setCurrentAmountOfCostConfirmation(data[17]);
		writeOff.setProjectNum(data[18]);
		writeOff.setProjectName(data[19]);
		writeOff.setSiteNum(data[20]);
		writeOff.setSiteName(data[21]);
		writeOff.setAccountOrganization(data[22]);
		writeOff.setBillType(data[23]);
		writeOff.setBillPerson(data[24]);
		writeOff.setIsAssembling(data[25]);
		writeOff.setIsShare(data[26]);
		writeOff.setIsARCD(data[27]);
		writeOff.setTimeStamp(data[28]);
		writeOff.setSubjectNum(data[29]);
		writeOff.setSubjectName(data[30]);
		writeOff.setOrderType(data[31]);
		
		
		
		return writeOff;
	}
}
