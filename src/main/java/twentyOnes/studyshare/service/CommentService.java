package twentyOnes.studyshare.service;

import org.springframework.stereotype.Controller;
import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.dto.comment.CommentDto;

import java.util.List;

@Controller
public interface CommentService {
    void addcomment (CommentDto commentDto);
    void deletecomment(Long commentDto);
    void updatecomment(Long id, CommentDto commentDto);
    List<Comment> selectcomment(Long postid);
}
