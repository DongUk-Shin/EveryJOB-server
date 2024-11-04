package sch.EveryJOB.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sch.EveryJOB.common.error.MemberErrorCode;
import sch.EveryJOB.common.exception.CustomException;
import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Member;
import sch.EveryJOB.domain.dto.MemberLoginRequestDTO;
import sch.EveryJOB.domain.dto.MemberRequestDTO;
import sch.EveryJOB.domain.dto.MemberResponseDTO;
import sch.EveryJOB.repository.DisabledRepository;
import sch.EveryJOB.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final DisabledRepository disabledRepository;
    
    @Transactional
    public void joinMember(MemberRequestDTO memberRequestDTO) {
        
        boolean b = memberRepository.existsByAccountId(memberRequestDTO.getAccountId());
        
        if (b) {
            throw new CustomException(MemberErrorCode.MEMBER_ALREADY_EXIST);
        }
        
        memberRepository.save(Member.builder()
                .accountId(memberRequestDTO.getAccountId())
                .password(memberRequestDTO.getPassword())
                .name(memberRequestDTO.getName())
                .gender(memberRequestDTO.getGender())
                .age(memberRequestDTO.getAge())
                .email(memberRequestDTO.getEmail())
                .call_info(memberRequestDTO.getCall_info())
                .address(memberRequestDTO.getAddress())
                .intro(memberRequestDTO.getAddress())
                .disabled(null)
                .build());
    }
    
    @Transactional
    public void loginMember(MemberLoginRequestDTO memberLoginRequestDTO) {
        
        Member member = memberRepository.findByAccountId(memberLoginRequestDTO.getAccountId()).orElseThrow(
                () -> new CustomException(MemberErrorCode.MEMBER_NOT_FOUND));
        
        if (!memberLoginRequestDTO.getPassword().equals(member.getPassword())) {
            throw new CustomException(MemberErrorCode.MEMBER_WRONG_PASSWORD);
        }
        
    }
    
    @Transactional
    public MemberResponseDTO readMember(String accountId) {
        
        Member member = memberRepository.findByAccountId(accountId).orElseThrow(
                () -> new CustomException(MemberErrorCode.MEMBER_SESSION_ERROR));
        
        return MemberResponseDTO.builder()
                .accountId(member.getAccountId())
                .name(member.getName())
                .gender(member.getGender())
                .age(member.getAge())
                .email(member.getEmail())
                .call_info(member.getCall_info())
                .address(member.getAddress())
                .intro(member.getAddress())
                //.disabled_type(member.getDisabled())
                .build();
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
