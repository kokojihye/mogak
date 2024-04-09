package kr.mogak.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;

import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@Table(name = "t_member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
