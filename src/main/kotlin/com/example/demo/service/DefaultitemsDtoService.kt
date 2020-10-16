package com.example.demo.service


import com.example.demo.dtoService.ItemDtoService
import com.example.demo.domain.CreateItemRequest
import com.example.demo.domain.UpdateItemRequest
import com.example.demo.model.Items
import com.example.demo.repo.ItemsRepository
import com.example.demo.dto.items.CreateItemsDto
import com.example.demo.dto.items.ItemsDto
import com.example.demo.dto.items.UpdateItemsDto
import com.example.demo.impl.ItemsRequestMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DefaultItemsService(

        private val itemRequestMapper: ItemsRequestMapper,
        private val itemsService: ItemsService,
        private val itemsDtoMapper: ItemsRequestMapper,
        private val itemsRepository: ItemsRepository
) : ItemDtoService {
  override fun delete(id: Long) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun findBy(id: Long): Items = itemsRepository.getOne(id)


  @Transactional
  override fun create(createItemsDto: CreateItemsDto): ItemsDto {
    val createItemRequest: CreateItemRequest =
      itemRequestMapper.convertToCreateItemRequest(createItemsDto)

    val createItem: Items = itemsService.create(createItemRequest)

    return itemsDtoMapper.convertToDto(createItem)

  }


  @Transactional
  override fun update(updateItemsDto: UpdateItemsDto, id: Long): ItemsDto {
    val updateItemRequest: UpdateItemRequest =
      itemRequestMapper.convertToDtoUpdateItemRequest(updateItemsDto)

    val updateItem: Items = itemsService.update(updateItemRequest, id)

    return itemsDtoMapper.convertToDto(updateItem)
  }

//
//  @Transactional
//  override fun update(updateItemsDto: UpdateItemsDto, id: Long): ItemsDto {
//    val items = CreateItemRequest(
//      name = updateItemsDto.name,
//      amount = updateItemsDto.amount,
//      categoryId = updateItemsDto.categoryId,
//      price = updateItemsDto.price,
//      description = updateItemsDto.description,
//      email = updateItemsDto.email
//    )
//
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//  @Transactional(readOnly = true)
//  override fun findById(id: Long): ItemsDto {
//    val items = itemsRepository.getOne(id)
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//
//  @Transactional(readOnly = true)
//  override fun findByName(name: String): ItemsDto {
//    val items = itemsRepository.findByName(name)
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//  @Transactional(readOnly = true)
//  override fun findByAmount(amount: Int): ItemsDto {
//    val items = itemsRepository.findByAmount(amount)
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//  @Transactional(readOnly = true)
//  override fun findByPrice(price: BigDecimal): ItemsDto {
//    val items = itemsRepository.findByPrice(price)
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//  @Transactional(readOnly = true)
//  override fun findByDescription(description: String): ItemsDto {
//    val items = itemsRepository.findByDescription(description)
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//  @Transactional(readOnly = true)
//  override fun findByCategory(categoryId: String): ItemsDto {
//    val items = itemsRepository.findByCategory(categoryId)
//    return ItemsDto(
//      name = items.name,
//      amount = items.amount,
//      categoryId = items.categoryId,
//      price = items.price,
//      description = items.description,
//      isActive = items.is_active,
//      id = items.id!!
//    )
//  }
//
//  @Transactional()
//  override fun delete(id: Long) {
//    val items = itemsRepository.getOne(id)
//    itemsRepository.delete(items)
//  }


}
