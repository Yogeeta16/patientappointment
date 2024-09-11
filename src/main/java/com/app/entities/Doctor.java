package com.app.entities;

import javax.persistence.Column;
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
@Table(name = "doctors")
public class Doctor extends User {

    @Column(name = "specialization",  nullable = false)
    private String specialization;
    
//    @Column(name = "start_time",  nullable = false)
//    private LocalDateTime startTime;
//    
//    
//    @Column(name = "end_time",  nullable = false)
//    private LocalDateTime endTime;
//    
//    @Column(name = "background",  nullable = false)
//    private String background;
//    
//    @Column(name = "location",  nullable = false)
//    private String location;
//    
//    @Column(name = "consult_fee",  nullable = false)
//    private int consultationFee;
//    
//    @Column(name = "education",  nullable = false)
//    private String education;


}
