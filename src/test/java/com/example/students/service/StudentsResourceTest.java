package com.example.students.service;

import com.example.students.data.FriendsRepository;
import com.example.students.resource.FriendDto;
import com.example.students.resource.FriendsResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentsResourceTest {

    @InjectMocks
    private FriendsResource friendsResource;

    @Mock
    private FriendsRepository friendsRepository;

    @Mock
    private FriendsService friendsService;




    @Test
    public void testFindFriendsByStudentId() {
        UUID studentId = UUID.randomUUID();
        List<FriendDto> friendsList = new ArrayList<>();
        when(friendsService.findFriendsDtoById(studentId)).thenReturn(friendsList);

        List<FriendDto> result = friendsResource.findFriendsByStudentId(studentId);

        assertEquals(friendsList, result);
    }
}