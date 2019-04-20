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
            osobe.add(new Osoba("Semso", "Semsic", "Pozegina 42", 71000, "Sarajevo", LocalDate.of(1999, 9, 23)));
            osobe.add(new Osoba("Hamo", "Hamic", "Gradačačka 16", 71000, "Sarajevo", LocalDate.of(1999, 1, 13)));
            osobe.add(new Osoba("Nedo", "Nedic", "Gornja mahala",71100, "Sarajevo",  LocalDate.of(1980, 12, 6)));
            osobe.add(new Osoba("Mirso", "Mirsic", "Neka tamo daleko",72500, "Sarajevo",  LocalDate.of(1976, 11, 9)));
            osobe.add(new Osoba("Vlasta", "Vlastic", "Neka tamo daleko",72500, "Sarajevo",  LocalDate.of(1970, 10, 3)));
//            osobe.add(new Osoba("Šeila", "Šeilić", "Herrengasse",8010, "Graz",  LocalDate.of(2000, 2, 28)));
            osobe.add(new Osoba("Milada", "Miladic", "Neretvanska", 71000, "Sarajevo", LocalDate.of(2018, 12, 16)));
            osobe.add(new Osoba("Fata", "Fatic", "Rue Neuve", 1000, "Brisel", LocalDate.of(2000, 3, 7)));
            osobe.add(new Osoba("Hamida", "Hamidic", "Dvorska", 71000, "Sarejevo", LocalDate.of(1999, 7, 21)));
            osobe.add(new Osoba("Pero", "Peric", "Nanin sokak", 71000, "Sarajevo", LocalDate.of(1999, 3, 11)));
        }

        public void dodaj(Osoba o) {
            osobe.add(o);
        }

        public void obrisi() {

        }
}


