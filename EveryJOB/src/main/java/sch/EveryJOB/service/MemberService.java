package sch.EveryJOB.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Member;
import sch.EveryJOB.repository.DisabledRepository;
import sch.EveryJOB.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final DisabledRepository disabledRepository;
    
    public boolean joinMember(Member member, Disabled disabled) {
        
        Optional<Member> optMember = memberRepository.findByAccountId(member.getAccountId());
        
        if (optMember.isPresent()) {
            //이미 존재하는 회원인 경우
            return false;
        }
        
        // disabled가 null이 아닌 경우 연관관계 설정 후 저장
        if (disabled != null) {
            disabledRepository.save(disabled);
            member.setDisabled(disabled); // member와 disabled 간의 관계 설정
        }
        
        memberRepository.save(member);
        return true;
    }
    
    public boolean loginMember(Member member) {
        
        Optional<Member> optMember = memberRepository.findByAccountId(member.getAccountId());
        Member foundMember = optMember.get();
        
        if (foundMember.getPassword().equals(member.getPassword())) {
            return true;
        }
        
        return false;
    }
    
    public boolean existsMemberAccount(Member member) {
        return memberRepository.existsByAccountId(member.getAccountId());
    }
    
    public List<Member> allMembers() {
        return memberRepository.findAll();
    }
    
    public List<Disabled> allDisableds() {
        return disabledRepository.findAll();
    }
    
    
    
    
    /*@Transactional
    public void updateDisabilityInfo(Member member, Disabled disabled) {
        
        Member findMember = memberRepository.findByAccountId(member.getAccountId()).get();
        findMember.setDisabled(disabled);
        memberRepository.save(findMember);
        System.out.println("장애 정보 입력 성공");
    }*/
}
