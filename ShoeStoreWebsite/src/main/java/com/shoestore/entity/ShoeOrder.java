package com.shoestore.entity;
// Generated Apr 20, 2024, 2:20:15â€¯PM by Hibernate Tools 4.3.6.Final

import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ShoeOrder generated by hbm2java
 */
@Entity
@Table(name = "shoe_order", catalog = "shoestoredb")
@NamedQueries({
	@NamedQuery(name = "ShoeOrder.findAll", query = "SELECT sh FROM ShoeOrder sh ORDER BY sh.orderDate DESC"),
	@NamedQuery(name = "ShoeOrder.countAll", query = "SELECT COUNT(*) FROM ShoeOrder"),
	@NamedQuery(name = "ShoeOrder.findByCustomer", query = "SELECT sh FROM ShoeOrder sh WHERE sh.customer.customerId =:customerId ORDER BY sh.orderDate DESC"),
	@NamedQuery(name = "ShoeOrder.findByIdAndCustomer", query ="SELECT sh FROM ShoeOrder sh WHERE sh.orderId =:orderId AND sh.customer.customerId =:customerId")
})
public class ShoeOrder implements java.io.Serializable {

	private Integer orderId;
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

	public ShoeOrder(Integer orderId, Customer customer, Date orderDate, String toAddress, String recipientName,
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

	public ShoeOrder(Integer orderId, Customer customer, Date orderDate, String toAddress, String recipientName,
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "shoeOrder", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<OrderDetail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	@javax.persistence.Transient
	public int getShoeAmount() {
		int total = 0;
		
		for (OrderDetail orderDetail : orderDetails) {
			total += orderDetail.getQuantity();
		}
		
		return total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoeOrder other = (ShoeOrder) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}



}
