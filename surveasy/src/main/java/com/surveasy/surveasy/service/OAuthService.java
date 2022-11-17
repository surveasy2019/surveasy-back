package com.surveasy.surveasy.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class OAuthService {

    public String getKakaoAccessToken(String code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // POST 요청을 하기 위해 기본값이 false였던 setDoOutput 값을 true로 변경
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // POST 요청에 필요로 하는 파라미터 스트림을 통해 전송
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("grant_type=authorization_code");
            stringBuilder.append("&client_id=46b2de879638af5d852ba559658cac16");
            stringBuilder.append("&redirect_uri=http://localhost:3001/kakao");
            stringBuilder.append("&code=" + code);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();

            // 결과 코드가 200이면 성공
            int resCode = conn.getResponseCode();
            System.out.println("response CODE : " + resCode);

            // 요청을 통해 얻은 JSON 타입의 Response 데이터 읽어오기
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            System.out.println("response BODY : " + result);

            // Gson 라이브러리에 포함된 클래스로 JSON 파싱 객체 생성
            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(result);

            access_Token = jsonElement.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = jsonElement.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access Token : " + access_Token);
            System.out.println("refresh Token : " + refresh_Token);

            bufferedReader.close();
            bufferedWriter.close();


        }  catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }

}
