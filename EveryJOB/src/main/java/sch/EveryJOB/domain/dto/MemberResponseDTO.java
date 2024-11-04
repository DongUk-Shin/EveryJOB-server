package sch.EveryJOB.domain.dto;


import lombok.Builder;
import lombok.Data;
import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Member;

@Data
@Builder
public class MemberResponseDTO {
    
    String accountId;
    String name;
    String gender;
    Integer age;
    String email;
    String call_info;
    String address;
    String intro;
    String disabled_type;
    String is_severe;
    
}