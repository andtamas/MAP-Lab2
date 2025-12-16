package com.example.Library.repository;

import com.example.Library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    @Query("SELECT m FROM Member m LEFT JOIN FETCH m.library")
    List<Member> findAllWithLibrary();

    @Query("SELECT m FROM Member m LEFT JOIN FETCH m.library " +
            "WHERE (:id IS NULL OR m.id = :id) " +
            "AND (:name IS NULL OR lower(m.name) LIKE lower(concat('%', :name, '%'))) " +
            "AND (:libraryId IS NULL OR m.library.id = :libraryId)")
    List<Member> findFiltered(Long id, String name, Long libraryId);
}