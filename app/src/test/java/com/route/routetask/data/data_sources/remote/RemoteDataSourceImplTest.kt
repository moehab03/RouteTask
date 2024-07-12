package com.route.routetask.data.data_sources.remote

import com.route.routetask.data.api.WebServices
import com.route.routetask.data.data_models.ProductsResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class RemoteDataSourceImplTest {
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var webServices: WebServices

    @Before
    fun setUp() {
        webServices = mockk<WebServices>()
        remoteDataSource = RemoteDataSourceImpl(webServices)
    }

    @Test
    fun `getProducts return list of product when web services return data`() = runBlocking {
        val expectedProducts = ProductsResponse()
        coEvery { webServices.getProducts() } returns expectedProducts

        val actualProducts = remoteDataSource.getProducts()

        assertEquals(expectedProducts.products, actualProducts)
    }
}