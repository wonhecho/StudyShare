package twentyOnes.studyshare.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import twentyOnes.studyshare.domain.LikeOrNot;
import twentyOnes.studyshare.domain.member.Member;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class CommentLike{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    @Enumerated(EnumType.STRING)
    private LikeOrNot likeOrNot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public CommentLike(LikeOrNot likeOrNot, Comment comment, Member member)
    {
        this.likeOrNot = likeOrNot;
        this.comment = comment;
        this.member = member;
    }

}
