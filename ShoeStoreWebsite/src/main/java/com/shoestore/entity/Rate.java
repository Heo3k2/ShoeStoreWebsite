package com.shoestore.entity;
// Generated Apr 20, 2024, 2:20:15 PM by Hibernate Tools 4.3.6.Final

import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rate generated by hbm2java
 */
@Entity
@Table(name = "rate", catalog = "shoestoredb")
@NamedQueries({
	@NamedQuery(name = "Rate.listAll", query = "SELECT r FROM Rate r ORDER BY r.rateTime DESC"),
	@NamedQuery(name = "Rate.countAll", query = "SELECT COUNT(r) FROM Rate r")
})
public class Rate implements java.io.Serializable {

	private int rateId;
	private Customer customer;
	private Shoe shoe;
	private int ratingStars;
	private String headline;
	private String ratingDetail;
	private Date rateTime;

	public Rate() {
	}

	public Rate(int rateId, Customer customer, Shoe shoe, int ratingStars, String headline, String ratingDetail,
			Date rateTime) {
		this.rateId = rateId;
		this.customer = customer;
		this.shoe = shoe;
		this.ratingStars = ratingStars;
		this.headline = headline;
		this.ratingDetail = ratingDetail;
		this.rateTime = rateTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rate_id", unique = true, nullable = false)
	public int getRateId() {
		return this.rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shoe_id", nullable = false)
	public Shoe getShoe() {
		return this.shoe;
	}

	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	@Column(name = "rating_stars", nullable = false)
	public int getRatingStars() {
		return this.ratingStars;
	}

	public void setRatingStars(int ratingStars) {
		this.ratingStars = ratingStars;
	}

	@Column(name = "headline", nullable = false, length = 50)
	public String getHeadline() {
		return this.headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	@Column(name = "rating_detail", nullable = false, length = 200)
	public String getRatingDetail() {
		return this.ratingDetail;
	}

	public void setRatingDetail(String ratingDetail) {
		this.ratingDetail = ratingDetail;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rate_time", nullable = false, length = 19)
	public Date getRateTime() {
		return this.rateTime;
	}

	public void setRateTime(Date rateTime) {
		this.rateTime = rateTime;
	}

}
