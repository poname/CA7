<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../include/head.jsp">
    <jsp:param name="pageTitle" value="Requests"/>
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
                        <div class = "table-responsive">
                            <table class = "table table-bordered">

                                <caption>بخش مدیریت درخواست های افزایش موجودی</caption>

                                <thead>
                                <tr>
                                    <th>شناسه کاربر</th>
                                    <th>مبلغ درخواستی</th>
                                    <th>تایید</th>
                                    <th>رد</th>
                                </tr>
                                </thead>

                                <tbody>
                                <c:forEach var="req" items="${requestList}" >
                                    <tr>
                                        <td>
                                            <c:out value="${req.key}" />
                                        </td>
                                        <td>
                                            <c:out value="${req.value}" />
                                        </td>
                                        <td class="success">
                                            <a href="requests?op=accept&id=<c:out value="${req.key}"/>&amount=<c:out value="${req.value}"/>">✓</a>
                                        </td>
                                        <td class="danger">
                                            <a href="requests?op=delete&id=<c:out value="${req.key}"/>&amount=<c:out value="${req.value}"/>">✗</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
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