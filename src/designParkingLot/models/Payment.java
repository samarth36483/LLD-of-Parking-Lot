package designParkingLot.models;

import java.time.LocalDateTime;

import designParkingLot.models.enums.PaymentMode;
import designParkingLot.models.enums.Status;

public class Payment extends BaseModel {
	private int amount;
	private PaymentMode paymentMode;
	private String transaction_id;
	private LocalDateTime time;
	private Bill bill;
	private Status paymentStatus;
	
	public Status getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	

}
