package br.com.example.bitcoinprice.controller;

import br.com.example.bitcoinprice.service.CryptoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CryptoControllerTest {

    private CryptoService cryptoService;
    private CryptoController cryptoController;

    @BeforeEach
    void setUp() {
        cryptoService = mock(CryptoService.class);
        cryptoController = new CryptoController(cryptoService);
    }

    @Test
    void testGetBitcoinPrice_ReturnsIndexViewAndAddsModelAttributes() {
        // Dados mockados
        Map<String, Object> mockData = new HashMap<>();
        mockData.put("price", 61234.56);
        mockData.put("change", -1.23);

        when(cryptoService.getBitcoinPriceWithChange()).thenReturn(mockData);

        // Model mockado
        Model model = mock(Model.class);

        // Chamada ao controller
        String viewName = cryptoController.getBitcoinPrice(model);

        // Verificações
        assertEquals("index", viewName);
        verify(model).addAttribute("bitcoinPrice", "$ 61234.56");
        verify(model).addAttribute("priceChange", -1.23);
    }
}
