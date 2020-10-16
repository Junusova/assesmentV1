package com.example.demo.service

import com.example.demo.domain.CreateCategoryRequest
import com.example.demo.domain.UpdateCategoryRequest
import com.example.demo.dto.category.CategoryDto
import com.example.demo.dto.category.CreateCategoryDto
import com.example.demo.dto.category.UpdateCategoryDto
import com.example.demo.dtoService.CategoryDtoService
import com.example.demo.impl.CategoriesRequestMapper
import com.example.demo.model.Category
import com.example.demo.repo.CategoryRepository
import org.springframework.stereotype.Service

@Service
class DefaultCategoryService(
        private val categoryRepository: CategoryRepository,
        private val categoryDtoMapper: CategoriesRequestMapper,
        private val categoryService: CategoryService,
        private val categoryRequestMapper: CategoriesRequestMapper
) : CategoryDtoService {


  override fun delete(id: Long) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun getCategoryById(id: Long): Category = categoryRepository.getOne(id)

  override fun update(updateCategoryDto: UpdateCategoryDto, id: Long): CategoryDto {
    val updateCategoryRequest: UpdateCategoryRequest =
      categoryRequestMapper.convertToUpdateCategoryRequest(updateCategoryDto)

    val updateCategory: Category = categoryService.update(updateCategoryRequest, id)

    return categoryDtoMapper.convertToDto(updateCategory)
  }

  override fun create(createCategoryDto: CreateCategoryDto): CategoryDto {
    val createCategoryRequest: CreateCategoryRequest =
      categoryDtoMapper.convertToCreateCategoryRequest(createCategoryDto)

    val createCategory: Category = categoryService.create(createCategoryRequest)

    return categoryDtoMapper.convertToDto(createCategory)
  }
}
