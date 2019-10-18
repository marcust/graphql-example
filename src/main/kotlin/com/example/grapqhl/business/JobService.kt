package com.example.grapqhl.business

import com.example.grapqhl.model.Job
import org.springframework.stereotype.Service
import java.util.*

@Service
class JobService {

    fun getJobs(): List<Job> = listOf(
            Job( "Title", UUID.randomUUID()),
            Job( "Another Title", UUID.randomUUID(),"description")
    )

}