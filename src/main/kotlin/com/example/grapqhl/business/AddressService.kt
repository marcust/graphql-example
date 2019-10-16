package com.example.grapqhl.business

import com.example.grapqhl.model.Address
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddressService {

    fun getAddress(addressId : UUID) : Address = Address("Some Street")

    // Example only, should map to a batch loading function
    fun loadAddresses(ids: Set<UUID>): Map<UUID, Address> = ids.map { it to getAddress(it) }.toMap()

}