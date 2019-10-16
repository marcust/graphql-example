package com.example.grapqhl.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.grapqhl.business.PersonService
import com.example.grapqhl.model.Person
import org.springframework.stereotype.Component

@Component
class QueryResolver(private val personService: PersonService) : GraphQLQueryResolver {

    fun getPerson() : Person = personService.getPerson()

    fun getPersons() : List<Person> = personService.getPersons();

}