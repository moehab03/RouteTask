package com.route.routetask.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.route.routetask.R
import com.route.routetask.data.data_models.ProductsItem
import com.route.routetask.databinding.ActivityProductsBinding
import com.route.routetask.ui.activity.adapter.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductsBinding
    private val vm: ProductsViewModel by viewModels()
    private var productsList = listOf<ProductsItem?>()
    private val priceList = mutableListOf<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products)
        vm.getProducts()
        observeToLiveData()
    }

    private fun observeToLiveData() {
        vm.list.observe(this) {
            productsList = it!!
            fillPriceList()
            initRecyclerView()
        }
        vm.loading.observe(this) {
            binding.progressBar.isVisible = it
        }
        vm.errorMsg.observe(this) { msg ->
            showError(msg)
            binding.progressBar.isVisible = false
        }
    }

    private fun setDiscountToPrices(price: Double, discountPercentage: Double): Double {
        return price * discountPercentage
    }

    private fun initRecyclerView() {
        binding.apply {
            productsRV.adapter = ProductsAdapter(productsList, priceList)
            productsRV.visibility = View.VISIBLE
        }
    }

    fun fillPriceList() {
        productsList.forEach { product ->
            priceList.add(setDiscountToPrices(product?.price!!, product.discountPercentage!!))
        }
    }

    private fun showError(msg: String) {
        MaterialAlertDialogBuilder(this)
            .setTitle("Error")
            .setMessage(msg)
            .setPositiveButton("Ok") { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .create()
            .show()
    }

}