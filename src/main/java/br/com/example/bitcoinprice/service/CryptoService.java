package br.com.example.bitcoinprice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class CryptoService {
    private static final String COINGECKO_API_URL =
            "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd&include_24hr_change=true";

    private final RestTemplate restTemplate;

    public CryptoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método existente (mantido para compatibilidade)
    public double getBitcoinPrice() {
        Map<String, Object> data = getBitcoinPriceWithChange();
        return (double) data.get("price");
    }

    // Novo método para pegar preço + variação
    public Map<String, Object> getBitcoinPriceWithChange() {
        String response = restTemplate.getForObject(COINGECKO_API_URL, String.class);

        // Extrai preço e variação do JSON
        String[] parts = response.split("usd\":|,\"usd_24h_change\":|}}");
        double price = Double.parseDouble(parts[1]);
        double change = Double.parseDouble(parts[2]);

        Map<String, Object> result = new HashMap<>();
        result.put("price", price);
        result.put("change", change);
        return result;
    }
}