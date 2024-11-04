package sch.EveryJOB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sch.EveryJOB.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    
}
