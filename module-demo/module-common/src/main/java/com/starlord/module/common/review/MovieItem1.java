package com.starlord.module.common.review;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "MOVIE_ITEM1")
@DiscriminatorValue("MOVIE_ITEM1")
public class MovieItem1 extends  MovieReview {

    @Builder
    public MovieItem1(Long testId, String name, String email) {
        super(testId, name, email);
    }

    @OneToOne
    @JoinColumn(name = "MOVIE_ITEM1", referencedColumnName = "ID")
    private MovieReview movieReview;

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String itemName;

}
