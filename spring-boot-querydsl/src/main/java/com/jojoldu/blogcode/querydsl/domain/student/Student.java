package com.jojoldu.blogcode.querydsl.domain.student;

/**
 * Created by jojoldu@gmail.com on 2019-01-11
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

import com.jojoldu.blogcode.querydsl.domain.academy.Academy;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int academyNo;

    @ManyToOne
    @JoinColumn(name = "academy_id", foreignKey = @ForeignKey(name = "fk_student_academy"))
    private Academy academy;

    @Builder
    public Student(String name, int academyNo) {
        this.name = name;
        this.academyNo = academyNo;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
}
