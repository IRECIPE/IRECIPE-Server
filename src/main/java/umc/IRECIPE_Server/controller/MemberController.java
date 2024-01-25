package umc.IRECIPE_Server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.IRECIPE_Server.service.MemberService;
import umc.IRECIPE_Server.dto.request.MemberLoginRequestDto;
import umc.IRECIPE_Server.dto.TokenDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public TokenDto login(@RequestBody MemberLoginRequestDto memberLoginRequestDto) {
        String nickname = memberLoginRequestDto.getNickname();
        String password = memberLoginRequestDto.getPassword();
        TokenDto tokenDTO = memberService.login(nickname, password);
        return tokenDTO;
    }

    @PostMapping("/test")
    public String test(){
        return "Success";
    }
}