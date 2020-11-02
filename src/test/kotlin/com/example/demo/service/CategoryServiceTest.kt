package com.example.demo.service

import com.example.demo.repo.CategoryRepository
import helpers.createCategoryRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import utils.ServiceTest

class CategoryServiceTest : ServiceTest() {


    @Mock
    private val categoryRepository: CategoryRepository? = null

    @Mock
    private lateinit var categoryService: CategoryService

    @Test
    fun createItemTest() {

        if (categoryRepository != null) {
            given(categoryRepository.save(createCategoryRequest())).willReturn(createCategoryRequest())
        }
        val expected = categoryService.save(createCategoryRequest())
        assertEquals(expected, createCategoryRequest())
    }
}