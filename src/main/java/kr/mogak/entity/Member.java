package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.util.List;

/**
 * BaseTime - createAt, updateAt 상속
 */
@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_member")
@Entity
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("회원 id")
    private Long id;

    @Comment("회원 닉네임")
    private String nickname;

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

    @Builder
    public Member(String nickname) {
        this.nickname = nickname;
    }
}
