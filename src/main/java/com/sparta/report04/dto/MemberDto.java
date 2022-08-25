package com.sparta.report04.dto;

import lombok.Getter;
import lombok.Setter;

import com.sparta.report04.domain.Member;
@Getter
@Setter
public class MemberDto {
    private String nickname;
    private Long id;
    private String createdDate, modifiedDate;

    public MemberDto(Member member) {
        this.nickname = member.getNickname();
        this.id = member.getId();
        this.createdDate = member.getCreatedAt().toString();
        this.modifiedDate = member.getModifiedAt().toString();
    }
}
