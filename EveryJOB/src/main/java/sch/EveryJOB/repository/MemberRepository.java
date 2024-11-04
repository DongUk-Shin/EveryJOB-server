package sch.EveryJOB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sch.EveryJOB.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    
    Optional<Member> findByAccountId(String accountId);
    boolean existsByAccountId(String accountId);
    
}
