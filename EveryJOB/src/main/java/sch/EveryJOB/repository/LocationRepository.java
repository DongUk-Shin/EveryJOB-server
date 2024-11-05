package sch.EveryJOB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sch.EveryJOB.domain.Location;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    
    Optional<Location> findByName(String name);
    
}
