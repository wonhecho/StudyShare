package twentyOnes.studyshare.domain.todaycomment;

import twentyOnes.studyshare.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class TodayComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "today_comment_id")
    private Long todayCommentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "today_comment_title")
    private String todayCommentTitle;

    @Column(name = "today_comment_text")
    private String todayCommentText;

    @Column(name = "today_datetime", columnDefinition = "TIMESTAMP")
    private LocalDate localDate;

}
