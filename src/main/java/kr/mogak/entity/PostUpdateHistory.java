package kr.mogak.entity;

import jakarta.persistence.*;
import kr.mogak.enums.Category;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Slf4j
@Getter
@RequiredArgsConstructor
@Table(name = "t_post_update_history")
@Entity
public class PostUpdateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("게시글 수정 히스토리 id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @Comment("게시글 id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @Comment("작성자")
    private Member author;

    @Enumerated(EnumType.STRING)
    @Comment("카테고리")
    private Category category;

    @Comment("제목")
    private String title;

    @Comment("내용")
    private String content;

    @Comment("수정일자")
    private LocalDateTime updatedAt;
}
