package br.com.example.bitcoinprice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {
    private static final String COINGECKO_API_URL =
            "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd&include_24hr_change=true";

    public double getBitcoinPrice() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(COINGECKO_API_URL, String.class);

        // Extrai o preço do JSON (exemplo: {"bitcoin":{"usd":50000.0,"usd_24h_change":2.5}})
        return Double.parseDouble(
                response.split("usd\":")[1].split(",")[0]
        );
    }
}
