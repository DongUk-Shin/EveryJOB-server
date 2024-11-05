package sch.EveryJOB.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LocationDetailResponseDTO {
    
    Long id;
    String address;
    String name;
    String recruitment_period;
    String job_category;
    String employment_type;
    String salary_type;
    Integer salary;
    String entry_type;
    String required_experience;
    String required_education;
    String major_field;
    String certifications;
    String responsible_agency;
    String call_info;
    
}