package io.codelex.p2p.repository;

import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.model.Customer;
import io.codelex.p2p.model.LendingCompany;
import io.codelex.p2p.model.Loan;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HTwoRepositoryServiceTest {
    
    CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    LoanRepository loanRepository = Mockito.mock(LoanRepository.class);
    LendingCompanyRepository lendingCompanyRepository = Mockito.mock(LendingCompanyRepository.class);
    PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
    RepositoryService tripRecordRepository = new RepositoryService(customerRepository,loanRepository,lendingCompanyRepository,passwordEncoder);



}