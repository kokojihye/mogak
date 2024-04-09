package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kr.mogak.enums.Category;
import kr.mogak.enums.Yn;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@Table(name = "t_post")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Comment("게시글 id")
    private Long id;

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

    @Comment("작성일자")
    private LocalDateTime createdAt;

    @Comment("수정 여부")
    private Yn updatedYn;

    @Comment("수정일자")
    private LocalDateTime updatedAt;

    @Comment("삭제 여부")
    private Yn deletedYn;

    @Comment("삭제일자")
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<PostReport> postReports;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<Reply> replies;

    @OneToMany(mappedBy = "post")
    @JsonIgnore
    private List<PostUpdateHistory> updatedPosts;

}
