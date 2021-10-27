package twentyOnes.studyshare.domain.childcomment;

import twentyOnes.studyshare.domain.comment.Comment;
import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class ChildComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_comment_id")
    private Long childCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment CommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "childcom_text")
    private String childComText;

    private LocalDateTime created;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(mappedBy = "childComment", cascade = CascadeType.ALL)
    List<ChildCommentLike> childCommentLikeList = new ArrayList<>();

}
