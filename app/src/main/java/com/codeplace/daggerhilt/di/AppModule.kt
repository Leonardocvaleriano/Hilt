package com.codeplace.daggerhilt.di

import com.codeplace.daggerhilt.data.remote.MyApi
import com.codeplace.daggerhilt.data.repository.ProjectRepositoryImpl
import com.codeplace.daggerhilt.domain.repository.ProjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
/** @InstallIn(SingletonComponent::class) - THIS ANNOTATION DEFINES: how long the dependency will provide this model
 *
 * SingletonComponent - The dependencies will live as long the application does.
 * ActivityComponent - The dependencies will live as long the activity directly inject into.
 * viewModelComponent - They long live as the viewModel...
 * ActivityRetainedComponent - The dependencies will not be destroyed if the activity be rotated.
 * ServiceComponent - ...
 */
@InstallIn(SingletonComponent::class)
object AppModule {

   // The repository needs to have the api instance to after that could be able to provides the dependency injection
    @Provides
    /**     @Singleton
     *  This singleton defines how many dependencies of this api we gonna have per SingletonComponent::class.
     *  Without this annotation everytime that this API be injected, we gonna have more than one singleton
     *  instance for this api, duplicating its Instance every time that it be called.
     */
    @Singleton
    fun providesMyApi():MyApi {
        return Retrofit.Builder()
            .baseUrl(MyApi.BASE_URL)
            .build()
            .create(MyApi::class.java)
    }

    // Behind the scenes hilt will identify that this retrofitInstance is already created and then will inject it
    // inside the dependency.

    @Provides
    fun providesRepository(api:MyApi):ProjectRepository{
        return ProjectRepositoryImpl(api)
    }

}