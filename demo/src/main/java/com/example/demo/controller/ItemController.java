package com.example.demo.controller;



import com.example.demo.dto.request.ItemRequestDTO;
import com.example.demo.dto.response.ItemResponseDTO;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import com.example.demo.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/create")
    public ResponseEntity<StandardResponse> createItem( @RequestBody ItemRequestDTO itemRequestDTO){

        ItemResponseDTO itemResponseDTO = itemService.create(itemRequestDTO);
        return new ResponseEntity<>(
                new StandardResponse(201L,"Created.",itemResponseDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/readAll")
    public ResponseEntity<StandardResponse> readAllItem(){
        List<ItemResponseDTO> itemResponseDTOS = itemService.readAll();
        return new ResponseEntity<>(
                new StandardResponse(200L,"Succesful.",itemResponseDTOS),
                HttpStatus.OK
        );
    }

}
