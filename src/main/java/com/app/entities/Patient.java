package com.app.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "patients")
public class Patient extends User {
	
//
//    @Column(name = "history")
//    private String history;
//    
//
//    @Column(name = "description")
//    private String description;


}
