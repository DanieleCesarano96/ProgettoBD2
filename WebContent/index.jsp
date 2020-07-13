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
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
						<a
							href="aggiuntaLibro.jsp"
							class="btn btn-inline my-2 my-sm-0 mx-2 bg-warning "
							id="AddLibro" data-toggle="tooltip" data-placement="bottom"
							title="Aggiungi nuovo libro"><i
							class="fas fa-plus-circle"></i></a>

					</form>
					<% 
						ArrayList<LibroBean> libri= (ArrayList<LibroBean>) request.getAttribute("libri");
					if(libri!=null)
					{
						for(LibroBean libro : libri)
						{
						
					%>
						<table class="table table-striped">
							<tr class="pt-1" id="lista">
								<td style="border-style: none"><a
									href="visualizzaDettagliLibro?bookID=<%=(String)libro.getBookID()%>"><%=libro.getTitolo() %></a>
								</td>
								<td style="border-style: none">
									 <a class="btn bg-warning"
									href="rimuoviLibro?bookID=<%=(String)libro.getBookID()%>"><small
										style="display: inline" class="d-none d-md-block">Rimuovi&nbsp;</small><i
										class="fas fa-trash-alt" style="display: inline"></i></a> 
								</td>
								<td style="border-style: none">
									 <a class="btn bg-warning"
									href="ricercaLibro?bookID=<%=(String)libro.getBookID()%>"><small
										style="display: inline" class="d-none d-md-block">Modifica&nbsp;</small><i
										class="fas fa-edit" style="display: inline"></i></a> 
								</td>
							</tr>
						</table>	
					<%
						}
					} 
					%>
				</div>
			</div>
			
			<aside class="col-md-4 my-4">
				<div class="list-group p-1 card">
					<h4 class="font-italic pt-3 pl-3 pr-3 pb-1">Query di ricerca</h4>
					<table class="table" style="table-layout: fixed; width: 100%;">
						<tr class="border" style="word-wrap: break-word;">
							<td
								style="font-size: 14px; padding: 5px; margin-right: 2px; word-wrap: break-word;">
								<form action="ricercaAvanzata" method="post">
									<div  class="text-xs-center mb-1">Titolo
										<input name="titolo" 
										 	type="text" placeholder="Titolo"
											aria-label="Titolo">
									</div>
									<div  class="text-xs-center mb-1">Autore
										<input  name="autore" 
										 	type="text" placeholder="Autore"
											aria-label="Autore">
									</div>
									<div  class="text-xs-center mb-1">isbn
										<input  name="isbn" 
										 	type="text" placeholder="isbn"
											aria-label="isbn">
									</div>
									<div  class="text-xs-center mb-1">Casa Editrice
										<input  name="casaeditrice" 
										 	type="text" placeholder="Casa Editrice"
											aria-label="Casa Editrice">
									</div>
									<div  class="text-xs-center mb-1">Valutazione Media Min
									<input  name="minvalutazionemedia" 
										 	type="number" min="0" max="4" placeholder="Valutazione Media Min"
											aria-label="Valutazione Media Min" value="0">
									</div>
									<div  class="text-xs-center mb-1">Valutazione Media Max
									<input  name="maxvalutazionemedia" 
										 	type="number" min="1" max="5" placeholder="Valutazione Media Max"
											aria-label="Valutazione Media Max" value="5">
									</div>
									<button type="submit" class="btn btn-primary mb-2"> Cerca</button>
								</form>	
							</td>
						</tr>

					</table>
				</div>

			</aside>
			<aside class="col-md-4 my-4">
				<div class="list-group p-1 card">
					<h4 class="font-italic pt-3 pl-3 pr-3 pb-1">Query analitiche</h4>
					<table class="table" style="table-layout: fixed; width: 100%;">
						<tr class="border" style="word-wrap: break-word;">
							<td
								style="font-size: 14px; padding: 5px; margin-right: 2px; word-wrap: break-word;">
								<form action="queryAnalitiche" method="post">
									
									<button type="submit" class="btn btn-primary mb-2"> Vai alle Query Analitiche</button>
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