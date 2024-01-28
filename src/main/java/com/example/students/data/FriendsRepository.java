package com.example.students.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FriendsRepository extends JpaRepository<Friends, UUID> {


    List<Friends> findAssignmentsByAssignment(Assignment assignment);

    List<Friends> findFriendsById(UUID studentId);

    List<Friends> findFriendsByName(String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Friends f WHERE f.name = :name")
    void deleteFriendsByName(@Param("name") String name);
}
