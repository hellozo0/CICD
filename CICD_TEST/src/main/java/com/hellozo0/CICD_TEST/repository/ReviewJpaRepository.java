package com.hellozo0.CICD_TEST.repository;

import com.hellozo0.CICD_TEST.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepository<Review, Long> {

}
