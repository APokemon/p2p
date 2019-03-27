package io.codelex.p2p.controller;
import io.codelex.p2p.api.AddLoanRequest;
import io.codelex.p2p.model.Loan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
    private Service service;
    private RequestValidator validator;

    public Controller(Service service, RequestValidator validator) {
        this.service = service;
        this.validator = validator;
    }
    @PutMapping("/addLoan")
    public ResponseEntity<Loan> addLoan(@RequestBody AddLoanRequest request) {
        if(validator.isAddLoanRequestValid(request)) {
            return new ResponseEntity<>(service.addLoan(request), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @RequestMapping("/loans")
    public String getLoans(Model model){
        model.addAttribute("loans",service.findAllLoans());
        return "loans";
    }
}
