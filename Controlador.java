package reto4.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import reto4.model.dao.LiderPorSalario_dao;
import reto4.model.dao.LideresPorNombre_dao;
import reto4.model.dao.ProyectoPorTipo_dao;
import reto4.model.vo.LiderPorSalario;
import reto4.model.vo.LideresPorNombre;
import reto4.model.vo.ProyectoPorTipo;

public class Controlador {
    private final LiderPorSalario_dao _lidersalario;
    private final ProyectoPorTipo_dao _proyectotipo;
    private final LideresPorNombre_dao _lideresnombre;

    public Controlador() {
        _lidersalario = new LiderPorSalario_dao();
        _proyectotipo = new ProyectoPorTipo_dao();
        _lideresnombre = new LideresPorNombre_dao();
    }

    public ArrayList<LiderPorSalario> requerimiento_1() throws SQLException {
        return _lidersalario.requerimiento1();
    }

    public ArrayList<ProyectoPorTipo> requerimiento_2() throws SQLException {
        return _proyectotipo.requerimiento2();
    }    

    public ArrayList<LideresPorNombre> requerimiento_3() throws SQLException {
        return _lideresnombre.requerimiento3();
    }
}
