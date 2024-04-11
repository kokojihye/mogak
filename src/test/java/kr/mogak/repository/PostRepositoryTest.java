package kr.mogak.repository;

import kr.mogak.entity.Member;
import kr.mogak.entity.Post;
import kr.mogak.enums.Category;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    MemberRepository memberRepository;


    @Before
    public void addMember() {
        String nickname = "멤버 1";
        memberRepository.save(Member.builder()
                .nickname(nickname)
                .build());
    }
    @After
    public void clean() {
        postRepository.deleteAll();
        memberRepository.deleteAll();
    }

    @Test
    public void 게시글_저장하기() {
        // given
        Category category = Category.MOGAKCO;
        String title = "title test";
        String content = "content test";

        postRepository.save(Post.builder()
                .author(memberRepository.findAll().get(0))
                .category(category)
                .title(title)
                .content(content)
                .build()
        );

        //when
        List<Post> postList = postRepository.findAll();

        //then
        Post post = postList.get(0);
        Assertions.assertThat(post.getTitle().equals(title));
        Assertions.assertThat(post.getContent().equals(content));
    }
}
