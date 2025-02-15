package com.ll.com.ll

import com.ll.domain.system.system.controller.SystemController
import com.ll.domain.wisesaying.wisesaying.controller.WiseSayingController
import com.ll.domain.wisesaying.wisesaying.entity.WiseSaying

class App {
    fun run(){
        val wiseSayingController = WiseSayingController()
        val systemController = SystemController()

        println("== 명언 앱 ==")

        while (true){
            print("명령어: ")
            val input = readlnOrNull()!!.trim()     //입력을 받거나 null일수도 있다.
            // !!.trim()
            // !!는 변수가 null을 리턴할리가 없으니까 ?를 굳이 사용하지 않아도 된다는 의미
            // 확실한 경우에만 사용하는게 좋음, 남발 x

            val rq = Rq(input)
                //rq는 리퀘스트

            when (rq.action){
                "종료" -> {
                    systemController.actionExit(rq)
                    break
                }
                "등록" -> wiseSayingController.actionWrite(rq)
                "목록" -> wiseSayingController.actionList(rq)
                "삭제" -> wiseSayingController.actionDelete(rq)
            }
        }
    }
}