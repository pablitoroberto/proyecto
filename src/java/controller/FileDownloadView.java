/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
 
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 
@ManagedBean
public class FileDownloadView {
     
    private StreamedContent file;
    private StreamedContent file1;
     
    public FileDownloadView() {        
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/Formato/Estudiantes.xlsx");
        file = new DefaultStreamedContent(stream, "Formato/xlsx", "Estudiantes.xlsx");
        InputStream stream1 = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/Formato/Docentes.xlsx");
        file1 = new DefaultStreamedContent(stream1, "Formato/xlsx", "Docentes.xlsx");
    }
 
    public StreamedContent getFile() {
        return file;
    }
    
    public StreamedContent getFile1() {
        return file1;
    }
    
}