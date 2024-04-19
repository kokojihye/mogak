package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kr.mogak.enums.Category;
import kr.mogak.enums.Yn;
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
@Table(name = "t_post")
@Entity
public class Post extends CommonEntity{
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
