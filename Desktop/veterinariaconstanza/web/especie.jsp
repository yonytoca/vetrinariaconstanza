<%-- 
    Document   : especie
    Created on : 31-mar-2015, 23:05:37
    Author     : victor
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="org.cfg.uapa.java.veterinaria.servicios.ServicioEspecie"%>
<%@page import="org.cfg.uapa.java.veterinaria.entidades.Especie"%>
<%@page import="java.util.List"%>
<jsp:include page="teplate/header.jsp"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%
    List<Especie> especie = ServicioEspecie.getInstancia().getListadoEspecie();
   
%>

<link rel="stylesheet" href="css/tablasvistacss.css" />
<center>
    <h2> Especies</h2>
        <table class="table table-striped">
    <tr><th>Codigo</th><th>Especies</th></tr>    
            <c:forEach items="<%=especie%>" var="especie">
        <tr><td>${especie.getId()}</td><td>${especie.getNombre()}</td></tr>

    </c:forEach>
</table>
    <a href="crearespecie.jsp"> Agregar Especie</a>
 <jsp:include page="teplate/footer.jsp"/>
