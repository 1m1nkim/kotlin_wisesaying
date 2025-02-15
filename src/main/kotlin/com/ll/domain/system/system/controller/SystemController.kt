package com.ll.domain.system.system.controller

import com.ll.com.ll.Rq

class SystemController {
    fun actionExit(rq: Rq){
        println("프로그램 종료")
        System.exit(0)
    }
}