package com.example.grapqhl.graphql.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.example.grapqhl.business.AddressService
import com.example.grapqhl.model.Address
import com.example.grapqhl.model.Person
import org.springframework.stereotype.Component

@Component
class PersonResolver(val addressService : AddressService) : GraphQLResolver<Person> {

    fun getAddress(person : Person) : Address = addressService.getAddress(person.addressId)

}