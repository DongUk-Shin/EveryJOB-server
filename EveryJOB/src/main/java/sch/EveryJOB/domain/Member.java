package sch.EveryJOB.domain;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(length = 50)
    String accountId;
    
    String password;
    
    @Column(length = 50)
    String name;
    
    @Column(length = 50)
    String gender;
    
    Integer age;
    
    @Column(length = 50)
    String email;
    
    @Column(length = 50)
    String call_info;
    
    @Column(length = 50)
    String address;
    
    @Lob
    String intro;
    
    @OneToOne
    @JoinColumn
    Disabled disabled;
}
