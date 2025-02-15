package com.ll.domain.wisesaying.wisesaying.controller

import com.ll.com.ll.Rq
import com.ll.domain.wisesaying.wisesaying.entity.WiseSaying

class WiseSayingController {

    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun actionWrite(rq: Rq){
        print("명언: ")
        val content = readlnOrNull()!!.trim()
        print("작가: ")
        val author = readlnOrNull()!!.trim()

        val id = ++lastId

        wiseSayings.add(WiseSaying(id, content, author))

        println("${id}번 명언이 등록되었습니다.")
    }

    fun actionList(rq: Rq){
        if(wiseSayings.isEmpty()){
            println("명언이 없습니다.")
            return
        }
        println("번호 / 작가 / 명언")
        println("---------------------")
        wiseSayings.forEach{
            println("${it.id} / ${it.content} / ${it.author}")
        }
    }
    fun actionDelete(rq: Rq){
        val id = rq.getParamValueAsInt("id", 0)

        if(id==0){
            println("id를 정확히 입력해주세요")
            return
        }

        val removed = wiseSayings.removeIf{it.id == id}       //소괄호 생략 가능

        if(removed){
            println("${id}번 명언을 삭제하였습니다.")
        }else{
            println("${id}번 명언은 존재하지 않습니다.")
        }

        //다른 방법 , 효율은 removeIf 가 더 좋음
//                val wiseSaying = wiseSayings.firstOrNull() {it.id == id}
//                //ifrstOrNull 있으면 저걸 리턴 아니면 아무것도 하지 말아라
//                if(wiseSaying == null){
//                    println("해당 id의 명언은 존재하지 않습니다.")
//                    continue
//                }
//
//                wiseSayings.remove(wiseSaying)
//
//                println("${id}번 명언을 삭제하였습니다.")
    }
}