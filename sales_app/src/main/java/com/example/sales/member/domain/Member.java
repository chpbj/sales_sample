package com.example.sales.member.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017-06-11.
 */
@Entity
public class Member implements Serializable {
    private static final long serialVersionUID = -1425310449812169333L;

    @EmbeddedId
    private MemberId id;
    private String name;

    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dt;

    protected Member() {

    }

    public Member(MemberId id, String name) {
        this.id = id;
        this.name = name;
        this.dt = new Date();
    }

    public MemberId getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getDt() {
        return this.dt;
    }
}
