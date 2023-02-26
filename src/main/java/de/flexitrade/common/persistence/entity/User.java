package de.flexitrade.common.persistence.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false)
	@NotBlank
	@Size(max = 20)
	private String username;

	@Column(name = "email", nullable = false)
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@Column(name = "password", nullable = false)
	@NotBlank
	@Size(max = 120)
	private String password;
	
	/*
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	*/
	
	@Column(name = "isAccountNonExpired", columnDefinition = "boolean default true", nullable = false)
	private Boolean isAccountNonExpired = true;
	
	@Column(name = "isAccountNonLocked", columnDefinition = "boolean default false", nullable = false)
	private Boolean isAccountNonLocked = false;
	
	@Column(name = "uniqueSecret", nullable = false)
	private String uniqueSecret;
	
	@Column(name = "isEnabled", columnDefinition = "boolean default true", nullable = false)
	private Boolean isEnabled = true;
}