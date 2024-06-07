package com.neoris.client_app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/pokemon")
public class PokemonController {
    @Value("${pokemon.base-url}")
    private String serviceUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("{nombre}")
    public Object obtenerPokemonPorNombre(@PathVariable("nombre") String nombre) throws Exception {
        try {
            String url = serviceUrl + nombre;
            //Retorna un objeto JSON con los datos del pokémon proporcionado
            return restTemplate.getForObject(url, Object.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
