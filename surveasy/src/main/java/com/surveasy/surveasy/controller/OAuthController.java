package com.surveasy.surveasy.controller;

import com.surveasy.surveasy.service.OAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthService oAuthService;


    @ResponseBody
    @GetMapping("/kakao")
    public void kakaoCallBack(@RequestParam String code) {
        String access_Token = oAuthService.getKakaoAccessToken(code);
        // System.out.println(access_Token);

        HashMap<String, Object> userInfo = oAuthService.createKakaoUser(access_Token);
        System.out.println(userInfo);
    }
}
