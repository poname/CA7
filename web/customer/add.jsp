<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../include/head.jsp">
    <jsp:param name="pageTitle" value="Add"/>
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
<jsp:include page="../include/footer.html"></jsp:include>
</body>
</html>