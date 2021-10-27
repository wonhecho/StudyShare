package twentyOnes.studyshare.dto.comment;

import lombok.Data;
import twentyOnes.studyshare.domain.member.Member;
import twentyOnes.studyshare.domain.posts.Post;

@Data
public class CommentDto {
    Post postid;
    Member memberid;
    String commentText;
}
