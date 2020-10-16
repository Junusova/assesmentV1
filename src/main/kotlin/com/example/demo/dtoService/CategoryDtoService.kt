package com.example.demo.dtoService

import com.example.demo.dto.category.CategoryDto
import com.example.demo.dto.category.CreateCategoryDto
import com.example.demo.dto.category.UpdateCategoryDto
import com.example.demo.model.Category

interface CategoryDtoService {
  fun create(createCategoryDto: CreateCategoryDto): CategoryDto
  fun update(updateCategoryDto: UpdateCategoryDto, id: Long): CategoryDto
  fun getCategoryById(id: Long) : Category
  fun delete(id: Long)
}