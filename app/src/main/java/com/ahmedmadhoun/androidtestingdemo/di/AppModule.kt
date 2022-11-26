package com.ahmedmadhoun.androidtestingdemo.di

import android.content.Context
import androidx.room.Room
import com.ahmedmadhoun.androidtestingdemo.data.local.ShoppingDao
import com.ahmedmadhoun.androidtestingdemo.data.local.ShoppingItemDatabase
import com.ahmedmadhoun.androidtestingdemo.data.remote.PixabayApi
import com.ahmedmadhoun.androidtestingdemo.others.Constants.BASE_URL
import com.ahmedmadhoun.androidtestingdemo.others.Constants.DATABASE_NAME
import com.ahmedmadhoun.androidtestingdemo.repositories.ShoppingRepository
import com.ahmedmadhoun.androidtestingdemo.repositories.ShoppingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideShoppingItemDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ShoppingItemDatabase::class.java, DATABASE_NAME)

    @Singleton
    @Provides
    fun provideShoppingDao(
        database: ShoppingItemDatabase
    ) = database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi(): PixabayApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayApi::class.java)

    @Singleton
    @Provides
    fun provideShoppingRepository(
        dao: ShoppingDao,
        api: PixabayApi
    ) = ShoppingRepositoryImpl(dao, api) as ShoppingRepository

}
