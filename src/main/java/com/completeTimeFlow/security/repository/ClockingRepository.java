package com.completeTimeFlow.security.repository;

import com.completeTimeFlow.security.server.domain.Clocking;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ClockingRepository extends JpaRepository<Clocking, Long> {

}
