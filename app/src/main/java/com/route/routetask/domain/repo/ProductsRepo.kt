package com.route.routetask.domain.repo

import com.route.routetask.data.data_models.ProductsItem

interface ProductsRepo {
   suspend fun getProducts() : List<ProductsItem?>?
}