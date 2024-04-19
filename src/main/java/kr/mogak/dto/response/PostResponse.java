package kr.mogak.dto.response;

import kr.mogak.entity.Member;
import kr.mogak.entity.Post;
import kr.mogak.enums.Category;
import kr.mogak.enums.Yn;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class PostResponse {

    private Long id;
    private Member author;
    private Category category;
    private String title;
    private LocalDateTime createdAt;
    private Yn updatedYn;
    private LocalDateTime updatedAt;
    private Yn deletedYn;
    private LocalDateTime deletedAt;
    private String content;

    @Builder
    public PostResponse(Post post) {
        this.id = post.getId();
    }
}
