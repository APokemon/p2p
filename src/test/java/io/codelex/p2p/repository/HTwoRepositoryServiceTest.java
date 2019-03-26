package io.codelex.p2p.repository;

import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.model.Customer;
import io.codelex.p2p.model.LendingCompany;
import io.codelex.p2p.model.Loan;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HTwoRepositoryServiceTest {
    
    CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);
    LoanRepository loanRepository = Mockito.mock(LoanRepository.class);
    LendingCompanyRepository lendingCompanyRepository = Mockito.mock(LendingCompanyRepository.class);
    RepositoryService tripRecordRepository = new RepositoryService(customerRepository,loanRepository,lendingCompanyRepository);
    
    @Test
    void should_save_Loan(){
        //given
        AddLoanRequest addLoanRequest = new AddLoanRequest(
                new BigDecimal(1000),
                new BigDecimal(1200),
                LocalDate.of(2019,4,1),
                LocalDate.of(2019,4,1).plusDays(14),
                createCustomer(),
                createLendingCompany()
        );
        
    }
    
    Customer createCustomer(){
        Set<Loan> loans= new HashSet<>();
        return new Customer(
                1L,
                "Andris",
                "Kivics",
                loans
        );
    }
    LendingCompany createLendingCompany(){
        Set<Loan> loans= new HashSet<>();
        
        return new LendingCompany(
                "Onzaem",
                loans,
                new BigDecimal(0)
        );
    }


}