<%--
  Created by IntelliJ IDEA.
  User: 周博
  Date: 2023-04-05
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <jsp:include page="../include/header.jsp"/>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <c:forEach items="${pv}" var="p" varStatus="st">
                <label>${p.property.name}</label>
                <input type="text" class="proValue" id="${p.id}" name="proValue" value="${p.value}">
                </br>
            </c:forEach>
            </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('.proValue').change(function () {
            let value = $(this).val();
            let  id = $(this).attr("id");
            let url = "/admin_propertyValue_update?id="+id+"&value="+value;
            let that = $(this);
            $.get(
                url,
                function (result) {
                    if (result == "success") {
                        that.css("border-color","green");
                    } else {
                        that.css("border-color","red");
                    }
                }
            )
        })
    })
</script>
</body>
</html>
