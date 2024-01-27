package com.example.students.mappery;


import com.example.students.data.Friends;
import com.example.students.data.Student;
import com.example.students.resource.CreateFriend;
import com.example.students.resource.CreateStudent;
import com.example.students.resource.FriendDto;
import com.example.students.resource.StudentDto;
import org.springframework.stereotype.Component;


@Component
public class FriendMapper {

    public FriendDto toDto(Friends friends) {
        return new FriendDto(
                friends.getId(),
                friends.getName(),
                friends.getEmail()
        );
    }

    public Friends toEntity(CreateFriend createFriend) {
        return new Friends(createFriend.getId() ,createFriend.getName(), createFriend.getEmail());
    }
}
