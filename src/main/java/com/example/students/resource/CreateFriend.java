package com.example.students.resource;


import com.example.students.data.StudentUnit;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateFriend {


    private UUID id;
    @NotBlank
    private String name;
    private String email;
}
