package com.marcobehler.myfancypdfinvoices.web;

import com.marcobehler.myfancypdfinvoices.dto.InvoiceDto;
import com.marcobehler.myfancypdfinvoices.model.Invoice;
import com.marcobehler.myfancypdfinvoices.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/")
    public String getIndexPage(){
        return "Hello World";
    }

    @GetMapping("/invoices")
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
