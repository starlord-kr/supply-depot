package com.starlord.module.common.review;

import com.starlord.module.common.student.Student;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "MOVIE_REVIEW")
@DiscriminatorColumn(name = "MOVIE_REVIEW_TYPE")
public class MovieReview extends ReviewBaseEntity {

    public MovieReview(Long testTargetId, String name, String email) {
        this.testTargetId = testTargetId;
        this.name = name;
        this.email = email;
    }

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    private Student student;

//    @OneToOne
//    @JoinColumn(name = "TEST_ID", referencedColumnName = "ID")
    @Column
    private Long testTargetId;

    @Column
    private String name;
    @Column
    private String email;

}
