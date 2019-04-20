package ba.unsa.etf.rs.zadaca2;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OsobeModel {

        private ObservableList<Osoba> osoba = FXCollections.observableArrayList();
        private SimpleObjectProperty trenutnaOsoba = null;


        private ObservableList<Osoba> getOsoba() {
            return osoba;
        }

        private void setOsoba(ObservableList<Osoba> osoba) {
            this.osoba = osoba;
        }

        private Object getTrenutnaOsoba() {
            return trenutnaOsoba.get();
        }

        public SimpleObjectProperty trenutnaOsobaProperty() {
            return trenutnaOsoba;
        }

        private void setTrenutnaOsoba(Object trenutnaOsoba) {
            this.trenutnaOsoba.set(trenutnaOsoba);
        }

        private void napuni () {
            osoba.add(new Osoba("Bakir", "Karović", "Pozegina 42", "Sarajevo", 71000, "23.09.1999"));
            osoba.add(new Osoba("Faris", "Baždar", "Gradačačka 16", "Sarajevo", 71000, "13.01.1999"));
            osoba.add(new Osoba("Šeila", "Šeilić", "Herrengasse", "Graz", 8010, "28.02.2000"));
            osoba.add(new Osoba("Amra", "Amrica", "Rue Neuve", "Brisel", 1000, "07.03.2000"));
        }

        public void dodaj(Osoba o) {
            osoba.add(o);
        }
}


