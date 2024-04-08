package kr.mogak.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Category {
    PROJECT("프로젝트"),
    MOGAKCO("모각코"),
    STUDY("스터디");

    private final String categoryName;
}
