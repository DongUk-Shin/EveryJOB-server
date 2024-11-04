package sch.EveryJOB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sch.EveryJOB.domain.Disabled;

public interface DisabledRepository  extends JpaRepository<Disabled, Long> {
    
}
