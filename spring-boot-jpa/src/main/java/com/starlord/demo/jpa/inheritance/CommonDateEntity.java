package com.starlord.demo.jpa.inheritance;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class CommonDateEntity {

    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

}
