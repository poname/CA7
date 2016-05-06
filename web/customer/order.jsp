<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../include/head.jsp">
    <jsp:param name="pageTitle" value="Order"/>
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
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="status">
                            <div class="tablo" >
                                <h3 class="title"><i class="fa fa-angle-left  fa-lg"></i>ثبت سفارش فروش سهام</h3>

                                <form action="sell" method="post">
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="orderSellId" class="col-sm-4 control-label">شناسه کاربر</label>
                                            <div class="col-sm-6">
                                                <input name="id" id="orderSellId" class="form-control" placeholder="شناسه کاربری خود را وارد کنید" required="" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا شناسه کاربری را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderSellInstrument" class="col-sm-4 control-label">نام نماد</label>
                                            <div class="col-sm-6">
                                                <input name="instrument" id="orderSellInstrument" class="form-control" placeholder="نام نماد مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا نام نماد را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderSellPrice" class="col-sm-4 control-label">قیمت پیشنهادی</label>
                                            <div class="col-sm-6">
                                                <input name="price" id="orderSellPrice" class="form-control" placeholder="قیمت مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا قیمت پیشنهادی را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderSellQuantity" class="col-sm-4 control-label">تعداد سهام</label>
                                            <div class="col-sm-6">
                                                <input name="quantity" id="orderSellQuantity" class="form-control" placeholder="تعداد مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا تعداد سهام را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderSellType" class="col-sm-4 control-label">نوع معامله</label>
                                            <div class="col-sm-6">
                                                <input name="type" id="orderSellType" class="form-control" placeholder="نوع مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا نوع معامله را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10" style="text-align:center">
                                                <button onclick="__doPostBack('ctl00$ContentPlaceHolder1$btn_Save','')" id="ContentPlaceHolder1_btn_Save" type="submit" class="btn btn-success">
                                                    ثبت سفارش فروش
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 col-xs-12">
                        <div class="status">
                            <div class="tablo" >
                                <h3 class="title"><i class="fa fa-angle-left  fa-lg"></i>ثبت سفارش خرید سهام</h3>

                                <form action="buy" method="post">
                                    <div class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="orderBuyId" class="col-sm-4 control-label">شناسه کاربر</label>
                                            <div class="col-sm-6">
                                                <input name="id" id="orderBuyId" class="form-control" placeholder="شناسه کاربری خود را وارد کنید" required="" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا شناسه کاربری را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderBuyInstrument" class="col-sm-4 control-label">نام نماد</label>
                                            <div class="col-sm-6">
                                                <input name="instrument" id="orderBuyInstrument" class="form-control" placeholder="نام نماد مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا نام نماد را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderBuyPrice" class="col-sm-4 control-label">قیمت پیشنهادی</label>
                                            <div class="col-sm-6">
                                                <input name="price" id="orderBuyPrice" class="form-control" placeholder="قیمت مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا قیمت پیشنهادی را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderBuyQuantity" class="col-sm-4 control-label">تعداد سهام</label>
                                            <div class="col-sm-6">
                                                <input name="quantity" id="orderBuyQuantity" class="form-control" placeholder="تعداد مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا تعداد سهام را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="orderBuyType" class="col-sm-4 control-label">نوع معامله</label>
                                            <div class="col-sm-6">
                                                <input name="type" id="orderBuyType" class="form-control" placeholder="نوع مورد نظر را وارد کنید" required="required" oninput="setCustomValidity('')" oninvalid="this.setCustomValidity('لطفا نوع معامله را وارد کنید!')" type="text">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10" style="text-align:center">
                                                <button id="buy_btn_Save" type="submit" class="btn btn-success">
                                                    ثبت سفارش خرید
                                                </button>
                                            </div>
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