package com.neoris.client_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neoris.client_app.models.Item;

public interface ItemRepository extends JpaRepository<Item, String> {
}
