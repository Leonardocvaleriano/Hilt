package com.codeplace.daggerhilt.domain.repository

interface ProjectRepository {

    suspend fun doNetworkCall()
}