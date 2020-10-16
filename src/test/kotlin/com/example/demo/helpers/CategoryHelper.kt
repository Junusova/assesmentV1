package helpers

import com.example.demo.model.Category
import java.math.BigDecimal


fun createCategoryRequest(): Category {
  return Category(
    name = "Test Category",
    description = "Test Category Description",
    amount = BigDecimal.valueOf(45.63),
    items = listOf()
  )
    .apply { id = 1 }
}


