<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/8
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/common.css" rel="stylesheet" type="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

    <script type="text/javascript">
      $(function () {
        var flag = true;
        $("#usereame").blur(function () {
          var username = $("#username").val();
          if (username == "") {
            $("#notice").html("昵称不能为空");
            flag = false;
          } else {
            $("#usernameNotice").html("");
          }
        })
        $("#password").blur(function () {
          var password = $("#password").val();
          if (password == "") {
            $("#notice").html("密码不能为空");
            flag = false;
          } else {
            $("#passwordNotice").html("");
          }
        })
        $("#identity").blur(function () {
          var identity = $("#identity").val();
          if (identity == "") {
            $("#identityNotice").html("身份证号必填");
            flag = false;
          } else {
            $("#emailNotice").html("");
          }
        })
        $("#tel").blur(function () {
          var tel = $("#tel").val();
          if (tel == "") {
            $("#telNotice").html("电话号码必填");
            flag = false;
          } else {
            $("#telNotice").html("");
          }
        })
        $("#submitBtn").click(function () {
          if (flag) {
            $("#submitBtn").submit();
          } else {
            alert("请输入完整注册信息！")
          }
        })
      })
    </script>
    >
</head>

<body>
<div class="wrap">
    <!-- main begin-->
    <div class="zclf login logns">
        <h1 class="blue">用户注册</h1>
        <form action="regist.do">
            <dl>
                <dd>
                    <label> <small>*</small>用户名</label>
                    <input type="text" name="username" id="username" class="inputh lf" value=""/>
                    <div class="lf red laba" id="usernameNotice"></div>
                </dd>
                <dd>
                    <label> <small>*</small>密码</label>
                    <input type="text" name="password" id="password" class="inputh lf" value=""/>
                    <div class="lf red laba" id="passwordNotice"></div>
                </dd>
                <dd>
                    <label> <small>*</small>身份证号</label>
                    <input type="text" name="identity" id="identity" class="inputh lf" value=""/>
                    <div class="lf red laba" id="identityNotice"></div>
                </dd>
                <dd>
                    <label> <small>*</small>电话</label>
                    <input type="text" name="tel" id="tel" class="inputh lf" value=""/>
                    <div class="lf red laba" id="telNotice"></div>
                </dd>
                <dd>
                    <label> <small>*</small>住址</label>
                    <input type="text" name="address" id="address" class="inputh lf" value=""/>

                </dd>
                <dd>
                    <label> <small>*</small>邮政编码</label>
                    <input type="text" name="postcade" id="postcade" class="inputh lf" value=""/>
                </dd>
                <dd class="hegas">
                    <label> <small>*</small>验证码</label>
                    <input type="text" class="inputh inputs lf" value=""/>
                    <span class="wordp lf"><img src="images/img2.jpg" width="96" height="27"
                                                alt=""/></span>
                    <span class="blues lf"><a href="" title="">看不清</a></span>
                </dd>
                <dd class="hegas">
                    <label>&nbsp;</label>
                    <input name="agree" type="checkbox" id="rem_u"/>
                    <label for="rem_u" class="labels">我同意<span class="blues">《服务条款》</span></label>
                </dd>
                <dd class="hegas">
                    <label>&nbsp;</label>
                    <input name="" type="submit" id="submitBtn" value="立即注册"
                           class="spbg buttombg buttombgs f14 lf"/>
                </dd>
            </dl>
        </form>
        >

    </div>
    <!-- main end-->
    <!-- footer begin-->

</div>
<!--footer end-->

</div>
</body>
</html>
