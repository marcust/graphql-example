package com.example.grapqhl.business

import com.example.grapqhl.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService {

    fun getPerson() : Person = Person("Test Person", UUID.randomUUID())

}