package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Osoba {
    private SimpleStringProperty ime = new SimpleStringProperty("<Novi korisnik>");
    private SimpleStringProperty prezime = new SimpleStringProperty("");
    private SimpleStringProperty ulica = new SimpleStringProperty("");
    private SimpleStringProperty grad = new SimpleStringProperty("");
    private SimpleIntegerProperty postanskiBroj = new SimpleIntegerProperty();
    private SimpleObjectProperty<LocalDate> rodjendan = new SimpleObjectProperty<LocalDate>();


    private String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    private void setIme(String ime) {
        this.ime.set(ime);
    }


    private String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    private void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }


    private String getUlica() {
        return ulica.get();
    }

    public SimpleStringProperty ulicaProperty() {
        return ulica;
    }

    private void setUlica(String ulica) {
        this.ulica.set(ulica);
    }


    private String getGrad() {
        return grad.get();
    }

    public SimpleStringProperty gradProperty() {
        return grad;
    }

    private void setGrad(String grad) {
        this.grad.set(grad);
    }


    private int getPostanskiBroj() {
        return postanskiBroj.get();
    }

    public SimpleIntegerProperty postanskiBrojProperty() {
        return postanskiBroj;
    }

    private void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj.set(postanskiBroj);
    }


    private LocalDate getRodjendan() {
        return rodjendan.get();
    }

    public SimpleObjectProperty<LocalDate> rodjendanProperty() {
        return rodjendan;
    }

    private void setRodjendan(LocalDate rodjendan) {
        this.rodjendan.set(rodjendan);
    }
}
