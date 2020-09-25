package com.example.domaininfo

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.commons.net.whois.WhoisClient
import java.io.IOException

/**
 * ****************************************************************************
 * Created by : arhan on 25 Sep, 2020 at 11:25.
 * Email : ashik.pstu.cse@gmail.com
 *
 * This class is for:
 * 1. getting the whois info for any given domain
 * 2.
 * 3.
 *
 * @param domain: the domain name from which the info will be obtained
 * @param host: host name for finding the whois info. Default "whois.internic.net"
 * @param port: port to make the network call. The default whois port is set to 43 according to RFC 954.
 *
 * Last edited by : arhan on 2020/09/25 at 11:25.
 *
 * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 * ****************************************************************************
 */
class DomainInfo(
    private val domain: String,
    private val host: String = WhoisClient.DEFAULT_HOST,
    private val port: Int = 43
) {

    /**
     * This function executes the blocking find() function and returns the result with a callback
     * */
    fun findAsync (callback: DomainInfoCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = find()
            withContext(Dispatchers.Main) { callback.onResponse(result) }
        }
    }

    /**
     * This function finds the whois info with WhoisClient inside a coroutine thread.
     * **It must need to be called from a CoroutineScope.**
     *
     * @return value:
     * 1. If the request is a success: A string value containing the whois info
     * 2. If failed, an exception containing the error
     * */
    @Suppress("BlockingMethodInNonBlockingContext")
    suspend fun find(): Result<String> = withContext(Dispatchers.IO) {
        val client = WhoisClient()

        try {
            //it should work without the WHO_IS_PORT as the default port is 43.
            //yet we are setting it so that we can change it if we want in future
            client.connect(host, port)
            val result = client.query(domain)

            Result.Success(result)
        } catch (ex: IOException) {
            Result.Error(ex)
        }
    }
}

/**
 * Interface for providing domain info callback
 * */
interface DomainInfoCallback {
    fun onResponse(result: Result<String>)
}