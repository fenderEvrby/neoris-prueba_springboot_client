package com.neoris.client_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.neoris.client_app.models.Item;
import com.neoris.client_app.services.ItemService;

@RestController
@RequestMapping("api/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public Item crearItem(@RequestBody Item item){
        return itemService.crearItem(item);
    }

    @GetMapping
    public List<Item> obtenerItems(){
        return itemService.obtenerItems();
    }

    @GetMapping("{nombre}")
    public Item obtenerItemPorId(@PathVariable("nombre") String nombre){
        return  itemService.obtenerItemPorId((nombre));
    }
}
