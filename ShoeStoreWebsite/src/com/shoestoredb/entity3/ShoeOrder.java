package com.shoestoredb.entity3;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ShoeOrder generated by hbm2java
 */
@Entity
@Table(name = "shoe_order", catalog = "shoestoredb")
public class ShoeOrder implements java.io.Serializable {

	private int orderId;
	private Customer customer;
	private Date orderDate;
	private String toAddress;
	private String recipientName;
	private String recipientPhone;
	private String payment;
	private float orderSum;
	private String status;
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

	public ShoeOrder() {
	}

	public ShoeOrder(int orderId, Customer customer, Date orderDate, String toAddress, String recipientName,
			String recipientPhone, String payment, float orderSum, String status) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.toAddress = toAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.payment = payment;
		this.orderSum = orderSum;
		this.status = status;
	}

	public ShoeOrder(int orderId, Customer customer, Date orderDate, String toAddress, String recipientName,
			String recipientPhone, String payment, float orderSum, String status, Set<OrderDetail> orderDetails) {
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.toAddress = toAddress;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.payment = payment;
		this.orderSum = orderSum;
		this.status = status;
		this.orderDetails = orderDetails;
	}

	@Id

	@Column(name = "order_id", unique = true, nullable = false)
	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "to_address", nullable = false, length = 50)
	public String getToAddress() {
		return this.toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	@Column(name = "recipient_name", nullable = false, length = 50)
	public String getRecipientName() {
		return this.recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	@Column(name = "recipient_phone", nullable = false, length = 10)
	public String getRecipientPhone() {
		return this.recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	@Column(name = "payment", nullable = false, length = 50)
	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Column(name = "order_sum", nullable = false, precision = 12, scale = 0)
	public float getOrderSum() {
		return this.orderSum;
	}

	public void setOrderSum(float orderSum) {
		this.orderSum = orderSum;
	}

	@Column(name = "status", nullable = false, length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoeOrder")
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

}