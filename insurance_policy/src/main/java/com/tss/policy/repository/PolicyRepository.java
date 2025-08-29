package com.tss.policy.repository;

import com.tss.policy.entity.Policy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    Optional<Policy> findByPolicyNumber(String policyNumber);

    void deleteByPolicyNumber(String policyNumber);

    Page<Policy> findByHolderName(String holderName, Pageable pageable);

    Page<Policy> findByEndDateBefore(LocalDate date, Pageable pageable);
}
