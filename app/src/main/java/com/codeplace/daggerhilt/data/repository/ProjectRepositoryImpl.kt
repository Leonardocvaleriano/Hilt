package com.codeplace.daggerhilt.data.repository
import com.codeplace.daggerhilt.data.remote.MyApi
import com.codeplace.daggerhilt.domain.repository.ProjectRepository

class ProjectRepositoryImpl(val api:MyApi): ProjectRepository {
    override suspend fun doNetworkCall() {}
}