package com.example.demo.dtoService


import com.example.demo.dto.items.CreateItemsDto
import com.example.demo.dto.items.ItemsDto
import com.example.demo.dto.items.UpdateItemsDto
import com.example.demo.model.Items

interface ItemDtoService {
  fun create(createItemsDto: CreateItemsDto): ItemsDto
  fun update(updateItemsDto: UpdateItemsDto, id: Long): ItemsDto
  fun findBy(id: Long): Items
  fun delete(id: Long)
}