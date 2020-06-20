<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*"
	import="model.*"
	%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<main role="main" class="container">

		<div class="row">
			<div class="col-md-8 my-4">
				<div class="card mb-3 px-3 py-3">
					<form class="form-inline mb-3 pb-3"
						style="border-bottom: 1px solid">
						<h5 class="card-title mb-1">Lista libri&nbsp;</h5>
						<input class="form-control form-control-sm ml-5 w-50" id="myInput"
							type="text" placeholder="Cerca libro"
							aria-label="Cerca libro"> <a
							href="AggiungiPropostaTesiServlet"
							class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
							id="AddLibro" data-toggle="tooltip" data-placement="bottom"
							title="Aggiungi nuovo libro"><i
							class="fas fa-plus-circle"></i></a>

					</form>
					<% 
						ArrayList<LibroBean> libri= (ArrayList<LibroBean>) request.getAttribute("libri");
						for(LibroBean libro : libri)
						{
					%>
						<table class="table table-striped">
							<tr class="pt-1" id="lista">
								<td style="border-style: none"><a
									href="VisualizzaDettagliTesiServlet?propostatesi_id="><%=libro.getTitolo() %></a>
								</td>
								<td style="border-style: none">
									 <a class="btn bg-warning"
									href="rimuoviLibro?bookID=<%=libro.getBookID()%>"><small
										style="display: inline" class="d-none d-md-block">Rimuovi&nbsp;</small><i
										class="fas fa-trash-alt" style="display: inline"></i></a> 
								</td>
								<td style="border-style: none">
									 <a class="btn bg-warning"
									href="modificaLibro?bookID=<%=libro.getBookID()%>"><small
										style="display: inline" class="d-none d-md-block">Modifica&nbsp;</small><i
										class="fas fa-edit" style="display: inline"></i></a> 
								</td>
							</tr>
						</table>	
					<%
						} 
					%>
				</div>
			</div>
			
			<aside class="col-md-4 my-4">
				<div class="list-group p-1 card">
					<h4 class="font-italic pt-3 pl-3 pr-3 pb-1">Ricerca avanzata</h4>
					<table class="table" style="table-layout: fixed; width: 100%;">
						<tr class="border" style="word-wrap: break-word;">
							<td
								style="font-size: 14px; padding: 5px; margin-right: 2px; word-wrap: break-word;">
								<form>
									<div  class="text-xs-center mb-1">Titolo
										<input id="titolo" 
										 	type="text" placeholder="Titolo"
											aria-label="Titolo">
									</div>
									<div  class="text-xs-center mb-1">Autore
										<input  id="autore" 
										 	type="text" placeholder="Autore"
											aria-label="Autore">
									</div>
									<div  class="text-xs-center mb-1">isbn
										<input  id="isbn" 
										 	type="text" placeholder="isbn"
											aria-label="isbn">
									</div>
									<div  class="text-xs-center mb-1">Lingua
										<input  id="lingua" 
										 	type="text" placeholder="Lingua"
											aria-label="Lingua">
									</div>
									<div  class="text-xs-center mb-1">Anno publicazione
										<input  id="annopublicazione" 
										 	type="text" placeholder="Anno publicazione"
											aria-label="Anno publicazione">
									</div>
									<div  class="text-xs-center mb-1">Casa Editrice
										<input  id="casaeditrice" 
										 	type="text" placeholder="Casa Editrice"
											aria-label="Casa Editrice">
									</div>
									<button type="submit" class="btn btn-primary mb-2"> Cerca</button>
								</form>	
							</td>
						</tr>

					</table>
				</div>

			</aside>
		</div>
		</main>
	</div>
</body>
</html>