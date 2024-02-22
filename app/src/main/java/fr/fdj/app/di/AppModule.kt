package fr.fdj.app.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.fdj.app.BuildConfig
import fr.fdj.app.data.remote.LeaguesApi
import fr.fdj.app.data.repository.LeaguesRepositoryImpl
import fr.fdj.app.data.remote.TeamsApi
import fr.fdj.app.data.repository.TeamsRepositoryImpl
import fr.fdj.app.domain.repository.LeaguesRepository
import fr.fdj.app.domain.repository.TeamsRepository
import fr.fdj.app.domain.usecase.GetLeaguesUseCase
import fr.fdj.app.domain.usecase.GetTeamsUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideLeaguesApi(retrofit: Retrofit): LeaguesApi = retrofit.create(LeaguesApi::class.java)

    @Singleton
    @Provides
    fun provideTeamsApi(retrofit: Retrofit): TeamsApi = retrofit.create(TeamsApi::class.java)

    @Singleton
    @Provides
    fun provideLeaguesRepository(leaguesApi: LeaguesApi): LeaguesRepository {
        return LeaguesRepositoryImpl(leaguesApi)
    }

    @Singleton
    @Provides
    fun provideTeamsRepository(teamsApi: TeamsApi): TeamsRepository {
        return TeamsRepositoryImpl(teamsApi)
    }

    @Provides
    @Singleton
    fun provideGetLeaguesUseCase(leaguesRepository: LeaguesRepository): GetLeaguesUseCase {
        return GetLeaguesUseCase(leaguesRepository)
    }

    @Provides
    @Singleton
    fun provideGetTeamsUseCase(teamsRepository: TeamsRepository): GetTeamsUseCase {
        return GetTeamsUseCase(teamsRepository)
    }
}
