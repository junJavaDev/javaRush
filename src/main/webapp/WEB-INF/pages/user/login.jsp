<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../components/header.jsp" %>

<div class="card align-items-center mx-auto my-3 w500">
    <p class="fw-normal fs-4 my-3 mx-auto">${loginFormLegend}</p>

    <form class="form-horizontal needs-validation" action="${rootPath}${s.login}"
          method="post" novalidate>
        <fieldset class="w400">
            <div class="row">
                <!-- Login input-->
                <%@ include file="form-elements/loginInput.jsp" %>
                <!-- Password input-->
                <%@ include file="form-elements/passwordInput.jsp" %>
            </div>
            <!-- Button -->
            <div class="d-flex justify-content-around my-3">
                <button class="btn btn-outline-secondary" id="submit" name="${s.signInBtn}">
                    ${langSignInBtn}
                </button>
            </div>
        </fieldset>
    </form>
</div>
<%@ include file="../components/footer.jsp" %>