package sch.EveryJOB.controller;

import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Member;
import sch.EveryJOB.domain.MemberRequestDTO;
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
        
        Member member = memberRequestDTO.toMember();
        Disabled disabled = memberRequestDTO.toDisabled();
        
        System.out.println("member.getAccountId() = " + member.getAccountId());
        System.out.println("member.getPassword() = " + member.getPassword());
        
        boolean is_join = memberService.joinMember(member, disabled);
        
        if (!is_join) {
            System.out.println("아이디 중복");
            return new ResponseEntity<>("아이디 중복", HttpStatus.BAD_REQUEST);
        }
        
        System.out.println("회원가입 성공");
        return new ResponseEntity<>("회원가입 성공", HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Member member,
                                        HttpSession session) {
        System.out.println("member.getAccountId() = " + member.getAccountId());
        System.out.println("member.getPassword() = " + member.getPassword());
        
        boolean isFind = memberService.existsMemberAccount(member);
        if (!isFind) {
            System.out.println("존재하지 않는 아이디");
            return new ResponseEntity<>("존재하지 않는 아이디", HttpStatus.BAD_REQUEST);
        }
        
        
        boolean isLogin = memberService.loginMember(member);
        if (!isLogin) {
            System.out.println("비밀번호 불일치");
            return new ResponseEntity<>("비밀번호 불일치", HttpStatus.BAD_REQUEST);
        }
        
        session.setAttribute("session", member);
        
        System.out.println("로그인 성공");
        return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
    }
    
    
}



