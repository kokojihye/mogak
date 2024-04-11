package kr.mogak.entity;

import jakarta.persistence.*;
import kr.mogak.enums.ReportReason;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

/**
 * BaseTime - createAt, updateAt 상속
 */
@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_reply_report")
@Entity
public class ReplyReport extends BaseTime {

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
