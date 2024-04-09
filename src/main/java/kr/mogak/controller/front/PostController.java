package kr.mogak.controller.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class PostController {

    @GetMapping("/board")
    public String boardPage() {
        return "views/board/main";
    }

}
