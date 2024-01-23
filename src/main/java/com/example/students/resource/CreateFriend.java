package com.example.students.resource;


import com.example.students.data.StudentUnit;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateFriend {

    @NotBlank
    private String name;
    private String email;
}
