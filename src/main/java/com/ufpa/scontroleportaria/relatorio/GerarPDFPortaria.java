/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.relatorio;


import com.ufpa.scontroleportaria.model.Portaria;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Ramon
 */
public class GerarPDFPortaria {
    
    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;
    private Connection con;

    public GerarPDFPortaria() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }
    
    /*
    defina um parametro: List<Objeto> lista, se usar JavaBean DataSource
    */
    public void getRelatorio(List<Portaria> lista){
        stream = this.getClass().getResourceAsStream("/report/Relatório_Portaria_15_março_2017.jasper");
        Map<String, Object> params = new HashMap<String, Object>();
        baos = new ByteArrayOutputStream();
        
        try {
            
            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            
            /*Para usar JavaBeanDataSource defina: new JRBeanCollectionDataSource(lista)
            mude a string do getResourceAsStream("/report/reportPessoaJavaBeanDS.jasper")
            */
            JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(lista));
            JasperExportManager.exportReportToPdfStream(print, baos);
            
            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=Portaria.pdf");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            context.responseComplete();
            fecharConexao();
            
        } catch (JRException ex) {
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public Connection getConexao(){        
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ControledePortarias?zeroDateTimeBehavior=convertToNull", "root", "root");
            return con;
            
        } catch (SQLException ex) {
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    public void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
