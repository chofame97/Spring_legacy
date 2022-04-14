<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#counter1, #counter2, #counter3 { font-family: arial; font-size: 40px; font-weight: bold; }
</style>
</head>
<body>

<p id="counter1"></p>
<p id="counter2"></p>
<p id="counter3"></p>

<!-- 숫자가 너무 클 경우 카운트 시간이 오래 걸릴 수 있어서 숫자 크기에 따른 
이벤트 시간을 조절하기 위해서 남아있는 숫자를 5로 나누어 숫자가 클 때는 좀 빠르게 진행되도록 했습니다. -->

<script type="text/javascript">
function numberCounter(target_frame, target_number) {
    this.count = 25000;	// 카운터를 시작할 값을 지정 
    this.diff = 0;	// diff 값을 비교하여 차이 값을 찾음
    this.target_count = parseInt(target_number);
    this.target_frame = document.getElementById(target_frame);
    this.timer = null;
    this.counter();
};
    numberCounter.prototype.counter = function() {   // prototype 을 이용하여 numberCount에 상속과 같은 counter 메소드를 생성
        var self = this;
        this.diff = this.target_count - this.count;  // 요청한 숫자값에서 
    
        if(this.diff > 0) {
            self.count += Math.ceil(this.diff / 5);  // Math.ceil 소수점 이하를 올림한다.
        }
    
        /* 혹시 카운터 중 숫자 내 , 가 나타나지 않게 하려면 아래줄을 .toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') 을 삭제하면 됨.  */
        this.target_frame.innerHTML = this.count.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
//        this.target_frame.innerHTML = this.count;
    
        if(this.count < this.target_count) {
            this.timer = setTimeout(function() { self.counter(); }, 20);
        } else {
            clearTimeout(this.timer);
        }
    };

new numberCounter("counter3", 99999);
new numberCounter("counter2", 12345678);
new numberCounter("counter1", 25500);

</script>


</body>
</html>