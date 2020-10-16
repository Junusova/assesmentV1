package com.example.demo.model

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "category")
data class Category (


  //I'm not sure with mappedBy
        @OneToMany(mappedBy ="category",fetch = FetchType.LAZY)
  var items: List<Items>? = null,

        @Column(name = "name")
  var name: String? = null,

        @Column(name = "description")
  var description: String? = null,

        @Column(name = "amount")
  var amount: BigDecimal? = null

) : BaseEntity()