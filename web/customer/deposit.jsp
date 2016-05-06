<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../include/head.jsp">
    <jsp:param name="pageTitle" value="Deposit"/>
</jsp:include>
<body>
<div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-12">
                <jsp:include page="../include/navbar.html"></jsp:include>

            </div>
            <div class="col-md-9 col-sm-9 col-xs-12">
                <jsp:include page="../include/header.html"></jsp:include>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="status">
                            <div class="tablo">
                                <h3 class="title"><i class="fa fa-angle-left  fa-lg"></i>افزایش اعتبار</h3>
                                <span class="green">برای درخواست افزایش اعتبار موارد زیر را تکمیل فرمایید</span>
                                <form method="post" action="deposit" id="form1" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="customerDepositId" class="col-sm-2 control-label">شناسه کاربر</label>
                                        <div class="col-sm-4">
                                            <input name="id" id="customerDepositId" class="form-control" placeholder="شناسه کاربر جهت افزایش" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا شناسه کاربر را وارد کنید!')" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="customerDepositValue" class="col-sm-2 control-label">اعتبار</label>
                                        <div class="col-sm-4">
                                            <input name="amount" id="customerDepositValue" class="form-control" placeholder="مقدار اعتبار جهت افزایش" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا مقدار اعتبار را وارد کنید!')" type="text">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button id="deposit_btn_Save" type="submit" class="btn btn-success">
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
<jsp:include page="../include/footer.html"></jsp:include>
</body>
</html>