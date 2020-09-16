package com.cartrapido.main.domain.repository;

import com.cartrapido.main.domain.entity.Member;
import com.cartrapido.main.domain.entity.QnA;
import com.cartrapido.main.web.dto.QnADTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface QnARepository extends JpaRepository<QnA, Integer> {

    Page<QnA> findAllByEmail(String email, Pageable pageable);
    QnA findAllBySeq(int seq);
    void deleteByEmail(String email);

    @Query("select max(q.seq) from QnA q")
    int findByMaxId();

    Page<QnA> findByTitleContaining(String searchValue, Pageable pageable);
    Page<QnA> findByNameContaining(String searchValue, Pageable pageable);



}
