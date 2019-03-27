package io.codelex.p2p.controller;

import io.codelex.p2p.api.AuthRequest;
import io.codelex.p2p.model.Customer;
import io.codelex.p2p.repository.RepositoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class CustomerController {
    private RepositoryService repositoryService;
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();

    public CustomerController(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @PutMapping("/register")
    public ResponseEntity register(@Valid @RequestBody AuthRequest request) {
        if (!repositoryService.isCustomerRegistered(request.getEmail())) {
            Customer customer = repositoryService.saveCustomer(request.getEmail(), request.getPassword());
            authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
            Authentication authentication = new UsernamePasswordAuthenticationToken(customer.getCustomerId(), null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/sign-in")
    public ResponseEntity signIn(@Valid @RequestBody AuthRequest authRequest) {
        Optional<Customer> customer = repositoryService.findByEmail(authRequest.getEmail());
        if(customer.isPresent()){
         if(repositoryService.isPasswordMatching(customer.get(),authRequest.getPassword())){
             authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
             Authentication authentication = new UsernamePasswordAuthenticationToken(customer.get().getCustomerId(), null, authorities);
             SecurityContextHolder.getContext().setAuthentication(authentication);
             return new ResponseEntity(HttpStatus.OK);
         }
            return new ResponseEntity(HttpStatus.CONFLICT);

        }
        return new ResponseEntity(HttpStatus.CONFLICT);

    }
    @PostMapping("/sign-out")
    public void signOut(){
        SecurityContextHolder.getContext().setAuthentication(null);

    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @PostMapping("/loans/{id}")
    public void buyLoan(Principal principal, @PathVariable Long id) {
        System.out.println(id);
        System.out.println(principal.getName());
    }

}
