package br.com.example.bitcoinprice.controller;

import br.com.example.bitcoinprice.service.CryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CryptoController {
    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/")
    public String getBitcoinPrice(Model model) {
        double price = cryptoService.getBitcoinPrice();
        model.addAttribute("bitcoinPrice", String.format("$ %.2f", price));
        return "index";
    }
}