package com.example.schedulecomment.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schedulecomment.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
