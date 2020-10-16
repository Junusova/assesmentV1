package com.example.demo.impl


import com.example.demo.domain.CreateCategoryRequest
import com.example.demo.domain.UpdateCategoryRequest
import com.example.demo.dto.category.CategoryDto
import com.example.demo.dto.category.CreateCategoryDto
import com.example.demo.dto.category.UpdateCategoryDto
import com.example.demo.model.Category
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface CategoriesRequestMapper {
  fun convertToCreateCategoryRequest(createCategoryDto: CreateCategoryDto): CreateCategoryRequest
  fun convertToUpdateCategoryRequest(updateCategoryDto: UpdateCategoryDto): UpdateCategoryRequest
  fun convertToDto(category: Category): CategoryDto
}

@Service
class CategoryEndpointImpl : CategoriesRequestMapper {
  override fun convertToDto(category: Category): CategoryDto {
    return CategoryDto(
      name = category.name!!,
      description = category.description!!,
      amount = category.amount!!,
      id = category.id
    )
  }

  override fun convertToUpdateCategoryRequest(updateCategoryDto: UpdateCategoryDto): UpdateCategoryRequest {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  @Transactional
  override fun convertToCreateCategoryRequest(createCategoryDto: CreateCategoryDto): CreateCategoryRequest {

    return CreateCategoryRequest(
      name = createCategoryDto.name,
      amount = createCategoryDto.amount,
      description = createCategoryDto.description
    )
  }
}