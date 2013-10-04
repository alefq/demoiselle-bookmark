package com.alefq.bookmark.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bookmark implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*
	 *  If you are using Glassfish then remove the strategy attribute
	 */
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Long id;
	
	@Column
	private String description;
	
	@Column
	private String link;
	
    /* bi-directional many-to-one association to Site*/
    @ManyToOne
    @JoinColumn(name = "SITE_ID")
    private Site site;

	
	public Bookmark() {
		super();
	}
	
	public Bookmark(String description, String link) {
		this.description = description;
		this.link = link;
	}
	
	public Bookmark(String description, String link, Site masterSite) {
		this(description, link);
		setSite(masterSite);
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
