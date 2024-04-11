package kr.mogak.repository;

import kr.mogak.entity.Member;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void clean() {
        memberRepository.deleteAll();
    }

    @Test
    public void 멤버를_추가한다() {
        //given
        String nickname = "멤버 1";
        memberRepository.save(Member.builder().nickname(nickname).build());

        //when
        List<Member> memberList = memberRepository.findAll();

        // then
        Member member = memberList.get(0);
        assertThat(member.getNickname().equals(nickname));
    }
}
