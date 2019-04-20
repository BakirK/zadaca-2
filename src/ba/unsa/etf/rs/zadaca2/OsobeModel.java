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
//            osoba.add(new Osoba)
        }
}


