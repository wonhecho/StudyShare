package twentyOnes.studyshare.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.domain.posts.Post;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findBypost(Post post);
}
