package spring.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.security.dto.MemberDto;
import spring.security.service.MemberService;

import javax.validation.Valid;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    @GetMapping("/join")
    public String join(MemberDto memberDto){
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@Valid MemberDto memberDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
           return "member/join";

        }

        memberService.memberInsert(memberDto);

        return "member/login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "member/logout";
    }

    @GetMapping("/loginFail")
    public String loginFail(){
        return "loginFail";
    }

    @GetMapping("/memberShip")
    public String memberShip(){
        return "membership 페이지";
    }
}
