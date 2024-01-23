package com.example.students.data;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.UUID;
@Setter
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Friends {

    @Id
    @GeneratedValue
    private UUID id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String email;
    private String phoneNumber;
    private String address;

    @ManyToOne
    private Assignment assignment;
    public Friends(String name, String email) {
        this.name = name;
        this.email = email;
    }


}