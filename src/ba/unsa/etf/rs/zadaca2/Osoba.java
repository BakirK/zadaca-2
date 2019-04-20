package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Osoba {
    private SimpleStringProperty ime = new SimpleStringProperty("<Novi korisnik>");
    private SimpleStringProperty prezime = new SimpleStringProperty("<Novi korisnik>");
    private SimpleStringProperty ulica = new SimpleStringProperty("<Novi korisnik>");
    private SimpleStringProperty grad = new SimpleStringProperty("<Novi korisnik>");
    private SimpleIntegerProperty postanskiBroj = new SimpleIntegerProperty();
    private SimpleObjectProperty<LocalDate> rodjendan = new SimpleObjectProperty<LocalDate>();


}
