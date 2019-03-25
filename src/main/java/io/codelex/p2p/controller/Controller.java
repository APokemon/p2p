package io.codelex.p2p.controller;
import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.model.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Service service;
    private RequestValidator validator= new RequestValidator();

    public Controller(Service service) {
        this.service = service;
    }
    @PutMapping("/addLoan")
    public ResponseEntity<Loan> addLoan(@RequestBody AddLoanRequest request) {
        if(validator.IsAddLoanRequestValid(request)) {
            return new ResponseEntity<>(service.addLoan(request), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    
}
