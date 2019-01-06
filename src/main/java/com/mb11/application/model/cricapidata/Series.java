package com.mb11.application.model.cricapidata;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "series", uniqueConstraints = {@UniqueConstraint(columnNames = "sid")})
public class Series {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private Integer sid;
	
	@Column(nullable = false)
	private String sname;
	
	@Column(nullable = false)
	private Date sstartdate;
	
	@Column(nullable = false)
	private Date senddate;
	
	@Column(nullable = false)
	private Integer stotalmatch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getSstartdate() {
		return sstartdate;
	}

	public void setSstartdate(Date sstartdate) {
		this.sstartdate = sstartdate;
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public Integer getStotalmatch() {
		return stotalmatch;
	}

	public void setStotalmatch(Integer stotalmatch) {
		this.stotalmatch = stotalmatch;
	}
	
}
