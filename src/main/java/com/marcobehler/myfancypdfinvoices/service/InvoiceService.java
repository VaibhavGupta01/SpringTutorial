package com.marcobehler.myfancypdfinvoices.service;

import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class InvoiceService {
    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public InvoiceService(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;
    public List<Invoice> findAll(){
        return invoices;
    }

    @PostConstruct
    public void Init(){
        System.out.println("Init invoked...");
    }
    @PreDestroy
    public void Close(){
        System.out.println("Started Shutting down...");
    }
    public Invoice create(String userId, Integer amount) {
        User user = userService.findById(userId);
        if (user == null) {
            throw new IllegalStateException();
        }

        Invoice invoice=  new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        invoices.add(invoice);
        return invoice;
    }
}