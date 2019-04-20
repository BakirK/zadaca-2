package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class OsobeModel {

        private ObservableList<Osoba> osobe = FXCollections.observableArrayList();
        private SimpleObjectProperty<Osoba> trenutnaOsoba = new SimpleObjectProperty();


        public ObservableList<Osoba> getOsobe() {
            return osobe;
        }

        public void setOsobe(ObservableList<Osoba> osobe) {
            this.osobe = osobe;
        }

        public Osoba getTrenutnaOsoba() {
            return trenutnaOsoba.get();
        }

        public SimpleObjectProperty trenutnaOsobaProperty() {
            return trenutnaOsoba;
        }

        public void setTrenutnaOsoba(Object trenutnaOsoba) {
            this.trenutnaOsoba.set((Osoba) trenutnaOsoba);
        }

        public void napuni () {
            osobe.add(new Osoba("Bakir", "Karović", "Pozegina 42", 71000, "Sarajevo", LocalDate.of(1999, 9, 23)));
            osobe.add(new Osoba("Faris", "Baždar", "Gradačačka 16", 71000, "Sarajevo", LocalDate.of(1999, 1, 13)));
            osobe.add(new Osoba("Šeila", "Šeilić", "Herrengasse",8010, "Graz",  LocalDate.of(2000, 2, 28)));
            osobe.add(new Osoba("Amra", "Amrica", "Rue Neuve", 1000, "Brisel", LocalDate.of(2000, 3, 7)));
            osobe.add(new Osoba("Nadir", "Muratovic", "Dvorska", 71000, "Sarejevo", LocalDate.of(1999, 7, 21)));
            osobe.add(new Osoba("Pujdo", "Ker", "Neretvanska", 71000, "Sarajevo", LocalDate.of(2018, 12, 16)));
            osobe.add(new Osoba("Lamija", "Lamsa", "Nanin sokak", 71000, "Sarajevo", LocalDate.of(1999, 3, 11)));
            osobe.add(new Osoba("Darko", "Randic", "Mula Mustafe Baseskije", 71000, "Sarajevo", LocalDate.of(1999, 5, 1)));
            osobe.add(new Osoba("Jasmin", "Dzelo", "Neretvanska", 71000, "Sarajevo", LocalDate.of(1985, 4, 1)));
        }

        public void dodaj(Osoba o) {
            osobe.add(o);
        }

        public void obrisi() {

        }
}


