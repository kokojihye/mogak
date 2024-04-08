package kr.mogak.entity;

import jakarta.persistence.*;
import kr.mogak.enums.ReportReason;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@Entity
public class PostReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Comment("게시글 신고 관리 id")
    private Long id;

    @ManyToOne
    @Comment("신고된 게시글")
    private Post post;

    @ManyToOne
    @Comment("신고자")
    private Member reporter;

    @Comment("신고 사유")
    private ReportReason reportReason;

    @Comment("신고 상세 사유")
    private String reportReasonDetail;

    @Comment("신고일자")
    private LocalDateTime reportedAt;

    @Comment("수정일자")
    private LocalDateTime updatedAt;

    @Comment("취소일자")
    private LocalDateTime canceledAt;
}