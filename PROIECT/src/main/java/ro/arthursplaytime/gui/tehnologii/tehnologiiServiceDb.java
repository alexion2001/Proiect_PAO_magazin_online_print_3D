package ro.arthursplaytime.gui.tehnologii;

import ro.arthursplaytime.config.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class tehnologiiServiceDb implements tehnologiiService{

//    private Connection connection;
//
//    public tehnologiiServiceDb() throws SQLException {
//        this.connection = DbConnection.getInstance();
//    }

    @Override
    public void saveFilament(filament filament) {

    }

    @Override
    public void saveImprimanta(imprimante imprimante) {

    }

    @Override
    public void getByStatus() {

    }

    @Override
    public filament getByTip(String tip) {
        return null;
    }

    @Override
    public void modificareStatus(String nume) {

    }

    @Override
    public List<imprimante> getAll() {
        return Collections.EMPTY_LIST;
    }
}
