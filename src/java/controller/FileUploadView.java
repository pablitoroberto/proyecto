/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
public class FileUploadView {

    UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private String destination = "D:\\tmp\\";

    public void uploadEstudiantes(FileUploadEvent event) throws SQLException, ClassNotFoundException {

        //
        FacesMessage msg = new FacesMessage("Éxito! ", event.getFile().getFileName() + " está cargado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        if (event.getFile().getFileName().equals("Estudiantes.xlxs")) {
            FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
        }
        // Do what you want with the file        
        try {

            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            if (event.getFile().getFileName().equals("Estudiantes.xlxs")) {
                FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Username and Passowrd",
                                "Please enter correct username and Password"));
            }

            String fileName = destination + event.getFile().getFileName();
            File File1 = new File(fileName);
            FileInputStream fileInputStream;
            Workbook workbook = null;
            Sheet sheet;
            Iterator<Row> rowIterator;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios", "root", "");
                con.setAutoCommit(false);
                PreparedStatement pstm = null;
                fileInputStream = new FileInputStream(File1);
                String fileExtension = fileName.substring(fileName.indexOf("."));
                System.out.println(fileExtension);
                if (fileExtension.equals(".xls")) {
                    workbook = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
                } else if (fileExtension.equals(".xlsx")) {
                    workbook = new XSSFWorkbook(fileInputStream);
                } else {
                    System.out.println("Wrong File Type");
                }
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                sheet = workbook.getSheetAt(0);
                rowIterator = sheet.iterator();

                Row row;
                int i;
                for (i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);

