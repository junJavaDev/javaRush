<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../components/header.jsp" %>

<div class="card align-items-center mx-auto my-3 w500">

    <!-- Form Name -->
    <p class="fw-normal fs-4 my-3 mx-auto">
        <c:choose>
            <c:when test="${requestScope.user.id>0}">
                ${langEditFormLegend} <b>${requestScope.user.login}</b>
            </c:when>
            <c:otherwise>
                ${langCreateFormLegend}
            </c:otherwise>
        </c:choose>
    </p>

    <form class="form-horizontal needs-validation" action="${rootPath}${s.user}?${s.paramId}=${param.id}" method="post"
          enctype="multipart/form-data" novalidate>
        <fieldset class="w400">
            <div class="row">
                <!-- Login input-->
                <div class="col-md-6">
                    <%@ include file="form-elements/loginInput.jsp" %>
                </div>
                <!-- Password input-->
                <div class="col-md-6">
                    <%@ include file="form-elements/passwordInput.jsp" %>
                </div>
                <!-- Role select -->
                <div ${sessionScope.role == Role.GUEST
                        ? "class='col-md-6'"
                        : ""}>
                    <%@ include file="form-elements/roleSelect.jsp" %>
                </div>
                <!-- Keyword input -->
                <c:if test="${sessionScope.role == Role.GUEST}">
                    <%@ include file="form-elements/keyWord.jsp" %>
                </c:if>
                <!-- Avatar input-->
                <%@ include file="form-elements/avatarInput.jsp" %>
                <!-- Buttons -->
                <div class="d-flex justify-content-around my-3">
                    <button id="submit" name="${requestScope.user.id>0?s.updateBtn:s.createBtn}"
                            class="btn btn-outline-secondary">
                        ${requestScope.user.id> 0 ? langUpdateBtn : langCreateBtn}
                    </button>
                    <c:if test="${requestScope.user.id> 0 && requestScope.user.id != sessionScope.user.id}">
                        <button id="delete" name="${s.deleteBtn}" class="btn btn-danger">${langDeleteBtn}</button>
                    </c:if>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<%@ include file="../components/footer.jsp" %>