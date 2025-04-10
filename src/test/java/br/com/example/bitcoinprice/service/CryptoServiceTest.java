package br.com.example.bitcoinprice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CryptoServiceTest {

    private CryptoService cryptoService;
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = Mockito.mock(RestTemplate.class);
        cryptoService = new CryptoService(restTemplate);
    }

    @Test
    void testGetBitcoinPriceWithChange() {
        // Simula resposta do CoinGecko
        String fakeJson = "{\"bitcoin\":{\"usd\":62000.0,\"usd_24h_change\":-1.23}}";

        // Configura o mock
        when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(fakeJson);

        Map<String, Object> result = cryptoService.getBitcoinPriceWithChange();

        assertEquals(62000.0, (double) result.get("price"));
        assertEquals(-1.23, (double) result.get("change"));
    }

    @Test
    void testGetBitcoinPrice() {
        String fakeJson = "{\"bitcoin\":{\"usd\":58000.0,\"usd_24h_change\":3.14}}";

        when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(fakeJson);

        double price = cryptoService.getBitcoinPrice();
        assertEquals(58000.0, price);
    }
}
