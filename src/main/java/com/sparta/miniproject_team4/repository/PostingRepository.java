package com.sparta.miniproject_team4.repository;

import com.sparta.miniproject_team4.model.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostingRepository extends JpaRepository<Posting, Long> {
    List<Posting> findAllByEmail(String email);
    List<Posting> findAllByOrderByCreatedAtDesc();

}
