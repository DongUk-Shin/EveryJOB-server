package sch.EveryJOB.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(precision = 10, scale = 7)
    BigDecimal latitude;
    
    @Column(precision = 10, scale = 7)
    BigDecimal longitude;
    
    String address;
    
    @Column(length = 50)
    String name;
    
    @Column(length = 50)
    String recruitment_period;
    
    @Column(length = 50)
    String job_category;
    
    @Column(length = 50)
    String employment_type;
    
    @Column(length = 50)
    String salary_type;
    
    Integer salary;
    
    @Column(length = 50)
    String entry_type;
    
    @Column(length = 50)
    String required_experience;
    
    @Column(length = 50)
    String required_education;
    
    @Column(length = 50)
    String major_field;
    
    @Column(length = 50)
    String certifications;
    
    @Column(length = 50)
    String responsible_agency;
    
    @Column(length = 50)
    String call_info;
}
