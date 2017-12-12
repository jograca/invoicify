package com.lmig.gfc.invoicify.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "invoicify_user")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
	private Long id;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Role> roles;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Setting up a role:
		// ROLE_ADMIN

		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : roles) {
			String roleName = "ROLE_" + role.getName();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roleName);
			authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
