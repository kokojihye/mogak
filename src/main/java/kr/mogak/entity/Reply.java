package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@Table(name = "t_reply")
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Comment("댓글 id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @Comment("게시글")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Comment("작성자")
    private Member author;

    @Comment("내용")
    private String content;

    @Comment("작성일자")
    private LocalDateTime createdAt;

    @Comment("수정일자")
    private LocalDateTime updatedAt;

    @Comment("삭제일자")
    private LocalDateTime deletedAt;

    @Comment("신고 누적 횟수")
    private Integer countReport;

    @Comment("깊이")
    private Integer depth;

    @Comment("부모 댓글")
    private Long parentReply;

    @JsonIgnore
    @OneToMany(mappedBy = "reply")
    private List<ReplyReport> replyReports;
}
