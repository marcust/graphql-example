package com.example.grapqhl.model

import java.util.*

data class Job(
        val title: String,
        val addressId: UUID,
        val description: String? = null
)