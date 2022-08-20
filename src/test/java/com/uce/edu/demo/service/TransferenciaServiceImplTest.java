package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.modelo.Transferencia;

@SpringBootTest
@Rollback(true)
@Transactional
public class TransferenciaServiceImplTest {

	private static Logger LOG = Logger.getLogger(TransferenciaServiceImplTest.class);

    @Autowired
    private ITransferenciaService transferenciaService;

    @Test
    void testRealizarTransferencia() {
        // this.transferenciaService.realizarTransferenciaFachada("22342", "83828", new BigDecimal("1"));
        Transferencia t = this.transferenciaService.buscar(5);
        BigDecimal ivaEncontrado = t.getMonto().divide(new BigDecimal(12));
        LOG.info(ivaEncontrado);
        BigDecimal ivaEsperado = new BigDecimal("1.00");
        LOG.info(ivaEsperado);
        assertEquals(ivaEncontrado ,ivaEsperado);
    }
}