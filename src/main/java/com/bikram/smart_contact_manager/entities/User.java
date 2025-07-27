package com.bikram.smart_contact_manager.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private Integer id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(unique = true, nullable = false)
	private String email;
	@Lob // large object
	private String about;
	@Column(length = 1000)
	private String profilePicture;
	private String phoneNumber;
	
	private boolean enabled;
	private boolean emailVerified;
	private boolean phoneNumberVerified;
	
	// provider
	@Enumerated(value = EnumType.STRING)
	private Providers provider = Providers.SELF;
	// contacts (set of contacts)
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) // here mapped by is user (it is referencing the field-name "user" in class Contact)(in this case a foreign key is created in the Contact table to manage the user)(if mapped by is not mentioned, then another table is created to manage the contacts of the users)
	Set<Contact> contacts = new HashSet<>();
	
	
}
