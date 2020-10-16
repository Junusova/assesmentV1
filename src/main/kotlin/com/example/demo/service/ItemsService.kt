package com.example.demo.service

import com.example.demo.repo.CategoryRepository
import com.example.demo.repo.ItemsRepository
import com.example.demo.domain.CreateItemRequest
import com.example.demo.domain.UpdateItemRequest
import com.example.demo.model.Category
import com.example.demo.model.Items
import org.springframework.stereotype.Service

interface ItemsService {
  fun create(createItemRequest: CreateItemRequest): Items
  fun update(updateItemRequest: UpdateItemRequest, id: Long): Items
  fun getById(id: Long): Category
  fun getItemById(id: Long): Items
  fun save(items: Items): Items
}

@Service
class ItemServiceImpl(
        private val categoryRepository: CategoryRepository,
        private val itemsRepository: ItemsRepository
) : ItemsService {

  override fun save(items: Items): Items = itemsRepository.save(items)

  override fun update(updateItemRequest: UpdateItemRequest, id: Long): Items {
    val updateIem = getItemById(id)

    updateIem.apply {
      category = updateItemRequest.category
      name = updateItemRequest.name
      amount = updateItemRequest.amount
      price = updateItemRequest.price
      description = updateItemRequest.description
    }
    return itemsRepository.save(updateIem)
  }


  override fun create(createItemRequest: CreateItemRequest): Items {
    val item = Items(
      category = createItemRequest.category,
      name = createItemRequest.name,
      amount = createItemRequest.amount,
      price = createItemRequest.price,
      description = createItemRequest.description,
      isActive = createItemRequest.isActive
    )

    return itemsRepository.save(item)
  }

  override fun getById(id: Long): Category = categoryRepository.getOne(id)

  override fun getItemById(id: Long): Items = itemsRepository.getOne(id)
}


