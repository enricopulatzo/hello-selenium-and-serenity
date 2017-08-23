<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set scope="request" var="id">homepage</c:set>
<c:set scope="request" var="title">Homepage</c:set>
<c:set scope="request" var="headContent">
</c:set>
<c:set scope="request" var="bodyContent">
  <button class="btn btn-primary" id="clickMe">Try An Ajax Call</button>
  <div id="results"></div>
</c:set>
<c:set scope="request" var="footerContent">
  <c:url var="url" value="/resources/js/api_v1_homepage_fetch.js"/>
  <script src="${url}" type="text/javascript"></script>
  <c:url var="url" value="/resources/js/api_v1_homepage_init.js"/>
  <script src="${url}" type="text/javascript"></script>
</c:set>
<jsp:include page="layout.jsp"/>
