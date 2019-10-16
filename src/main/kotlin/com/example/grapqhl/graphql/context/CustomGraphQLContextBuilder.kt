package com.example.grapqhl.graphql.context

import com.example.grapqhl.business.AddressService
import graphql.servlet.context.*
import org.dataloader.DataLoader
import org.dataloader.DataLoaderRegistry
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.CompletableFuture
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.websocket.Session
import javax.websocket.server.HandshakeRequest

@Component
class CustomGraphQLContextBuilder(
    private val addressService: AddressService
) : GraphQLContextBuilder {

    override fun build(httpServletRequest: HttpServletRequest?, httpServletResponse: HttpServletResponse?): GraphQLContext =
            DefaultGraphQLServletContext.createServletContext()
                    .with(httpServletRequest)
                    .with(httpServletResponse)
                    .with(makeDataLoaderRegistry())
                    .build()

    override fun build(session: Session?, handshakeRequest: HandshakeRequest?): GraphQLContext =
            DefaultGraphQLWebSocketContext.createWebSocketContext()
                    .with(session)
                    .with(handshakeRequest)
                    .with(makeDataLoaderRegistry())
                    .build()

    override fun build(): GraphQLContext = DefaultGraphQLContextBuilder().build()

    private fun makeDataLoaderRegistry(): DataLoaderRegistry {
        val registry = DataLoaderRegistry();

        val addressByIdLoader = DataLoader.newMappedDataLoader { ids : Set<UUID> -> CompletableFuture.supplyAsync {addressService.loadAddresses(ids) } }

        registry.register(DataLoaders.ADDRESS_BY_ID, addressByIdLoader)

        return registry
    }


}