                    String APELLIDO_PATERNO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(0)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(0).getNumericCellValue() + " ");
                            APELLIDO_PATERNO = Integer.toString((int) row.getCell(0).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(0).getStringCellValue() + " ");
                            APELLIDO_PATERNO = row.getCell(0).getStringCellValue();
                            break;
                    }

                    String APELLIDO_MATERNO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(1)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(1).getNumericCellValue() + " ");
                            APELLIDO_MATERNO = Integer.toString((int) row.getCell(1).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(1).getStringCellValue() + " ");
                            APELLIDO_MATERNO = row.getCell(1).getStringCellValue();
                            break;
                    }

                    String NOMBRES = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(2)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(2).getNumericCellValue() + " ");
                            NOMBRES = Integer.toString((int) row.getCell(2).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(2).getStringCellValue() + " ");
                            NOMBRES = row.getCell(2).getStringCellValue();
                            break;
                    }
                    String CEDULA = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(3)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(3).getNumericCellValue() + " ");
                            CEDULA = Integer.toString((int) row.getCell(3).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(3).getStringCellValue() + " ");
                            CEDULA = row.getCell(3).getStringCellValue();
                            break;
                    }

                    String CARRERA = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(4)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(4).getNumericCellValue() + " ");
                            CARRERA = Integer.toString((int) row.getCell(4).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(4).getStringCellValue() + " ");
                            CARRERA = row.getCell(4).getStringCellValue();
                            break;
                    }
                    String CURSO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(5)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(5).getNumericCellValue() + " ");
                            CURSO = Integer.toString((int) row.getCell(5).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(5).getStringCellValue() + " ");
                            CURSO = row.getCell(5).getStringCellValue();
                            break;
                    }
                    String CODIGOMATRICULA = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(6)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(6).getNumericCellValue() + " ");
                            CODIGOMATRICULA = Integer.toString((int) row.getCell(6).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(6).getStringCellValue() + " ");
                            CODIGOMATRICULA = row.getCell(6).getStringCellValue();
                            break;
                    }
                    String DIRECCION = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(7)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(7).getNumericCellValue() + " ");
                            DIRECCION = Integer.toString((int) row.getCell(7).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(7).getStringCellValue() + " ");
                            DIRECCION = row.getCell(7).getStringCellValue();
                            break;
                    }
                    String TELEFONO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(8)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(8).getNumericCellValue() + " ");
                            TELEFONO = Integer.toString((int) row.getCell(8).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(8).getStringCellValue() + " ");
                            TELEFONO = row.getCell(8).getStringCellValue();
                            break;
                    }
                    String CELULAR = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(9)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(9).getNumericCellValue() + " ");
                            CELULAR = Integer.toString((int) row.getCell(9).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(9).getStringCellValue() + " ");
                            CELULAR = row.getCell(9).getStringCellValue();
                            break;
                    }

                    String CORREO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(10)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(10).getNumericCellValue() + " ");
                            CORREO = Integer.toString((int) row.getCell(10).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(10).getStringCellValue() + " ");
                            CORREO = row.getCell(10).getStringCellValue();
                            break;
                    }
                    String CORREOUCE = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(11)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(11).getNumericCellValue() + " ");
                            CORREOUCE = Integer.toString((int) row.getCell(11).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(11).getStringCellValue() + " ");
                            CORREOUCE = row.getCell(11).getStringCellValue();
                            break;
                    }
                    String CORREOCONTACTO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(12)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(12).getNumericCellValue() + " ");
                            CORREOCONTACTO = Integer.toString((int) row.getCell(12).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(12).getStringCellValue() + " ");
                            CORREOCONTACTO = row.getCell(12).getStringCellValue();
                            break;
                    }
                    String ESTADOCIVIL = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(13)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(13).getNumericCellValue() + " ");
                            ESTADOCIVIL = Integer.toString((int) row.getCell(13).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(13).getStringCellValue() + " ");
                            ESTADOCIVIL = row.getCell(13).getStringCellValue();
                            break;
                    }
                    String PAIS = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(14)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(14).getNumericCellValue() + " ");
                            PAIS = Integer.toString((int) row.getCell(14).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(14).getStringCellValue() + " ");
                            PAIS = row.getCell(14).getStringCellValue();
                            break;
                    }
                    String PROVINCIA = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(15)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(15).getNumericCellValue() + " ");
                            PROVINCIA = Integer.toString((int) row.getCell(15).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(15).getStringCellValue() + " ");
                            PROVINCIA = row.getCell(15).getStringCellValue();
                            break;
                    }
                    String CANTON = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(16)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(16).getNumericCellValue() + " ");
                            CANTON = Integer.toString((int) row.getCell(16).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(16).getStringCellValue() + " ");
                            CANTON = row.getCell(16).getStringCellValue();
                            break;
                    }
                    String SEXO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(17)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(17).getNumericCellValue() + " ");
                            SEXO = Integer.toString((int) row.getCell(17).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(17).getStringCellValue() + " ");
                            SEXO = row.getCell(17).getStringCellValue();
                            break;
                    }
                    String NACIONALIDAD = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(18)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(18).getNumericCellValue() + " ");
                            NACIONALIDAD = Integer.toString((int) row.getCell(18).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(18).getStringCellValue() + " ");
                            NACIONALIDAD = row.getCell(18).getStringCellValue();
                            break;
                    }

                 //CI= Integer.toString((int) row.getCell(1).getNumericCellValue());
                    String sql = "INSERT INTO ESTUDIANTE (APELLIDO_PATERNO,APELLIDO_MATERNO,NOMBRES,CEDULA,CARRERA,CURSO,CODIGO_MATRICULA,DIRECCION,TELEFONO,CELULAR,CORREO,CORREO_UCE,CORREO_CONTACTO,ESTADO_CIVIL,PAIS,PROVINCIA,CANTON,SEXO,NACIONALIDAD) "
                            + "VALUES('" + APELLIDO_PATERNO + "','" + APELLIDO_MATERNO + "','" + NOMBRES + "','" + CEDULA + "','" + CARRERA + "','" + CURSO + "','" + CODIGOMATRICULA + "','" + DIRECCION + "','" + TELEFONO + "','" + CELULAR + "','" + CORREO + "','" + CORREOUCE + "','" + CORREOCONTACTO
                            + "','" + ESTADOCIVIL + "','" + PAIS + "','" + PROVINCIA + "','" + CANTON + "','" + SEXO + "','" + NACIONALIDAD + "')";
                    pstm = (PreparedStatement) con.prepareStatement(sql);
                    pstm.execute();
                    System.out.println("Import rows " + i);
                }
                i--;
                FacesMessage msg1 = new FacesMessage("Se han cargado  : ", +i + " Docenntes");
                FacesContext.getCurrentInstance().addMessage(null, msg1);
                con.commit();
                pstm.close();
                con.close();
                fileInputStream.close();
                System.out.println("Success import excel to mysql table");

            } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void uploadDocente(FileUploadEvent event) throws SQLException, ClassNotFoundException {

        //
        FacesMessage msg = new FacesMessage("Éxito! ", event.getFile().getFileName() + " está cargado.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        

        // Do what you want with the file        
        try {

            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
            //readExcelFile(destination+event.getFile().getFileName());
            String fileName = destination + event.getFile().getFileName();
            File File1 = new File(fileName);
            FileInputStream fileInputStream;
            Workbook workbook = null;
            Sheet sheet;
            Iterator<Row> rowIterator;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios", "root", "");
                con.setAutoCommit(false);
                PreparedStatement pstm = null;
                fileInputStream = new FileInputStream(File1);
                String fileExtension = fileName.substring(fileName.indexOf("."));
                System.out.println(fileExtension);
                if (fileExtension.equals(".xls")) {
                    workbook = new HSSFWorkbook(new POIFSFileSystem(fileInputStream));
                } else if (fileExtension.equals(".xlsx")) {
                    workbook = new XSSFWorkbook(fileInputStream);
                } else {
                    System.out.println("Wrong File Type");
                }
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                sheet = workbook.getSheetAt(0);
                rowIterator = sheet.iterator();

                Row row;
                int i;
                for (i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);

                    String NOMBRE = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(0)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(0).getNumericCellValue() + " ");
                            NOMBRE = Integer.toString((int) row.getCell(0).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(0).getStringCellValue() + " ");
                            NOMBRE = row.getCell(0).getStringCellValue();
                            break;
                    }
                    String CI = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(1)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero " + row.getCell(1).getNumericCellValue() + " ");
                            CI = Integer.toString((int) row.getCell(1).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO " + row.getCell(1).getStringCellValue() + " ");
                            CI = row.getCell(1).getStringCellValue();
                            break;
                    }

                    //CI= Integer.toString((int) row.getCell(1).getNumericCellValue());
                    String EMAIL_INST = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(2)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero "+row.getCell(2).getNumericCellValue() + " ");
                            EMAIL_INST= Integer.toString((int) row.getCell(2).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO "+row.getCell(2).getStringCellValue() + " ");
                            EMAIL_INST= row.getCell(2).getStringCellValue();
                            break;
                }
                    String EMAIL_PERSO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(3)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero "+row.getCell(3).getNumericCellValue() + " ");
                            EMAIL_PERSO= Integer.toString((int) row.getCell(3).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO "+row.getCell(3).getStringCellValue() + " ");
                            EMAIL_PERSO= row.getCell(3).getStringCellValue();
                            break;
                }
                    String CATEGORIA = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(4)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero "+row.getCell(4).getNumericCellValue() + " ");
                            CATEGORIA= Integer.toString((int) row.getCell(4).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO "+row.getCell(4).getStringCellValue() + " ");
                            CATEGORIA= row.getCell(4).getStringCellValue();
                            break;
                }
                    String DEDICACION = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(5)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero "+row.getCell(5).getNumericCellValue() + " ");
                            DEDICACION= Integer.toString((int) row.getCell(5).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO "+row.getCell(5).getStringCellValue() + " ");
                            DEDICACION= row.getCell(5).getStringCellValue();
                            break;
                }
                    String ESTADO = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(6)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero "+row.getCell(6).getNumericCellValue() + " ");
                            ESTADO= Integer.toString((int) row.getCell(6).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO "+row.getCell(6).getStringCellValue() + " ");
                            ESTADO= row.getCell(6).getStringCellValue();
                            break;
                }
                    String TIEMPO_HORA = "";
                    switch (evaluator.evaluateInCell((Cell) row.getCell(7)).getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print("numero "+row.getCell(7).getNumericCellValue() + " ");
                            TIEMPO_HORA= Integer.toString((int) row.getCell(7).getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print("TEXTO "+row.getCell(7).getStringCellValue() + " ");
                            TIEMPO_HORA= row.getCell(7).getStringCellValue();
                            break;
                }
                    
                    String sql = "INSERT INTO DOCENTE (NOMBRE,CI,EMAIL_INSTITUCIONAL,EMAIL_PERSONAL,CATEGORIA,DEDICACION,ESTADO,TIEMPOHORA) VALUES('" + NOMBRE + "','" + CI + "','" + EMAIL_INST + "','" + EMAIL_PERSO + "','" + CATEGORIA + "','" + DEDICACION + "','" + ESTADO + "','" + TIEMPO_HORA + "')";
                    pstm = (PreparedStatement) con.prepareStatement(sql);
                    pstm.execute();
                    System.out.println("Import rows " + i);
                }
                i--;
                FacesMessage msg1 = new FacesMessage("Se han cargado  : ", +i + " Docenntes");
                FacesContext.getCurrentInstance().addMessage(null, msg1);
                con.commit();
                pstm.close();
                con.close();
                fileInputStream.close();
                System.out.println("Success import excel to mysql table");

            } catch (FileNotFoundException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFile(String fileName, InputStream in) {
        try {

            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
