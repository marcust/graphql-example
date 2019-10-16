package com.example.grapqhl.graphql.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.example.grapqhl.business.AddressService
import com.example.grapqhl.graphql.context.DataLoaders
import com.example.grapqhl.model.Address
import com.example.grapqhl.model.Person
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.CompletableFuture

@Component
class PersonResolver(private val addressService : AddressService) : GraphQLResolver<Person> {

    fun getAddress(person : Person, dfe : DataFetchingEnvironment) : CompletableFuture<Address> {
        return dfe.getDataLoader<UUID,Address>(DataLoaders.ADDRESS_BY_ID).load(person.addressId)
    }

}