package com.example.demo.domain

import java.math.BigDecimal

data class CreateCategoryRequest (
  val name: String,
  val description: String,
  val amount: BigDecimal
)

data class UpdateCategoryRequest (
  val name: String,
  val description: String,
  val amount: BigDecimal
)