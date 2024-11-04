package sch.EveryJOB.domain.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Member;

@Data
@Builder
public class MemberRequestDTO {
    
    String accountId;
    String password;
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
