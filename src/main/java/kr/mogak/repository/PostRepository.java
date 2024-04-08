package kr.mogak.repository;


import kr.mogak.entity.Post;
import kr.mogak.enums.Yn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByDeletedYn(Yn deleteYn);
}
