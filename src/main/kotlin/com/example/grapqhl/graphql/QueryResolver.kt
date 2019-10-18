package com.example.grapqhl.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.grapqhl.business.JobService
import com.example.grapqhl.model.Job
import org.springframework.stereotype.Component

@Component
class QueryResolver(private val jobService: JobService) : GraphQLQueryResolver {

    fun getJobs() : List<Job> = jobService.getJobs();

}