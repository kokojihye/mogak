package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kr.mogak.enums.Category;
import kr.mogak.enums.Yn;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@Table(name = "t_post")
@Entity
public class Post extends BaseTime implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Comment("수정 여부")
    @Enumerated(EnumType.STRING)
    private Yn updatedYn = Yn.N;

    @Comment("삭제 여부")
    @Enumerated(EnumType.STRING)
    private Yn deletedYn = Yn.N;

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


    @Builder
    public Post(Long id, Member author, Category category, String title, String content) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
