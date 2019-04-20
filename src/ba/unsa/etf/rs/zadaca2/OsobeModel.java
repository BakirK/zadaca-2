package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OsobeModel {

        private ObservableList<Osoba> osobe = FXCollections.observableArrayList();
        private SimpleObjectProperty trenutnaOsoba = null;


        public ObservableList<Osoba> getOsobe() {
            return osobe;
        }

        public void setOsobe(ObservableList<Osoba> osobe) {
            this.osobe = osobe;
        }

        public Object getTrenutnaOsoba() {
            return trenutnaOsoba.get();
        }

        public SimpleObjectProperty trenutnaOsobaProperty() {
            return trenutnaOsoba;
        }

        public void setTrenutnaOsoba(Object trenutnaOsoba) {
            this.trenutnaOsoba.set(trenutnaOsoba);
        }

        public void napuni () {
            osobe.add(new Osoba("Bakir", "Karović", "Pozegina 42", "Sarajevo", 71000, "23.09.1999"));
            osobe.add(new Osoba("Faris", "Baždar", "Gradačačka 16", "Sarajevo", 71000, "13.01.1999"));
            osobe.add(new Osoba("Šeila", "Šeilić", "Herrengasse", "Graz", 8010, "28.02.2000"));
            osobe.add(new Osoba("Amra", "Amrica", "Rue Neuve", "Brisel", 1000, "07.03.2000"));
        }

        public void dodaj(Osoba o) {
            osobe.add(o);
        }

        public void obrisi() {

        }
}


