package com.example.demo.domain

import com.example.demo.model.Category
import java.math.BigDecimal

data class CreateItemRequest(
        val email: String,
        val name: String,
        val amount: BigDecimal,
        val price: BigDecimal,
        val description: String,
        val category: Category,
        val isActive: Boolean
)

data class UpdateItemRequest(
        val name: String,
        val amount: BigDecimal,
        val price: BigDecimal,
        val description: String,
        val category: Category,
        val email: String

)