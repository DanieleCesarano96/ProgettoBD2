<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*"
	import="model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/stile.css">
<title>Modifica libro</title>
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
</head>


<body>
	<jsp:include page="header.jsp" />

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/registrazione.js"></script>



	
	<div
		style="background-image: linear-gradient(to bottom right, #FF8C00, #FFC04C); min-height: 80vh;">
		<% 
				LibroBean libro= (LibroBean) request.getAttribute("libro");	
		%>

		<main role="main" class="container">
		<div class="row">
			<div class="col-md-12 my-4">
				<div class="card mb-3">
					<div class="card-body " style="min-height: 80vh;">
						<div class="form-inline mb-3 pb-3"
							style="border-bottom: 1px solid">
							<h5 class="card-title mb-1">Modifica di un libro&nbsp;</h5>
						</div>
						<form
							action="modificaLibro?bookID=<%=(String)libro.getBookID()%>" method="post">
							<h6>Inserisci i dati nei campi sottostanti</h6>

							<div class="form-group">
								<label for="inputTitolo">Titolo</label> <input type="text"
									class="form-control" name="titolo" placeholder="Titolo"
									onchange="controlloTitolo()" value="<%=libro.getTitolo() %>"
									required>
							</div>

							<div class="form-group">
								<label for="inputAutore">Autore</label> <input type="text"
									class="form-control" name="autore" placeholder="Autore"
									onchange="controlloAutore()" value="<%=libro.getAutore() %>"
									required>
							</div>

							<div class="form-group">
								<label for="inputValutazioneMedia">Valutazione media</label> <input  
								class="form-control" name="valutazioneMedia" placeholder="Valutazione Media"
									onchange="controlloValutazioneMedia()"
									value="<%=libro.getValutazione_media() %>"> 
							</div>

							<div class="form-group">
								<label for="inputIsbn">Isbn</label>
								<input class="form-control" type="number"  placeholder="Isbn" name="isbn" 
								onchange="controlloIsbn()" value="<%=libro.getIsbn() %>">
							</div>
							
							<div class="form-group">
								<label for="inputIsbn13">Isbn13</label>
								<input class="form-control" type="number"  placeholder="Isbn13" name="isbn13" 
								onchange="controlloIsbn13()" value="<%=libro.getIsbn13() %>">
							</div>
							
							<div class="form-group">
								<label for="inputLingua">Lingua</label>
								<input class="form-control" type="text"  placeholder="Lingua" name="lingua" 
								onchange="controlloLingua()" value="<%=libro.getLingua() %>">
							</div>
							
							<div class="form-group">
								<label for="inputNumeroPagine">Numero pagine</label>
								<input class="form-control" type="number"
								placeholder="Numero pagine" name="numeropagine" value="<%=libro.getNumero_pagine() %>">
							</div>
							
							<div class="form-group">
								<label for="inputNumeroValutazioni">Numero valutazioni</label>
								<input class="form-control" type="number"
								placeholder="Numero valutazioni" name="numerovalutazioni" value="<%=libro.getNumero_valutazioni() %>">
							</div>
							
							<div class="form-group">
								<label for="inputNumeroRevisioni">Numero revisioni</label>
								<input class="form-control" type="number"
								placeholder="Numero revisioni" name="numerorevisioni" value="<%=libro.getNumero_revisioni() %>">
							</div>
						
							<div class="form-group">
								<label for="inputDatapublicazione">Data publicazione</label>
								<input class="form-control" type="text"
								placeholder="Data publicazione" name="dataPublicazione" value="<%=libro.getData_publicazione()%>">
							</div>
							
							<div class="form-group">
								<label for="inputCasaeditrice">Casa editrice</label>
								<input class="form-control" type="text"
								placeholder="Casa editrice" name="casaEditrice" value="<%=libro.getCasa_editrice()%>">
							</div>

							<button type="submit" class="btn btn-primary mx-3 my-3" >Modifica</button>
						</form>
					</div>
				</div>
			</div>

		</div>
		</main>
	</div>

</body>
</html>