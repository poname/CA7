<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html ng-app="myApp" ng-controller="myCtrl">
<script src="js/angular.min.js"></script>
<script src="js/app.js"></script>
<title>{{ pageTitle }}</title>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<meta charset="utf-8">

<link rel="stylesheet" type="text/css" href="css/custom.css">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-ui.js"></script>
<body>
<div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-12">
                <nav class="navbar navbar-default sidebar">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand logo" id="pcLogo">
                            <img src="../images/logo.png"></a>
                        <a class="navbar-brand logo" id="MobileLogo">
                            <img src="../images/logo.png"></a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav" id="usermenu">
                            <li id="RequestDepositMenu">
                                <a href="../customer/deposit.jsp">
                                    <img src="../images/cash.png">
                                    درخواست افزایش موجودی
                                </a>
                            </li>
                            <li class="active" id="OrderMenu">
                                <a href="../customer/order.jsp">
                                    <img src="../images/marketing8.png">
                                    ثبت سفارش
                                </a>
                            </li>
                            <li id="AddCustomerMenu">
                                <a href="../customer/add.jsp">
                                    <img src="../images/user.png">
                                    کاربر جدید
                                </a>
                            </li>
                            <li id="ReportMenu">
                                <a href="../admin/requests">
                                    <img src="../images/users39.png">
                                    مدیریت درخواست ها
                                </a>
                            </li>
                            <li id="BackupMenu">
                                <a href="admin/backup">
                                    <img src="images/backup.png">
                                    نسخه پشتیبان
                                </a>
                            </li>
                            <li id="StatusMenu">
                                <a href="../customer/status">
                                    <img src="../images/statistical.png">
                                    نبض بازار
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>


            </div>
            <div class="col-md-9 col-sm-9 col-xs-12">
                <div ng-include="include/header.html"></div>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="status">
                            <div class="tablo">
                                <h3 class="title"><i class="fa fa-angle-left  fa-lg"></i>عضویت</h3>
                                <span class="green">برای عضویت در سامانه موارد زیر را تکمیل فرمایید</span>
                                <form method="post" action="add" id="form1" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="addCustomerName" class="col-sm-2 control-label">نام</label>
                                        <div class="col-sm-3">
                                            <input name="name" id="addCustomerName" class="form-control" placeholder="نام خود را وارد کنید" required="" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا نام را وارد کنید!')" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="addCustomerFamily" class="col-sm-2 control-label">نام خانوادگی</label>
                                        <div class="col-sm-3">
                                            <input name="family" id="addCustomerFamily" class="form-control" placeholder="نام خانوادگی خود را وارد کنید" required="" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا نام خانوادگی را وارد کنید!')" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="addCustomerId" class="col-sm-2 control-label">شناسه کاربری</label>
                                        <div class="col-sm-3">
                                            <input name="id" id="addCustomerId" class="form-control" placeholder="شناسه کاربری را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا شناسه کاربری را وارد کنید!')" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button id="add_btn_Save" type="submit" class="btn btn-success">
                                                ثبت
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<div ng-include="'include/footer.html'"></div>
</body>
</html>