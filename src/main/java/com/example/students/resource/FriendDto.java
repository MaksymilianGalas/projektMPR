package com.example.students.resource;

import com.example.students.data.StudentUnit;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class FriendDto {

    @NonNull
    private UUID id;
    @NotBlank
    private String name;
    @Email
    private String email;
    private String phoneNumber;
    private String address;

    public FriendDto(UUID id, String name, String email) {
    }
}
