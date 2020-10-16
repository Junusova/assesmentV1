package com.example.demo.impl

import com.example.demo.domain.CreateItemRequest
import com.example.demo.domain.UpdateItemRequest
import com.example.demo.dto.items.CreateItemsDto
import com.example.demo.dto.items.ItemsDto
import com.example.demo.dto.items.UpdateItemsDto
import com.example.demo.model.Category
import com.example.demo.model.Items
import com.example.demo.service.CategoryService
import com.example.demo.service.ItemsService
import org.springframework.stereotype.Service

interface ItemsRequestMapper {
  fun convertToDto(items: Items): ItemsDto
  fun convertToCreateItemRequest(createItemsDto: CreateItemsDto): CreateItemRequest
  fun convertToDtoUpdateItemRequest(updateItemsDto: UpdateItemsDto): UpdateItemRequest
}

@Service
class ItemEndpointImpl(
        private val itemService: ItemsService,
        private val categoryService: CategoryService
) : ItemsRequestMapper {


  override fun convertToDtoUpdateItemRequest(updateItemsDto: UpdateItemsDto): UpdateItemRequest {
    val category: Category = categoryService.getCategoryById(updateItemsDto.categoryId)

    return UpdateItemRequest(
      name = updateItemsDto.name,
      email = updateItemsDto.email,
      amount = updateItemsDto.amount,
      price = updateItemsDto.price,
      description = updateItemsDto.description,
      category = category
    )
  }

  override fun convertToCreateItemRequest(createItemsDto: CreateItemsDto): CreateItemRequest {
    val category = itemService.getById(createItemsDto.categoryId)
    return CreateItemRequest(
      email = createItemsDto.email,
      name = createItemsDto.name,
      amount = createItemsDto.amount,
      price = createItemsDto.price,
      description = createItemsDto.description,
      category = category,
      isActive = true
    )
  }

  override fun convertToDto(items: Items): ItemsDto {
    return ItemsDto(
      id = items.id,
      name = items.name!!,
      description = items.description!!,
      amount = items.amount!!,
      isActive = true,
      price = items.price!!
    )
  }
}