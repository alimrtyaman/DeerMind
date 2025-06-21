package com.aliyaman.deermind.repository;

import com.aliyaman.deermind.entity.Note;
import com.aliyaman.deermind.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Collection<Object> findByUser(User user);
}
