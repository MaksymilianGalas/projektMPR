package com.example.students.resource;


import com.example.students.data.Assignment;
import com.example.students.data.Friends;
import com.example.students.service.FriendsService;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/fri")
@RequiredArgsConstructor
public class FriendsResource {

    private final StudentService studentService;
    private final FriendsService friendsService;

    @GetMapping("/friends/{id}")
    public List<FriendDto> findFriendsByStudentId(@RequestParam UUID id) {
        return friendsService.findFriendsDtoById(id);
    }

    @GetMapping("/assignments/{id}")
    public List<Friends> findAssignmentsByStudentId(@RequestParam Assignment assignment) {
        return friendsService.findAssignmentsByStudentId(assignment);
    }

    @DeleteMapping("/friends/{name}")
    public void deleteFriendById(@PathVariable String name) {
        friendsService.deleteFriendByName(name);
    }

    @PostMapping("/friends")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFriend(@RequestBody @Validated CreateFriend friend) {
        studentService.addFriend(friend);
    }
}
