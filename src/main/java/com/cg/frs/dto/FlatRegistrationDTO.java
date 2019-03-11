package com.cg.frs.dto;

public class FlatRegistrationDTO {
          private int ownerid;
          private String ownerName;
          private String mobile;
          
          private long flatRegNo;
          private int flatType;
          private int flatArea;
          private double rentAmount;
          private double depositAmount;
		public int getOwnerid() {
			return ownerid;
		}
		public void setOwnerid(int ownerid) {
			this.ownerid = ownerid;
		}
		public String getOwnerName() {
			return ownerName;
		}
		public void setOwnerName(String ownerName) {
			this.ownerName = ownerName;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public long getFlatRegNo() {
			return flatRegNo;
		}
		public void setFlatRegNo(long flatRegNo) {
			this.flatRegNo = flatRegNo;
		}
		public int getFlatType() {
			return flatType;
		}
		public void setFlatType(int flatType) {
			this.flatType = flatType;
		}
		public int getFlatArea() {
			return flatArea;
		}
		public void setFlatArea(int flatArea) {
			this.flatArea = flatArea;
		}
		public double getRentAmount() {
			return rentAmount;
		}
		public void setRentAmount(double rentAmount) {
			this.rentAmount = rentAmount;
		}
		public double getDepositAmount() {
			return depositAmount;
		}
		public void setDepositAmount(double depositAmount) {
			this.depositAmount = depositAmount;
		}
          
}
