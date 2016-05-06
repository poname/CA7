<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/include/head.jsp">
    <jsp:param name="pageTitle" value="Deposit"/>
</jsp:include>
<body>
<div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3 col-sm-3 col-xs-12">
                <jsp:include page="/include/navbar.html"></jsp:include>

            </div>
            <div class="col-md-9 col-sm-9 col-xs-12">
                <jsp:include page="/include/header.html"></jsp:include>
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="status">
                            نتیجه درخواست :
                            <br/>
                            <p>
                                <% out.print(request.getAttribute("resultMessage")); %>
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="/include/footer.html"></jsp:include>
</body>
</html>