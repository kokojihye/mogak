package kr.mogak.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kr.mogak.enums.Yn;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
@Slf4j
@Getter
@RequiredArgsConstructor
public class CommonEntity {
    @Comment("삭제 여부")
    private Yn deleteYn;
    @Comment("생성일시")
    private LocalDateTime createdAt;
    @Comment("수정일시")
    private LocalDateTime updatedAt;
    @Comment("삭제일시")
    private LocalDateTime deletedAt;

}
