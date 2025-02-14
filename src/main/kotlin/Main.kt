package com.ll

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
fun main() {
    println("== 명언 앱 ==")
    while (true){
        print("명언: ")
        val input = readlnOrNull()!!.trim()     //입력을 받거나 null일수도 있다.
                                                // !!.trim()
                                                // !!는 변수가 null을 리턴할리가 없으니까 ?를 굳이 사용하지 않아도 된다는 의미
                                                // 확실한 경우에만 사용하는게 좋음, 남발 x

        if( input =="exit")
            break
    }
}