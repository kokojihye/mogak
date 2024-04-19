package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_member")
@Entity
public class Member extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("id")
    private Long id;
    @Comment("회원 닉네임")
    private String nickname;
    @Comment("로그인 id")
    private String loginId;
    @Comment("비밀번호")
    private String password;
    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<PostUpdateHistory> updatedPosts;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private List<Reply> replies;

    @OneToMany(mappedBy = "reporter")
    @JsonIgnore
    private List<PostReport> postReportList;

    @OneToMany(mappedBy = "reporter")
    @JsonIgnore
    private List<ReplyReport> replyReportList;

}
