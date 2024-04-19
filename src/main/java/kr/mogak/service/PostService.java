package kr.mogak.service;

import kr.mogak.dto.response.PostResponse;
import kr.mogak.entity.Post;
import kr.mogak.enums.Yn;
import kr.mogak.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private PostRepository postRepository;
    public List<PostResponse> getPostList() {
        List<Post> posts = postRepository.findByDeletedYn(Yn.Y);
        List<PostResponse> postResponses = new ArrayList<>();

        // TODO posts postresponses에 매핑
        return postResponses;
    }
}
