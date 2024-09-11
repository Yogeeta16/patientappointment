package com.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User extends BaseEntity {



//    @Column(name = "username", unique = true, nullable = false)
//    private String username;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @Column(name = "active", nullable = false)
//    private boolean active;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String email;
//
//    @Column(name = "dob", nullable = false)
//    private LocalDate dob;
//    
    @Column(name="phone_no",unique = true)
	private String phone;
  
}
