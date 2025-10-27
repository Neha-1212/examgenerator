package com.skillforge.skillforge_login.model;

import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.*;

import lombok.Data;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        STUDENT, INSTRUCTOR, ADMIN
    }
    public User() {
    	
    }
    public User( Long id, String name, String email, String password) {
    	super();
    	this.id=id;
    	this.name=name;
    	this.email=email;
    	this.password=password;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// Getter
	public Role getRole() {
	    return role;
	}

	// Setter
	public void setRole(Role role) {
	    this.role = role;
	}

}
