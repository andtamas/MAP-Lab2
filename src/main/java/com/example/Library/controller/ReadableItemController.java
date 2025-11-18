package com.example.Library.controller;

import com.example.Library.model.ReadableItem;
import com.example.Library.service.ReadableItemService;
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

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        ReadableItem item = readableItemService.getById(id);
        model.addAttribute("item", item);
        return "item/form";
    }

    @PostMapping("/{id}/edit")
    public String updateItem(@PathVariable String id, @ModelAttribute ReadableItem item) {
        item.setId(id);
        readableItemService.update(item);
        return "redirect:/items";
    }

    @GetMapping("/{id}/detail")
    public String viewItemDetails(@PathVariable String id, Model model) {
        ReadableItem item = readableItemService.getById(id);
        model.addAttribute("item", item);
        return "item/detail";
    }
    @PostMapping("/{id}/delete")
    public String deleteItem(@PathVariable String id) {
        readableItemService.delete(id);
        return "redirect:/items";
    }
}
