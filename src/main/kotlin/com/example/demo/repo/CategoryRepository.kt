package com.example.demo.repo

import com.example.demo.dto.category.CategoryDto
import com.example.demo.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CategoryRepository : JpaRepository<Category, Long> {

//  @Query("select * from Category", nativeQuery = true)
//  fun findAllCategory(): CategoryDto
}