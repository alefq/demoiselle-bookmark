package com.alefq.bookmark.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Site
 * 
 */
@Entity
public class Site implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7426000221328383339L;
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	@Column(name = "SITE_ID")
	private Long siteId;
	
	@Column
	private String homepage;

	public Site() {
		super();
	}

	public Site(String homepage) {
		setHomepage(homepage);
	}

	public Long getSiteId() {
		return this.siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getHomepage() {
		return this.homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

}
