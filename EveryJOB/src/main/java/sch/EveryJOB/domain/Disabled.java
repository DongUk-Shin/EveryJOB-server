package sch.EveryJOB.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Disabled {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(length = 50)
    String disabled_type;
    
    @Column(length = 50)
    String is_severe;
}
