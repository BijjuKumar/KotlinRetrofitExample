package com.example.newyorkarticle.bean


class ClientRespBean {

    var fault: String? = null
    var response: Any? = null

    constructor() {

    }

    constructor(status: String,  statusDesc: String) : super() {
        this.fault = status
        this.response = statusDesc
    }

}
