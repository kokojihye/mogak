package kr.mogak.entity;

import jakarta.persistence.*;
import kr.mogak.enums.ReportReason;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_post_report")
@Entity
public class PostReport extends CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("게시글 신고 관리 id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reported_post_id")
    @Comment("신고된 게시글")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "reporter_id")
    @Comment("신고자")
    private Member reporter;

    @Comment("신고 사유")
    @Enumerated(EnumType.STRING)
    private ReportReason reportReason;

    @Comment("신고 상세 사유")
    private String reportReasonDetail;

}
