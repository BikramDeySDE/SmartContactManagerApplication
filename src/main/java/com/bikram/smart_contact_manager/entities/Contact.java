package com.bikram.smart_contact_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id
	private Integer id;
	private String name;
	private String phoneNumber;
	private String address;
	private String picture;
	@Lob
	private String description;
	private boolean favorite=false;
	
	private String websiteLink;
	private String facebookLink;
	private String instagramLink;
	private String cloudinaryImagePublicId;
	
	// user
	@ManyToOne // by-fault fetchType is eager
	private User user;
	
	
}
