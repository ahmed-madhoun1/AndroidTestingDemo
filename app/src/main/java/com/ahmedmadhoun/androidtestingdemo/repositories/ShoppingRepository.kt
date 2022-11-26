package com.ahmedmadhoun.androidtestingdemo.repositories

import androidx.lifecycle.LiveData
import com.ahmedmadhoun.androidtestingdemo.data.local.ShoppingItem
import com.ahmedmadhoun.androidtestingdemo.data.remote.response.ImageResponse
import com.ahmedmadhoun.androidtestingdemo.others.Resource
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>

}