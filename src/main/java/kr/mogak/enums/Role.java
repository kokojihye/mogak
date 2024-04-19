package kr.mogak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Role {
    ROLE_ADMIN("관리자"),
    ROLE_USER("회원");

    private final String Authorization;
}
