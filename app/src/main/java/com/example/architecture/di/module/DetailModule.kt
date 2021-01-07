package com.example.architecture.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier

@Module
@InstallIn(ApplicationComponent::class)
object DetailModule {

//    @DetailName
//    @Provides
//    fun provideName() = "Android"
//
//    @DetailOwner
//    @Provides
//    fun provideOwner() = "open-android"

}

//@Qualifier
//@Retention(AnnotationRetention.RUNTIME)
//annotation class DetailOwner
//
//@Qualifier
//@Retention(AnnotationRetention.RUNTIME)
//annotation class DetailName
