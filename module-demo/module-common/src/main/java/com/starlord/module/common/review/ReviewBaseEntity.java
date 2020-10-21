package com.starlord.module.common.review;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class ReviewBaseEntity {

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

}
