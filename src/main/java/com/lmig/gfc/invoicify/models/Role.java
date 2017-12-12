package com.lmig.gfc.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "invoicify_role")
public class Role {

	@Id
	@GeneratedValue(generator = "role_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq")
	private Long id;

	@ManyToOne(optional = false)
	private User user;

	@Column(nullable = false, unique = true)
	private String name;

	public Role() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
