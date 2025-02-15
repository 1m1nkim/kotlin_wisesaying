package com.ll.com.ll

class App {
    fun run(){
        println("== 명언 앱 ==")
        var lastId = 0
        val wiseSayings = mutableListOf<WiseSaying>()
        while (true){
            print("명령어: ")
            val input = readlnOrNull()!!.trim()     //입력을 받거나 null일수도 있다.
            // !!.trim()
            // !!는 변수가 null을 리턴할리가 없으니까 ?를 굳이 사용하지 않아도 된다는 의미
            // 확실한 경우에만 사용하는게 좋음, 남발 x

            val rq = Rq(input)
                //rq는 리퀘스트

            if( rq.action =="종료")
                break
            else if (rq.action =="등록") {
                print("명언: ")
                val content = readlnOrNull()!!.trim()
                print("작가: ")
                val author = readlnOrNull()!!.trim()

                val id = ++lastId

                wiseSayings.add(WiseSaying(id, content, author))

                println("${id}번 명언이 등록되었습니다.")
            }else if(rq.action == "목록"){
                if(wiseSayings.isEmpty()){
                    println("명언이 없습니다.")
                    continue
                }
                println("번호 / 작가 / 명언")
                println("---------------------")
                wiseSayings.forEach{
                    println("${it.id} / ${it.content} / ${it.author}")
                }
            }else if(rq.action == "삭제"){
                val id = rq.getParamValueAsInt("id", 0)

                if(id==0){
                    println("id를 정확히 입력해주세요")
                    continue
                }

                println("입력된 id: $id")
            }
        }
    }
}