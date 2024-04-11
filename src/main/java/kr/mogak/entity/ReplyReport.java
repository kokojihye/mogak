package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kr.mogak.enums.ReportReason;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.LocalDateTime;

@Slf4j
@Getter
@RequiredArgsConstructor
@Table(name = "t_reply_report")
@Entity
public class ReplyReport extends BaseTime implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("댓글 신고 관리 id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reported_reply_id")
    @Comment("신고된 댓글")
    private Reply reply;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    @Comment("신고자")
    private Member reporter;

    @Comment("신고 사유")
    @Enumerated(EnumType.STRING)
    private ReportReason reportReason;

    @Comment("신고 상세 사유")
    private String reportReasonDetail;

    @Comment("취소일자")
    private LocalDateTime canceledAt;

}
