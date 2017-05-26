/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpa.scontroleportaria.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author andreismiths
 */
@ManagedBean(name = "MBpesquisa")
@ViewScoped
public class MBpesquisa extends AbstractBean {

    private String textoPesquisa;
    private String itemPesquisa = "nomeFuncionario";

    private boolean showDataTable;
    private boolean showDataTableFuncionario;
    private boolean showDataTablePortaria;
    private boolean showDataTableRelatorioF;

    private List<?> objBuscados;
    private String searchMask = "";
    private String searchTip = (itemPesquisa.equals("nome")) ? "Ex: Tássio" : "Ex: Luciana";
    private String maxLength = "100";

    /*O método determina a mascara, mensagem 
    de ajuda e o length do input de pesquisa*/
    public void changeMask() {
        textoPesquisa = "";
        switch (itemPesquisa) {
            case "nomeFuncionario":
                searchMask = "";
                searchTip = (itemPesquisa.equals("nome")) ? "Ex: Tássio" : "Ex: Luciana";
                maxLength = "100";
                break;
            case "cpfFuncionario":
                searchMask = "999.999.999-99";
                searchTip = "Ex: 999.999.999-99";
                maxLength = "14";
                break;
            case "siapeFuncionario":
                searchMask = "99.999.999";
                searchTip = "Ex: 99.999.999";
                maxLength = "10";
                break;
                
                
            case "numeroPortaria":
                searchMask = "001/2017";
                searchTip = "Ex: 001/2017";
                maxLength = "8";
                break;
            case "tituloProjetoPortaria":
                searchMask = "";
                searchTip = "Ex: Projeto de Iniciação..";
                maxLength = "10";
                break;
            case "professorCoordenador":
                searchMask = "";
                searchTip = "Ex: Tássio Carvalho";
                maxLength = "100";
                break;
            case "faculdadePortaria":
                searchMask = "";
                searchTip = "Ex: Computação";
                maxLength = "30";
                break;

                
            case "numeroDeProtocolo":
                searchMask = "001/2017";
                searchTip = "Ex: 001/2017";
                maxLength = "8";
                break;
            case "assinaturaRespEntrega":
                searchMask = "";
                searchTip = "Ex: José Jailton";
                maxLength = "50";
                break;
            case "faculdadeRelatorioF":
                searchMask = "";
                searchTip = "Ex: Computação";
                maxLength = "30";
                break;
        }
    }

    /*O método faz:
    Atribui um tipo de objeto especifico para objGenerico;
    Atribui um tipo de List especifico para objBuscados;
    Realiza a busca por objetos através de itemPesquisa e textoPesquisa.*/
    public void ListagemITENS(String item) {

        switch (item) {
            case "Funcionario":
                objBuscados = getDaoGenerico().listBySearchFUNCIONARIO(itemPesquisa, textoPesquisa);
                break;
            case "Portaria":
                objBuscados = getDaoGenerico().listBySearchPORTARIA(itemPesquisa, textoPesquisa);
                break;
            case "RelatórioF":
                objBuscados = getDaoGenerico().listBySearchRELATORIOF(itemPesquisa, textoPesquisa);
                break;
            default:
                getObjMessage().warn("Erro ao listar!", "Item não encontrado.");
                break;
        }

        if (objBuscados.isEmpty()) {
            this.showDataTableFuncionario = false;
            this.showDataTablePortaria = false;
            this.showDataTableRelatorioF = false;
            getObjMessage().warn("Lista vazia!", "Item não encontrado.");
        } else {
            this.showDataTable = true;
        }
    }

    /*O método identifica que tabela de dados será exibida através de 
    variáveis booleanas, ele também verifica a quantidade máxima de 
    caracteres escritos no input de pesquisa, e cancela a operação 
    caso extrapole o valor máximo informando, este método utiliza a 
    listagem “generalSearchList” da classe GenericoDAOImpl*/
    public void multipleItemList() {
        showDataTableFuncionario = false;
        showDataTablePortaria = false;
        showDataTableRelatorioF = false;

        if (maximumCharacters(100, textoPesquisa)) {
            objBuscados = getDaoGenerico().generalSearchList(itemPesquisa, textoPesquisa);
            boolean fullList = (objBuscados.size() > 0);

            switch (itemPesquisa) {
                case "nomeFuncionario":
                case "cpfFuncionario":
                case "siapeFuncionario":
                    showDataTableFuncionario = fullList;
                    break;

                case "numeroPortaria":
                case "tituloProjetoPortaria":
                case "professorCoordenador":
                case "faculdadePortaria":
                    showDataTablePortaria = fullList;
                    break;

                case "numeroDeProtocolo":
                case "assinaturaRespEntrega":
                case "faculdadeRelatorioF":
                    showDataTableRelatorioF = fullList;
                    break;
                default:
                    break;
            }
            if (!fullList) {
                getObjMessage().warn("Listagem vazia!", "Item não encontrado.");
            }
        } else {
            getObjMessage().warn("Dados inapropriados!", "O sistema não aceita a quantidade de caracteres inseridos.");
        }
    }

    /* O método verifica a quantidade de caracteres
    inseridos no input e compara com a quantidade
    máxima informada, retornando true caso verdadeiro,
    identificado se o texto informado possui um
    tamanho abusivo de caracteres */
    private boolean maximumCharacters(int num, String text) {
        return text.length() <= num;
    }

    //gets e setts
    public String getTextoPesquisa() {
        return textoPesquisa;
    }

    public void setTextoPesquisa(String textoPesquisa) {
        this.textoPesquisa = textoPesquisa;
    }

    public String getItemPesquisa() {
        return itemPesquisa;
    }

    public void setItemPesquisa(String itemPesquisa) {
        this.itemPesquisa = itemPesquisa;
    }

    public boolean isShowDataTable() {
        return showDataTable;
    }

    public void setShowDataTable(boolean showDataTable) {
        this.showDataTable = showDataTable;
    }

    public boolean isShowDataTableFuncionario() {
        return showDataTableFuncionario;
    }

    public boolean isShowDataTablePortaria() {
        return showDataTablePortaria;
    }

    public boolean isShowDataTableRelatorioF() {
        return showDataTableRelatorioF;
    }

    public List<?> getObjBuscados() {
        return objBuscados;
    }

    public void setObjBuscados(List<?> objBuscados) {
        this.objBuscados = objBuscados;
    }

    public String getSearchMask() {
        return searchMask;
    }

    public void setSearchMask(String searchMask) {
        this.searchMask = searchMask;
    }

    public String getSearchTip() {
        return searchTip;
    }

    public void setSearchTip(String searchTip) {
        this.searchTip = searchTip;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
    }

}
