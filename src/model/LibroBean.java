package model;

public class LibroBean {

  private String bookID;
  private String titolo;
  private String autore;
  private double valutazione_media;
  private String isbn;
  private String isbn13; 
  private String lingua;
  private int numero_pagine ;
  private int numero_valutazioni;
  private int numero_revisioni;
  private String data_publicazione;
  private String casa_editrice;
  
  
  public LibroBean(String bookID, String titolo, String autore, double valutazione_media, String isbn, String isbn13,
      String lingua, int numero_pagine, int numero_valutazioni, int numero_revisioni, String data_publicazione,
      String casa_editrice) {
    super();
    this.bookID = bookID;
    this.titolo = titolo;
    this.autore = autore;
    this.valutazione_media = valutazione_media;
    this.isbn = isbn;
    this.isbn13 = isbn13;
    this.lingua = lingua;
    this.numero_pagine = numero_pagine;
    this.numero_valutazioni = numero_valutazioni;
    this.numero_revisioni = numero_revisioni;
    this.data_publicazione = data_publicazione;
    this.casa_editrice = casa_editrice;
  }
  
  public LibroBean( String titolo, String autore, double valutazione_media, String isbn, String isbn13,
      String lingua, int numero_pagine, int numero_valutazioni, int numero_revisioni, String data_publicazione,
      String casa_editrice) {
    super();
    this.titolo = titolo;
    this.autore = autore;
    this.valutazione_media = valutazione_media;
    this.isbn = isbn;
    this.isbn13 = isbn13;
    this.lingua = lingua;
    this.numero_pagine = numero_pagine;
    this.numero_valutazioni = numero_valutazioni;
    this.numero_revisioni = numero_revisioni;
    this.data_publicazione = data_publicazione;
    this.casa_editrice = casa_editrice;
  }
  
  
  public String getBookID() {
    return bookID;
  }
  public void setBookID(String bookID) {
    this.bookID = bookID;
  }
  public String getTitolo() {
    return titolo;
  }
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }
  public String getAutore() {
    return autore;
  }
  public void setAutore(String autore) {
    this.autore = autore;
  }
  public double getValutazione_media() {
    return valutazione_media;
  }
  public void setValutazione_media(double valutazione_media) {
    this.valutazione_media = valutazione_media;
  }
  public String getIsbn() {
    return isbn;
  }
  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }
  public String getIsbn13() {
    return isbn13;
  }
  public void setIsbn13(String isbn13) {
    this.isbn13 = isbn13;
  }
  public String getLingua() {
    return lingua;
  }
  public void setLingua(String lingua) {
    this.lingua = lingua;
  }
  public int getNumero_pagine() {
    return numero_pagine;
  }
  public void setNumero_pagine(int numero_pagine) {
    this.numero_pagine = numero_pagine;
  }
  public int getNumero_valutazioni() {
    return numero_valutazioni;
  }
  public void setNumero_valutazioni(int numero_valutazioni) {
    this.numero_valutazioni = numero_valutazioni;
  }
  public int getNumero_revisioni() {
    return numero_revisioni;
  }
  public void setNumero_revisioni(int numero_revisioni) {
    this.numero_revisioni = numero_revisioni;
  }
  public String getData_publicazione() {
    return data_publicazione;
  }
  public void setData_publicazione(String data_publicazione) {
    this.data_publicazione = data_publicazione;
  }
  public String getCasa_editrice() {
    return casa_editrice;
  }
  public void setCasa_editrice(String casa_editrice) {
    this.casa_editrice = casa_editrice;
  }
  
  
}
