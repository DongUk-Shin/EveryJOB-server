package sch.EveryJOB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Member;
import sch.EveryJOB.domain.dto.MemberLoginRequestDTO;
import sch.EveryJOB.domain.dto.MemberRequestDTO;
import sch.EveryJOB.domain.dto.MemberResponseDTO;
import sch.EveryJOB.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    
    private final MemberService memberService;
    
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody MemberRequestDTO memberRequestDTO) {
        
        System.out.println("memberRequestDTO.getAccountId() = " + memberRequestDTO.getAccountId());
        System.out.println("memberRequestDTO.getPassword() = " + memberRequestDTO.getPassword());
        
        memberService.joinMember(memberRequestDTO);
        
        System.out.println("회원가입 성공");
        return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberLoginRequestDTO memberLoginRequestDTO,
                                        HttpSession session) {
        
        System.out.println("member.getAccountId() = " + memberLoginRequestDTO.getAccountId());
        System.out.println("member.getPassword() = " + memberLoginRequestDTO.getPassword());
        
        memberService.loginMember(memberLoginRequestDTO);
        
        session.setAttribute("accountId", memberLoginRequestDTO.getAccountId());
        
        System.out.println("로그인 성공");
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping
    public MemberResponseDTO readMember(HttpSession session) {
        
        String accountId = (String) session.getAttribute("accountId");
        
        return memberService.readMember(accountId); 
    }

}



