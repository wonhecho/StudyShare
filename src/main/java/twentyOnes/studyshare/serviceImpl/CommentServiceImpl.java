package twentyOnes.studyshare.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.domain.posts.Post;
import twentyOnes.studyshare.domain.posts.PostRepository;
import twentyOnes.studyshare.dto.comment.CommentDto;
import twentyOnes.studyshare.domain.comment.CommentRepository;
import twentyOnes.studyshare.service.CommentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    @Override
    public void addcomment(CommentDto commentdto) {
        Comment comment = Comment.builder().post(commentdto.getPostid())
                .member(commentdto.getMemberid()).commentText(commentdto.getCommentText())
                .created(LocalDateTime.now()).likeCount(0).build();
        commentRepository.save(comment);
    }

    @Override
    public void deletecomment(Long commentDto) {
        commentRepository.deleteById(commentDto);
    }

    @Override
    public void updatecomment(Long id, CommentDto commentDto) {
        Optional<Comment> comment = commentRepository.findById(id);
        comment.ifPresent(selectComment -> {
            selectComment.updatecomment(commentDto.getCommentText());
        });

    }

    @Override
    public List<Comment> selectcomment(Long postid) {
        Post post = postRepository.getById(postid);
        List<Comment> commentList = commentRepository.findBypost(post);
        return commentList;

    }
}
