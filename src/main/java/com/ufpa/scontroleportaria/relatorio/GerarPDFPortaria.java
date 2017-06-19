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
 * @author andreismiths
 */
public class GerarPDFPortaria {
    
    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;
    private Connection con;

    public void gerarPDFPortaria() {
        System.out.println("Entrou no GerarPortaria");
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }
    
    /*
    defina um parametro: List<Objeto> lista, se usar JavaBean DataSource
    */
    public void getRelatorioUmaLinha(List<Portaria> listaPDFPortaria){
        System.out.println("Entrou no GetRelatorio");
        stream = this.getClass().getResourceAsStream("/com/ufpa/scontroleportaria/report/PortariaPDF_scontroleportaria_19_Maio_2017.jasper");
        System.out.println("Passou do Stream");
        Map<String, Object> params = new HashMap<String, Object>();
        System.out.println("Passou do Map<string, object>");
        baos = new ByteArrayOutputStream();
        System.out.println("Passou do baos");
        try {
            System.out.println("Entrou no try");
            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            System.out.println("Passou do JasperReport");
            /*Para usar JavaBeanDataSource defina: new JRBeanCollectionDataSource(lista)
            mude a string do getResourceAsStream("/report/reportPessoaJavaBeanDS.jasper")
            */
            JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(listaPDFPortaria));
            System.out.println("Passou do JasperPrint nova Lista");
            JasperExportManager.exportReportToPdfStream(print, baos);
            System.out.println("Passou do exportar para pdf");
            response.reset();
            System.out.println("Passou do reset");
            response.setContentType("application/pdf");
            System.out.println("Passou do content type");
            response.setContentLength(baos.size());
            System.out.println("Passou do content length");
            response.setHeader("Content-disposition", "inline; filename=Portaria.pdf");
            System.out.println("Passou do setheader");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            context.responseComplete();
            fecharConexao();
            
        } catch (JRException ex) {
            System.out.println("Entrou no catch  1");
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Entrou no catch  2");
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
     public void getRelatorioTodas(){
        System.out.println("Entrou no GetRelatorioTodas");
        stream = this.getClass().getResourceAsStream("/com/ufpa/scontroleportaria/report/LISTAR_TODAS_PortariaPDF_scontroleportaria_19_Maio_2017.jasper");
        System.out.println("Passou do Stream");
        Map<String, Object> params = new HashMap<String, Object>();
        System.out.println("Passou do Map<string, object>");
        baos = new ByteArrayOutputStream();
        System.out.println("Passou do baos");
        try {
            System.out.println("Entrou no try");
            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            System.out.println("Passou do JasperReport");
            /*Para usar JavaBeanDataSource defina: new JRBeanCollectionDataSource(lista)
            mude a string do getResourceAsStream("/report/reportPessoaJavaBeanDS.jasper")
            */
            JasperPrint print = JasperFillManager.fillReport(report, params, getConexao());
            System.out.println("Passou do JasperPrint nova Lista");
            JasperExportManager.exportReportToPdfStream(print, baos);
            System.out.println("Passou do exportar para pdf");
            response.reset();
            System.out.println("Passou do reset");
            response.setContentType("application/pdf");
            System.out.println("Passou do content type");
            response.setContentLength(baos.size());
            System.out.println("Passou do content length");
            response.setHeader("Content-disposition", "inline; filename=Portaria.pdf");
            System.out.println("Passou do setheader");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            context.responseComplete();
            fecharConexao();
            
        } catch (JRException ex) {
            System.out.println("Entrou no catch  1");
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Entrou no catch  2");
            Logger.getLogger(GerarPDFPortaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public Connection getConexao(){        
        try {            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SControlePortaria?zeroDateTimeBehavior=convertToNull", "root", "root");
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
