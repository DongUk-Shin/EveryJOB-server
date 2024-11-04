package sch.EveryJOB.controller;

import sch.EveryJOB.domain.Disabled;
import sch.EveryJOB.domain.Location;
import sch.EveryJOB.domain.Member;
import sch.EveryJOB.service.LocationService;
import sch.EveryJOB.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class HomeController {
    
    private final LocationService locationService;
    private final MemberService memberService;
    
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/db")
    public String db(Model model) {
        List<Member> members = memberService.allMembers();
        List<Disabled> disables = memberService.allDisableds();
        
        model.addAttribute("members", members);
        model.addAttribute("disables", disables);
        
        return "test/db";
    }
    
    
    // 메인페이지
    @GetMapping("/mainpage")
    public ResponseEntity<List<Location>> mainpage(HttpServletRequest request, HttpSession session) {
        
        String json = "";
        
        List<Location> locations = locationService.getLocations();
        
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }
    
    
}
