<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario horóscopo</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    </head>
    <body>
        <div class="container mt-4">
            <h2>Formulario horóscopo</h2>
            <form class="form-group border rounded p-5" action="servletHoroscopo" method="get">
                <%
                    String diaSeleccionado = (String) request.getAttribute("dia");
                    String mesSeleccionado = (String) request.getAttribute("mes");
                    ArrayList<String> meses = (ArrayList<String>) request.getAttribute("meses");
                    ArrayList<String> dias = (ArrayList<String>) request.getAttribute("dias");

                    String signo = (String) request.getAttribute("signo");
                    String nombre = (String) request.getAttribute("nombre");

                    boolean err_bool = (Boolean) request.getAttribute("err_bool");
                    String err_str = (String) request.getAttribute("err_str");
                %>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default" style="width: 160px;">Nombre:</span>
                    </div>
                    <input class="form-control" type="text" name="nombre" value="<%=request.getAttribute("nombre")%>">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default" style="width: 160px;">Dia de nacimiento:</span>
                    </div>
                    <select class="form-control" name="dia">
                        <%
                            for (String dia : dias) {
                                String textoSelected = "";
                                if (dia.equals(diaSeleccionado)) {
                                    textoSelected = "selected";
                                }
                        %><option <%=textoSelected%> value="<%=dia%>"><%=dia%></option>
                        <%}%>
                    </select>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default" style="width: 160px;">Mes de nacimiento:</span>
                    </div>
                    <select class="form-control" name="mes">
                        <%
                            for (String mes : meses) {
                                String textoSelected = "";
                                if (mes.equals(mesSeleccionado)) {
                                    textoSelected = "selected";
                                }
                        %>
                        <option <%=textoSelected%> value="<%=mes%>"><%=mes%></option>
                        <% }%>
                    </select>
                </div>

                <input class="btn btn-outline-primary" type="submit" value="Enviar">
            </form>
            <% if (!err_bool) {%> 
            <div class="alert alert-danger" role="alert">
                <%= err_str%>
            </div>
            <%}%>
            <% if (err_bool) {%> 
            <div class="card" style="width: 18rem; margin: auto;">
                <div class="card-body">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><p class="card-text">Nombre: <%=nombre%></p></li>
                        <li class="list-group-item"><h4 class="card-title"><%=signo.toUpperCase()%></h4></li>
                    </ul>
                </div>
                <div class="card-header">
                    <img class="card-img-top" src="images/aries.png">
                </div>
            </div>
            <%}%>
        </div>
    </body>
</html>
