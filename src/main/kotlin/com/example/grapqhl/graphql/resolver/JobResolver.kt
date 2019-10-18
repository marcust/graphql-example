package com.example.grapqhl.graphql.resolver

import com.coxautodev.graphql.tools.GraphQLResolver
import com.example.grapqhl.business.AddressService
import com.example.grapqhl.business.JobService
import com.example.grapqhl.graphql.context.DataLoaders
import com.example.grapqhl.model.Address
import com.example.grapqhl.model.Job
import graphql.schema.DataFetchingEnvironment
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.CompletableFuture

@Component
class JobResolver(
        private val addressService : AddressService,
        private val jobService: JobService
) : GraphQLResolver<Job> {

    fun getLocation(job : Job, dfe : DataFetchingEnvironment) : CompletableFuture<Address> =
            dfe.getDataLoader<UUID,Address>(DataLoaders.ADDRESS_BY_ID).load(job.addressId)

}