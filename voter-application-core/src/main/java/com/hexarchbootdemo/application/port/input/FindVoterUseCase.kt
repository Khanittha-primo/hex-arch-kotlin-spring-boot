package com.hexarchbootdemo.application.port.input

import com.hexarchbootdemo.domain.model.Voter
import kotlinx.coroutines.flow.Flow
import org.valiktor.functions.isNotEmpty
import org.valiktor.validate

interface FindVoterUseCase {

    fun findByLastName(query: FindByLastNameQuery): List<Voter>

    suspend fun findByLastNameReactive(query: FindByLastNameQuery): Flow<Voter>

    data class FindByLastNameQuery(val lastNameContains: String) {
        init {
            validate(this) {
                validate(FindByLastNameQuery::lastNameContains).isNotEmpty()
            }
        }
    }
}
