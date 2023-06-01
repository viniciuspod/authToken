package br.com.vdantas.authToken.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name = "T_USUARIO")
@Data
public class Usuario implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name= "USUARIO_ID")
	private Long id;
	
	@Column(name = "USUARIO_LOGIN")
	private String login;
	
	@Column(name = "USUARIO_NOME")
	private String nome;
	
	@Column(name = "USUARIO_SENHA")
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> listSimpleGrantedAuthorities= new ArrayList<>();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
		listSimpleGrantedAuthorities.add(simpleGrantedAuthority);		
		return listSimpleGrantedAuthorities;
	}

	@Override
	public String getUsername() {
		return login;
	}
	
	@Override
	public String getPassword() {
		return password;
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
