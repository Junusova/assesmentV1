package com.example.demo.service

import com.example.demo.model.Category
import com.example.demo.model.Items
import com.example.demo.domain.CreateCategoryRequest
import com.example.demo.domain.UpdateCategoryRequest
import com.example.demo.repo.CategoryRepository
import com.example.demo.repo.ItemsRepository

import org.springframework.stereotype.Service

interface CategoryService {
  fun create(createCategoryRequest: CreateCategoryRequest): Category
  fun update(updateCategoryRequest: UpdateCategoryRequest, id: Long): Category
  fun getCategoryById(id: Long): Category
  fun getItemById(id: Long): Items
  fun save(category: Category): Category
}

@Service
class CategoryServiceImpl(
        private val categoryRepository: CategoryRepository,
        private val itemsRepository: ItemsRepository

) : CategoryService {
  override fun save(category: Category): Category = categoryRepository.save(category)

  override fun update(updateCategoryRequest: UpdateCategoryRequest, id: Long): Category {
    val updateCategory = getCategoryById(id)

    updateCategory.apply {
      name = updateCategoryRequest.name
      description = updateCategoryRequest.description
      amount = updateCategoryRequest.amount

    }
    return categoryRepository.save(updateCategory)
  }


  override fun create(createCategoryRequest: CreateCategoryRequest): Category {
    val category = Category(
      name = createCategoryRequest.name,
      amount = createCategoryRequest.amount,
      description = createCategoryRequest.description,
      items = listOf()

    )
    return categoryRepository.save(category)
  }

  override fun getCategoryById(id: Long): Category = categoryRepository.getOne(id)
  override fun getItemById(id: Long): Items = itemsRepository.getOne(id)
}
