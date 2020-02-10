package com.martin;

import com.martin.Modelos.Persona;
import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Principal extends Application {

    public Principal(){


    }

    @Override
    public void start(Stage stage) throws Exception {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(new Persona("Maria", 26));
        listaPersonas.add(new Persona("Juan", 22));

        try {
            JRBeanCollectionDataSource jrds = new JRBeanCollectionDataSource(listaPersonas);

            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream("/com/martin/Informes/ejemploFactoryPersonas.jasper"), new HashMap<String, Object>(), jrds);
            JasperExportManager.exportReportToPdfFile(print, "informes\\informeFactoryPersonas.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Principal();
    }
}
