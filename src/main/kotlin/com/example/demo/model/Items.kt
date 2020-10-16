package com.example.demo.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "items")
data class Items(

        @ManyToOne()
  @JoinColumn(name = "category_id", nullable = false)
  var category: Category? = null,

        @Column(name = "name")
  var name: String? = null,

        @Column(name = "amount")
  var amount: BigDecimal? = null,

        @Column(name = "price")
  var price: BigDecimal? = null,

        @Column(name = "description")
  var description: String? = null,

        @Column(name = "is_active")
  var isActive: Boolean? = null

) : BaseEntity()