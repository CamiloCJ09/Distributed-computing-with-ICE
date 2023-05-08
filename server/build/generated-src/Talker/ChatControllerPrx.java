//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `Callback.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Talker;

public interface ChatControllerPrx extends com.zeroc.Ice.ObjectPrx
{
    default void sendMessage(String msg, String destination)
    {
        sendMessage(msg, destination, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void sendMessage(String msg, String destination, java.util.Map<String, String> context)
    {
        _iceI_sendMessageAsync(msg, destination, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> sendMessageAsync(String msg, String destination)
    {
        return _iceI_sendMessageAsync(msg, destination, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> sendMessageAsync(String msg, String destination, java.util.Map<String, String> context)
    {
        return _iceI_sendMessageAsync(msg, destination, context, false);
    }

    /**
     * @hidden
     * @param iceP_msg -
     * @param iceP_destination -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_sendMessageAsync(String iceP_msg, String iceP_destination, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "sendMessage", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeString(iceP_msg);
                     ostr.writeString(iceP_destination);
                 }, null);
        return f;
    }

    default void broadcastMessage(String message)
    {
        broadcastMessage(message, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void broadcastMessage(String message, java.util.Map<String, String> context)
    {
        _iceI_broadcastMessageAsync(message, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> broadcastMessageAsync(String message)
    {
        return _iceI_broadcastMessageAsync(message, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> broadcastMessageAsync(String message, java.util.Map<String, String> context)
    {
        return _iceI_broadcastMessageAsync(message, context, false);
    }

    /**
     * @hidden
     * @param iceP_message -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_broadcastMessageAsync(String iceP_message, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "broadcastMessage", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeString(iceP_message);
                 }, null);
        return f;
    }

    default void subscribe(ChatClientPrx client)
    {
        subscribe(client, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void subscribe(ChatClientPrx client, java.util.Map<String, String> context)
    {
        _iceI_subscribeAsync(client, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> subscribeAsync(ChatClientPrx client)
    {
        return _iceI_subscribeAsync(client, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> subscribeAsync(ChatClientPrx client, java.util.Map<String, String> context)
    {
        return _iceI_subscribeAsync(client, context, false);
    }

    /**
     * @hidden
     * @param iceP_client -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_subscribeAsync(ChatClientPrx iceP_client, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "subscribe", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeProxy(iceP_client);
                 }, null);
        return f;
    }

    default void register(String hostname)
    {
        register(hostname, com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void register(String hostname, java.util.Map<String, String> context)
    {
        _iceI_registerAsync(hostname, context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> registerAsync(String hostname)
    {
        return _iceI_registerAsync(hostname, com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> registerAsync(String hostname, java.util.Map<String, String> context)
    {
        return _iceI_registerAsync(hostname, context, false);
    }

    /**
     * @hidden
     * @param iceP_hostname -
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_registerAsync(String iceP_hostname, java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "register", null, sync, null);
        f.invoke(false, context, null, ostr -> {
                     ostr.writeString(iceP_hostname);
                 }, null);
        return f;
    }

    default String[] getClients()
    {
        return getClients(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default String[] getClients(java.util.Map<String, String> context)
    {
        return _iceI_getClientsAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<String[]> getClientsAsync()
    {
        return _iceI_getClientsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<String[]> getClientsAsync(java.util.Map<String, String> context)
    {
        return _iceI_getClientsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<String[]> _iceI_getClientsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<String[]> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getClients", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     String[] ret;
                     ret = istr.readStringSeq();
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ChatControllerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), ChatControllerPrx.class, _ChatControllerPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ChatControllerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), ChatControllerPrx.class, _ChatControllerPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ChatControllerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), ChatControllerPrx.class, _ChatControllerPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static ChatControllerPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), ChatControllerPrx.class, _ChatControllerPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static ChatControllerPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, ChatControllerPrx.class, _ChatControllerPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static ChatControllerPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, ChatControllerPrx.class, _ChatControllerPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default ChatControllerPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (ChatControllerPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default ChatControllerPrx ice_adapterId(String newAdapterId)
    {
        return (ChatControllerPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default ChatControllerPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (ChatControllerPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default ChatControllerPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (ChatControllerPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default ChatControllerPrx ice_invocationTimeout(int newTimeout)
    {
        return (ChatControllerPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default ChatControllerPrx ice_connectionCached(boolean newCache)
    {
        return (ChatControllerPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default ChatControllerPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (ChatControllerPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ChatControllerPrx ice_secure(boolean b)
    {
        return (ChatControllerPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default ChatControllerPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (ChatControllerPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default ChatControllerPrx ice_preferSecure(boolean b)
    {
        return (ChatControllerPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default ChatControllerPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (ChatControllerPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default ChatControllerPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (ChatControllerPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default ChatControllerPrx ice_collocationOptimized(boolean b)
    {
        return (ChatControllerPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default ChatControllerPrx ice_twoway()
    {
        return (ChatControllerPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default ChatControllerPrx ice_oneway()
    {
        return (ChatControllerPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default ChatControllerPrx ice_batchOneway()
    {
        return (ChatControllerPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default ChatControllerPrx ice_datagram()
    {
        return (ChatControllerPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default ChatControllerPrx ice_batchDatagram()
    {
        return (ChatControllerPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default ChatControllerPrx ice_compress(boolean co)
    {
        return (ChatControllerPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default ChatControllerPrx ice_timeout(int t)
    {
        return (ChatControllerPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default ChatControllerPrx ice_connectionId(String connectionId)
    {
        return (ChatControllerPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default ChatControllerPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (ChatControllerPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::Talker::ChatController";
    }
}
