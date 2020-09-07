package cn.second_hand.product.domain;

import java.util.Date;

public class Product {
	private String name;
	private String categories;
	private double price;
	private String description;
	private String picture1;
	private String picture2;
	private boolean bargainStatus;
	private String applierEmail;
	private boolean applierStatus;
	private String remark;
	private Date applyTime;
	private Date auditTime;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", categories=" + categories + ", price=" + price + ", description="
				+ description + ", picture1=" + picture1 + ", picture2=" + picture2 + ", bargainStatus=" + bargainStatus
				+ ", applierEmail=" + applierEmail + ", applierStatus=" + applierStatus + ", remark=" + remark
				+ ", applyTime=" + applyTime + ", auditTime=" + auditTime + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture1() {
		return picture1;
	}
	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}
	public String getPicture2() {
		return picture2;
	}
	public void setPicture2(String picture2) {
		this.picture2 = picture2;
	}
	public boolean isBargainStatus() {
		return bargainStatus;
	}
	public void setBargainStatus(boolean bargainStatus) {
		this.bargainStatus = bargainStatus;
	}
	public String getApplierEmail() {
		return applierEmail;
	}
	public void setApplierEmail(String applierEmail) {
		this.applierEmail = applierEmail;
	}
	public boolean isApplierStatus() {
		return applierStatus;
	}
	public void setApplierStatus(boolean applierStatus) {
		this.applierStatus = applierStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

}
