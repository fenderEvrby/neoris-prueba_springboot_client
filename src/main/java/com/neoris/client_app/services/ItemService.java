package com.neoris.client_app.services;


import com.neoris.client_app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import com.neoris.client_app.models.Item;

@Component
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item crearItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> obtenerItems(){
        return  itemRepository.findAll();
    }

    public Item obtenerItemPorId(String nombre){
        Optional<Item> optionalItem = itemRepository.findById(nombre);
        return optionalItem.get();
    }
}
