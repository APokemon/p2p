package io.codelex.p2p.repository;

import io.codelex.p2p.model.LendingCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingCompanyRepository extends JpaRepository<LendingCompany,Long> {
}
