/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class CheckboxView {
     
    
    private String[] selectedSemestre1;
    private List<String> semestre1;
    private String[] selectedSemestre2;
    private List<String> semestre2;
    private String[] selectedSemestre3;
    private List<String> semestre3;
    private String[] selectedSemestre4;
    private List<String> semestre4;
    private String[] selectedSemestre5;
    private List<String> semestre5;
    private String[] selectedSemestre6;
    private List<String> semestre6;
    private String[] selectedSemestre7;
    private List<String> semestre7;
    private String[] selectedSemestre8;
    private List<String> semestre8;
    private String[] selectedSemestre9;
    private List<String> semestre9;
     
    @PostConstruct
    public void init() {
        semestre1=new ArrayList<String>();
        semestre1.add("ANALISIS I");
        semestre1.add("FUNDAMENTOS DE MATEMATICA");
        semestre1.add("PROGRAMACION I");
        semestre1.add("FISICA APLICADA");
        semestre1.add("COMUNICACION ORAL Y ESCRITA");
        semestre1.add("ECOLOGIA DE LA TICS");
        
        semestre2=new ArrayList<String>();
        semestre2.add("ANALISIS II");
        semestre2.add("ALGEBRA LINEAL");
        semestre2.add("PROGRAMACION II");
        semestre2.add("MATEMATICAS DISCRETAS");
        semestre2.add("SISTEMAS DIGITALES Y MICROPROCESADORES");
        
        
        semestre3=new ArrayList<String>();
        semestre3.add("ANALISIS III");
        semestre3.add("PROBABILIDADES");
        semestre3.add("ESTRUCTURA DE DATOS");
        semestre3.add("ALGORITMOS");
        semestre3.add("SISTEMAS OPERATIVOS I");
        semestre3.add("ARQUITECTURA DE ORDENADORES");
        semestre3.add("DESARROLLO DE LA PERSONALIDAD Y VALORES");
        
        semestre4=new ArrayList<String>();
        semestre4.add("ECUACIONES DIFERENCIALES");
        semestre4.add("ESTADISTICA");
        semestre4.add("CALCULABILIDAD Y COMPLEJIDAD DE LOS ALGORITMOS");
        semestre4.add("BASE DE DATOS I");
        semestre4.add("SISTEMAS OPERATIVOS II");
        semestre4.add("REDES DE COMUNICACION");
        
        semestre5=new ArrayList<String>();
        semestre5.add("ANALISIS NUMERICO");
        semestre5.add("SIMULACION Y TEORIA DE COLAS");
        semestre5.add("LENGIUAJES Y COMPILADORES");
        semestre5.add("BASE DE DATOS II");
        semestre5.add("SISTEMAS OPERATIVOS III");
        semestre5.add("PROTOCOLOES DE COMUNICACION DE DATOS");
        
        semestre6=new ArrayList<String>();
        semestre6.add("INVESTIGACION OPERATIVA");
        semestre6.add("CONTROL DE LA CALIDAD Y AUDITORIA INFORMATICA");
        semestre6.add("TEORIA DE LA CONFIABILIDAD");
        semestre6.add("MARCOS DE DESARROLLO DE CODIGO ABIERTO");
        semestre6.add("BASE DE DATOS III");
        semestre6.add("SEGURIDAD DE LAS TICS");
        
        semestre7=new ArrayList<String>();
        semestre7.add("CONTABILIDAD FINANCIERA");
        semestre7.add("MODELO DE INVESTIGACION DE OPERACIONES");
        semestre7.add("DISEÑO Y GESTION DE PROCESOS ORGANIZACIONALES");
        semestre7.add("MARCOS DE DESARROLLO DE CODIGO PROPIETARIO");
        semestre7.add("OPATATIVA I");
        semestre7.add("INGENIERIA DE SOFTWARE");
        
        semestre8=new ArrayList<String>();
        semestre8.add("PRINCIPIOS DE ECONOMIA");
        semestre8.add("COMPORTAMIENTO ORGANIZACIONAL");
        semestre8.add("PROGRAMACION WEB");
        semestre8.add("ANALISIS DE DATOS");
        semestre8.add("OPTATIVA II");
        semestre8.add("SISTEMAS DE INFORMACION EMPRESARIAL");
        
        semestre9=new ArrayList<String>();
        semestre9.add("GESTION DE PROYECTOS");
        semestre9.add("GESTION ESTRATEGICA DE LAS TICS");
        semestre9.add("PROGRAMACION DISTRIBUIDA");
        semestre9.add("PROYECTO DE TITULACION");
        semestre9.add("OPTATIVA III");
        semestre9.add("APLICACION DE MINERIA DE DATOS");
       
    }

    public String[] getSelectedSemestre2() {
        return selectedSemestre2;
    }

    public void setSelectedSemestre2(String[] selectedSemestre2) {
        this.selectedSemestre2 = selectedSemestre2;
    }

    public String[] getSelectedSemestre3() {
        return selectedSemestre3;
    }

    public void setSelectedSemestre3(String[] selectedSemestre3) {
        this.selectedSemestre3 = selectedSemestre3;
    }

    public String[] getSelectedSemestre4() {
        return selectedSemestre4;
    }

    public void setSelectedSemestre4(String[] selectedSemestre4) {
        this.selectedSemestre4 = selectedSemestre4;
    }

    public String[] getSelectedSemestre5() {
        return selectedSemestre5;
    }

    public void setSelectedSemestre5(String[] selectedSemestre5) {
        this.selectedSemestre5 = selectedSemestre5;
    }

    public String[] getSelectedSemestre6() {
        return selectedSemestre6;
    }

    public void setSelectedSemestre6(String[] selectedSemestre6) {
        this.selectedSemestre6 = selectedSemestre6;
    }

    public String[] getSelectedSemestre7() {
        return selectedSemestre7;
    }

    public void setSelectedSemestre7(String[] selectedSemestre7) {
        this.selectedSemestre7 = selectedSemestre7;
    }

    public String[] getSelectedSemestre8() {
        return selectedSemestre8;
    }

    public void setSelectedSemestre8(String[] selectedSemestre8) {
        this.selectedSemestre8 = selectedSemestre8;
    }

    public String[] getSelectedSemestre9() {
        
        
        return selectedSemestre9;
        
    }

    public void setSelectedSemestre9(String[] selectedSemestre9) {
        try {
            if (selectedSemestre9 != null ) {
           
            System.out.println("semestre nueve"+selectedSemestre9[0]);
            System.out.println("semestre nueve"+selectedSemestre9[1]);
            System.out.println("semestre nueve"+selectedSemestre9[2]);
            System.out.println("semestre nueve"+selectedSemestre9[3]);
            System.out.println("semestre nueve"+selectedSemestre9[4]);
            System.out.println("semestre nueve"+selectedSemestre9[5]);
        
            
        }
        } catch (Exception e) {
        }
        
        this.selectedSemestre9 = selectedSemestre9;
    }

    
    public String[] getSelectedSemestre1() {
        return selectedSemestre1;
    }

    public void setSelectedSemestre1(String[] selectedSemestre1) {
        this.selectedSemestre1 = selectedSemestre1;
    }
 
     public List<String> getSemestre1() {
        return semestre1;
    }

    public List<String> getSemestre2() {
        return semestre2;
    }

    public List<String> getSemestre3() {
        return semestre3;
    }

    public List<String> getSemestre4() {
        return semestre4;
    }

    public List<String> getSemestre5() {
        return semestre5;
    }

    public List<String> getSemestre6() {
        return semestre6;
    }

    public List<String> getSemestre7() {
        return semestre7;
    }

    public List<String> getSemestre8() {
        return semestre8;
    }

    public List<String> getSemestre9() {
        return semestre9;
    }
 
     
    
}
