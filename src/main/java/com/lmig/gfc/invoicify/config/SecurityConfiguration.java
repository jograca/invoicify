package com.lmig.gfc.invoicify.config;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lmig.gfc.invoicify.services.InvoicifyUserDetailService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private InvoicifyUserDetailService userDetailsService;

	public SecurityConfiguration(InvoicifyUserDetailService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}

}
