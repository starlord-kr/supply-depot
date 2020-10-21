package com.starlord.module.common.review;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "MOVIE_ITEM2")
@DiscriminatorValue("MOVIE_ITEM2")
public class MovieItem2 extends  MovieReview {

    @Builder
    public MovieItem2(Long testId, String name, String email) {
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
