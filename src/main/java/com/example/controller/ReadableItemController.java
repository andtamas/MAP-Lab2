package com.example.controller;

import com.example.model.ReadableItem;
import com.example.service.ReadableItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ReadableItemController {

    private final ReadableItemService readableItemService;

    public ReadableItemController(ReadableItemService readableItemService) {
        this.readableItemService = readableItemService;
    }

    @GetMapping
    public String listItems(Model model) {
        model.addAttribute("items", readableItemService.getAll());
        return "item/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("item", new ReadableItem());
        return "item/form";
    }

    @PostMapping
    public String createItem(@ModelAttribute ReadableItem item) {
        readableItemService.add(item);
        return "redirect:/items";
    }

    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable String id) {
        readableItemService.delete(id);
        return "redirect:/items";
    }
}
