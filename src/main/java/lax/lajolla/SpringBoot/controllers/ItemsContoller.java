package lax.lajolla.SpringBoot.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lax.lajolla.SpringBoot.items.Palabra;
import lax.lajolla.SpringBoot.services.ItemsServices;

@RestController
public class ItemsContoller {
	@Autowired
	private ItemsServices itemsServices;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON, path = "/all")
	List<Palabra> getAlllItems() {

		return itemsServices.getAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, path = "/create")
	void createNewItem(Palabra palabra) {
		itemsServices.createNew(palabra);

	}
}
