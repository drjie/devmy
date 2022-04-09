package com.lz.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.*;

public class JwtTest {
    @Test
    public void encode1(){
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("typ","JWT");

        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.SECOND,60);

        String token= JWT.create()
                .withHeader(header)
                .withClaim("id",1)
                .withClaim("username","迪丽热巴")
                .withClaim("info","管理员")
                .withClaim("createTime",new Date())
                .withExpiresAt(instance.getTime())
                //发布者
                .withIssuer("玛卡巴卡")
                //发布时间
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256("123456"));

        System.out.println(token);

    }

    @Test
    public void encode(){
        HashMap<String, Object> header = new HashMap<>();

        header.put("alg","HS256");
        header.put("typ","JWT");

        HashMap<String, Object> payload = new HashMap<>();

        Calendar instance = Calendar.getInstance();

        instance.add(Calendar.SECOND,60);

        payload.put("id",1);
        payload.put("username","迪丽热巴");
        payload.put("info","管理员");
        payload.put("createTime",new Date());
        payload.put("lastAccessTime",new Date());
        payload.put("exp",instance.getTime());

        String token= JWT.create()
                .withHeader(header)
                .withPayload(payload)
                .sign(Algorithm.HMAC256("123456"));

        System.out.println(token);

    }

    @Test
    public void decode(){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("123456")).build();

        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsYXN0QWNjZXNzVGltZSI6MTY0ODk2NzQ3OSwiY3JlYXRlVGltZSI6MTY0ODk2NzQ3OSwiaWQiOjEsImV4cCI6MTY0ODk2NzUzOSwidXNlcm5hbWUiOiLov6rkuL3ng63lt7QiLCJpbmZvIjoi566h55CG5ZGYIn0.k9VpJcDLM8gYmra08Xf3m9CoKUtsrKKanfrxP22equc");

        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getExpiresAt());

        Map<String, Claim> map = decodedJWT.getClaims();

        Set<Map.Entry<String, Claim>> entries = map.entrySet();

        for (Map.Entry<String, Claim> entry : entries) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
