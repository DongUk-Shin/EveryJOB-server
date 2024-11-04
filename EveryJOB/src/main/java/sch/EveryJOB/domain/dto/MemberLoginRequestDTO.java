package sch.EveryJOB.domain.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberLoginRequestDTO {
    
    String accountId;
    String password;
    
}
