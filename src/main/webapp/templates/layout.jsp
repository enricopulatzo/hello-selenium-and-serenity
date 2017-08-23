<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${requestScope.title}</title>
  <c:url var="url" value="/webjars/bootstrap/css/bootstrap.css"/>
  <link rel="stylesheet" type="text/css" href="${url}">
  <c:url var="url" value="/webjars/bootstrap/css/bootstrap-theme.css"/>
  <link rel="stylesheet" type="text/css" href="${url}">
  <style>
    [role=main] {
      margin-top: 60px;
    }
  </style>
  ${requestScope.headContent}
</head>
<body data-page-id="${requestScope.id}" data-context-root="${pageContext.servletContext.contextPath}">
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
              aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <c:url var="link" value="/"/>
      <a class="navbar-brand" href="${link}">Demo</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <c:url var="link" value="/"/>
        <c:set var="linkClass" value=""/>
        <c:if test="${fn:endsWith(pageContext.request.requestURI, 'index.jsp')}">
          <c:set var="linkClass" value="active"/>
        </c:if>
        <li class="${linkClass}"><a class='-btn-home' href="${link}">Home</a></li>
        <c:url var="link" value="/page1.html"/>
        <c:set var="linkClass" value=""/>
        <c:if test="${fn:endsWith(pageContext.request.requestURI, 'page1.jsp')}">
          <c:set var="linkClass" value="active"/>
        </c:if>
        <li class="${linkClass}"><a class='-btn-page-1' href="${link}">Page 1</a></li>
        <c:url var="link" value="/page2.html"/>
        <c:set var="linkClass" value=""/>
        <c:if test="${fn:endsWith(pageContext.request.requestURI, 'page2.jsp')}">
          <c:set var="linkClass" value="active"/>
        </c:if>
        <li class="${linkClass}"><a class='-btn-page-2' href="${link}">Page 2</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>
<div class="container" role="main">
  <h1>${requestScope.title}</h1>
  ${requestScope.bodyContent}
</div>
<c:url var="url" value="/webjars/jquery/jquery.min.js"/>
<script src="${url}" type="text/javascript"></script>
<c:url var="url" value="/webjars/bootstrap/js/bootstrap.js"/>
<script src="${url}" type="text/javascript"></script>
${requestScope.footerContent}
<c:url var="url" value="/resources/js/api_v1_ready.js"/>
<script src="${url}" type="text/javascript"></script>
</body>
</html>
