package designParkingLot.models;

import designParkingLot.models.enums.PaymentMode;
import designParkingLot.models.enums.PaymentStatus;

public class Payment extends BaseModel {
	private Bill bill;
	private PaymentStatus status;
	private PaymentMode mode;
	
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	public PaymentMode getMode() {
		return mode;
	}
	public void setMode(PaymentMode mode) {
		this.mode = mode;
	}

}
