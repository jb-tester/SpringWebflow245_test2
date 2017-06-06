<%--
  Created by IntelliJ IDEA.
  User: Irina.Petrovskaya
  Date: 6/5/2017
  Time: 6:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <script type="text/javascript">
        var count = 5;
        var counter = setInterval(timer, 1000);
        function timer() {
            count = count - 1;
            if (count <= 0) {
                clearInterval(counter);
                return;
            }
            document.getElementById("timer").innerHTML = count + " secs";
            console.log(count + " secs");
        }

    </script>
</head>
<body>
 <h1> hmm...</h1>
<span id="timer"></span>

</body>
</html>
