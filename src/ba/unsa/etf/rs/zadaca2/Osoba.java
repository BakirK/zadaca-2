package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Osoba {
    private SimpleStringProperty ime = new SimpleStringProperty("");
    private SimpleStringProperty prezime = new SimpleStringProperty("");
    private SimpleStringProperty ulica = new SimpleStringProperty("");
    private SimpleStringProperty grad = new SimpleStringProperty("");
    private SimpleIntegerProperty postanskiBroj = new SimpleIntegerProperty();
    private SimpleObjectProperty<LocalDate> rodjendan = new SimpleObjectProperty<LocalDate>();


    public Osoba(){
    }

    public Osoba(String imeIn, String prezimeIn, String ulicaIn,
                 int postanskiBrojIn, String gradIn, String dateIn){

        this.ime = new SimpleStringProperty(imeIn);
        this.prezime = new SimpleStringProperty(prezimeIn);
        this.ulica = new SimpleStringProperty(ulicaIn);
        this.grad = new SimpleStringProperty(gradIn);
        this.postanskiBroj = new SimpleIntegerProperty(postanskiBrojIn);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDate temp = LocalDate.parse(dateIn, formatter);
        this.rodjendan = new SimpleObjectProperty<LocalDate>(temp);
    }


    public Osoba(String imeIn, String prezimeIn, String ulicaIn,
                 int postanskiBrojIn, String gradIn, LocalDate dateIn){
        this.ime = new SimpleStringProperty(imeIn);
        this.prezime = new SimpleStringProperty(prezimeIn);
        this.ulica = new SimpleStringProperty(ulicaIn);
        this.grad = new SimpleStringProperty(gradIn);
        this.postanskiBroj = new SimpleIntegerProperty(postanskiBrojIn);
        this.rodjendan = new SimpleObjectProperty<LocalDate>(dateIn);
    }

    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }


    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }


    public String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }


    public String getGrad() {
        return grad.get();
    }

    public SimpleStringProperty gradProperty() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad.set(grad);
    }


    public int getPostanskiBroj() {
        return postanskiBroj.get();
    }

    public SimpleIntegerProperty postanskiBrojProperty() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj.set(postanskiBroj);
    }


    public LocalDate getRodjendan() {
        return rodjendan.get();
    }

    public SimpleObjectProperty<LocalDate> rodjendanProperty() {
        return rodjendan;
    }

    public void setRodjendan(LocalDate rodjendan) {
        this.rodjendan.set(rodjendan);
    }

    @Override
    public String toString() {
        return ime.get() + " " + prezime.get();
    }
}
