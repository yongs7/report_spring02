package com.sparta.report04.dto;

import static com.sparta.report04.domain.Member.*;
import com.sparta.report04.domain.Member;
import com.sparta.report04.domain.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String nickname;
    private String password;
    public Member toMember(PasswordEncoder passwordEncoder) {
        return builder()
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(nickname, password);
    }
}
