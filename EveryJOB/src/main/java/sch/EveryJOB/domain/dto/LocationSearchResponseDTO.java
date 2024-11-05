package sch.EveryJOB.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LocationSearchResponseDTO {
    
    Long id;
    BigDecimal latitude;
    BigDecimal longitude;
    
}