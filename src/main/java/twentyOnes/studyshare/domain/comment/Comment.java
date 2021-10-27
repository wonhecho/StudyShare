package twentyOnes.studyshare.domain.comment;

import lombok.Builder;
import twentyOnes.studyshare.domain.posts.Post;
import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "comment_text")
    private String commentText;

    private LocalDateTime created;

    @Column(name = "like_count")
    private int likeCount;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    private List<CommentLike> commentLikeList = new ArrayList<>();

    @Builder
    public Comment (Post post, Member member, String commentText, LocalDateTime created, Integer likeCount)
    {
        this.post = post;
        this.member = member;
        this.commentText = commentText;
        this.created = created;
        this.likeCount = likeCount;
    }
    public Comment updatecomment(String comment)
    {
        this.commentText = comment;
        return this;
    }
}
