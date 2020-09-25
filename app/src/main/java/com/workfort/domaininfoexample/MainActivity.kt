package com.workfort.domaininfoexample

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.domaininfo.DomainInfoCallback
import com.example.domaininfo.Result
import com.example.domaininfo.DomainInfo
import kotlinx.android.synthetic.main.activity_main.*

/**
 * ****************************************************************************
 * Created by : arhan on 25 Sep, 2020 at 11:25.
 * Email : ashik.pstu.cse@gmail.com
 *
 * This class is for:
 * 1. providing an example of the DominInfo Library
 * 2.
 * 3.
 *
 * Last edited by : arhan on 2020/09/25 at 11:25.
 *
 * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>
 * ****************************************************************************
 */
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private var lastDomain: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fab.setOnClickListener {
            inputNewDomain()
        }
    }

    /**
     * This function shows a input dialog to get a domain name. The input data then sent to
     * findDomainInfo() function to get and show the whois info of the domain
     * */
    private fun inputNewDomain() {
        val view = layoutInflater.inflate(R.layout.prompt_input, null, false)
        val etDomain = view.findViewById<EditText>(R.id.etDomain)
        if(lastDomain.isNotEmpty()) etDomain.setText(lastDomain)

        AlertDialog.Builder(this)
            .setView(view)
            .setPositiveButton("Get Info") { _,_ ->
                val domain = etDomain.text.toString()
                if(domain.isNotEmpty()) findDomainInfo(domain)
            }
            .setNegativeButton("Cancel") {_,_ ->}
            .create()
            .show()
    }

    /**
     * This function tries to find the domain info with the DomainInfo library and show the result
     * in a text view.
     *
     * @param domain: the domain name from which the info will be obtained
     * */
    private fun findDomainInfo(domain: String) {
        lastDomain = domain

        DomainInfo(domain).findAsync(object: DomainInfoCallback {
            override fun onResponse(result: Result<String>) {
                tvResult.text = when(result) {
                    is Result.Success -> result.data
                    is Result.Error -> result.exception.toString()
                }
            }
        })
    }
}