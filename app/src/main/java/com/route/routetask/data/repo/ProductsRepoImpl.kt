package com.route.routetask.data.repo

import com.route.routetask.data.data_models.ProductsItem
import com.route.routetask.data.data_sources.remote.RemoteDataSource
import com.route.routetask.domain.repo.ProductsRepo
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val remoteDS: RemoteDataSource) : ProductsRepo {
    override suspend fun getProducts(): List<ProductsItem?>? {
        return remoteDS.getProducts()
    }

}