package com.neoris.client_app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoris.client_app.utils.Utilidades;

@RestController
@RequestMapping("api/encriptar")
public class EncriptacionController {
    @Value("${algoritmo}")
    private String algoritmo;
    @Value("${cifrado}")
    private String cifrado;
    @Value("${llave-publica}")
    private String llavePublica;
    @Value("${vector-inicializacion}")
    private String vectorInicialiacion;

    @GetMapping("{texto}")
    public Object encriptarTexto(@PathVariable("texto") String texto) throws Exception {
        try {
            //Cifra el texto que viene como parámetro
            String textoEncriptado = Utilidades.encriptar(cifrado, algoritmo, llavePublica, vectorInicialiacion,texto);
            return textoEncriptado;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
