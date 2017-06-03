package com.ufpa.scontroleportaria.DAO;

import com.ufpa.scontroleportaria.Molde.CollectionClasses;
import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.model.RelatorioF;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Stateless
public class GenericoDAOImpl<T> implements GenericoDAO<T> {

    //Método genérico para persistir Classes que representam entidades
    @Override
    public void save(T entidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(entidade);
        t.commit();
        session.close();
        System.out.println("BACK-END WARNING: OBJECT SAVED! [ public void save(T entidade) ]");
    }

  
    //Método genérico para listar objetos baseado em uma Query HQL
    @Override
    public List<T> list(String sqlHQL) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        org.hibernate.Query query = session.createQuery(sqlHQL);
        List<T> lista = query.list();
        t.commit();
        session.close();
        System.out.println("BACK-END WARNING: LIST RETURNED! [ public List<T> list(String sqlHQL) ]");
        return lista;
    }

    //Método genérico para remoção de uma tupla de uma entidade
    @Override
    public void remove(Object entidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(entidade);
        t.commit();
        session.close();
        System.out.println("BACK-END WARNING: OBJECT REMOVED! [ public void remove(Object entidade) ]");
    }

    //Método genérico para atualizar uma tupla em uma entidade
    @Override
    public void update(Object entidade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(entidade);
        t.commit();
        session.close();
        System.out.println("BACK-END WARNING: OBJECT UPDATED! [ public void update(Object entidade) ]");
    }

    //Método para validação de credenciais de login
    @Override
    public int validate(String username, String password) {
        int resposta = -1;
        username = username.toLowerCase();
        System.out.print(username);
        List<Object> checkLogin = (List<Object>) this.list("select p.pkPessoa from  Pessoa p, User u where p.pkPessoa = u.id.fkPessoa and u.userSenha='" + password + "' and p.exclusaoLogica=0 and (p.email='" + username + "' or u.userNick='" + username + "')");
        try {
            System.out.println("BACK-END WARNING: USER VALIDATED! p.pkPessoa=" + checkLogin.get(0) + "[ public int validate(String username, String password) ]");
            resposta = (int) checkLogin.get(0);
        } catch (Exception ex) {
            System.out.println("BACK-END WARNING: USER NOT FOUND! [ public int validate(String username, String password) ]");
        }
        return resposta;
    }

    @Override
    public List<CollectionClasses> generalSearchList(String searchMode, String search) {
        search = "'%" + search + "%'";

        //---------------------------------------------------------------------

        /*A variável determina o tipo de indivíduo a ser
        pesquisado: proprietário, animal. -----------------------------------*/
        String tipoIndividuo = "";

        switch (searchMode) {
//---------------------------------------------------------------------
            case "nomeFuncionario":
                searchMode = "f.nomeFuncionario";
                tipoIndividuo = "funcionario";
                break;

            case "cpfFuncionario":
                searchMode = "f.cpfFuncionario";
                tipoIndividuo = "funcionario";
                break;

            case "siapeFuncionario":
                searchMode = "f.siapeFuncionario";
                tipoIndividuo = "funcionario";
                break;
//---------------------------------------------------------------------
            case "numeroPortaria":
                searchMode = "p.numeroPortaria";
                tipoIndividuo = "portaria";
                break;

            case "tituloProjetoPortaria":
                searchMode = "p.tituloProjetoPortaria";
                tipoIndividuo = "portaria";
                break;

            case "professorCoordenador":
                searchMode = "p.professorCoordenador";
                tipoIndividuo = "portaria";
                break;

            case "faculdadePortaria":
                searchMode = "p.faculdadePortaria";
                tipoIndividuo = "portaria";
                break;
//---------------------------------------------------------------------
            case "numeroDeProtocolo":
                searchMode = "r.numeroDeProtocolo";
                tipoIndividuo = "relatoriof";
                break;

            case "assinaturaRespEntrega":
                searchMode = "r.assinaturaRespEntrega";
                tipoIndividuo = "relatoriof";
                break;

            case "faculdadeRelatorioF":
                searchMode = "r.faculdadeRelatorioF";
                tipoIndividuo = "relatoriof";
                break;
        }
        List<CollectionClasses> listCollection = new ArrayList<>();

        switch (tipoIndividuo) {
            case "funcionario":
                List<Funcionario> listFuncionario
                        = (List<Funcionario>) this.list("SELECT f from Funcionario f"
                                + " where " + searchMode + " like " + search);

                break;

            case "portaria":
                List<Portaria> listPortaria
                        = (List<Portaria>) this.list("SELECT p from Portaria p"
                                + " where " + searchMode + " like " + search);

                break;

            case "relatoriof":
                List<RelatorioF> listRelatorioF
                        = (List<RelatorioF>) this.list("SELECT r from RelatorioF r"
                                + " where " + searchMode + " like " + search);

                break;
        }

        System.out.println("BACK-END WARNING: LIST RETURNED! [ public List<CollectionClasses> generalSearchList(String searchMode, String search) ]");
        return listCollection;
    }

    @Override
    public List<Funcionario> listBySearchFUNCIONARIO(String searchMode, String search) {
        search = "'%" + search + "%'";

        //---------------------------------------------------------------------

        /*A variável determina o tipo de indivíduo a ser
        pesquisado: proprietário, animal. -----------------------------------*/
        String tipoIndividuo = "";

        switch (searchMode) {
//---------------------------------------------------------------------
            case "nomeFuncionario":
                searchMode = "f.nomeFuncionario";
                tipoIndividuo = "funcionario";
                break;

            case "cpfFuncionario":
                searchMode = "f.cpfFuncionario";
                tipoIndividuo = "funcionario";
                break;

            case "siapeFuncionario":
                searchMode = "f.siapeFuncionario";
                tipoIndividuo = "funcionario";
                break;

        }
        List<Funcionario> listCollection = new ArrayList<>();

        switch (tipoIndividuo) {
            case "funcionario":
                List<Funcionario> listFuncionario
                        = (List<Funcionario>) this.list("select f from Funcionario f where "
                        + searchMode + " like '%" + search + "%'");

                break;
        }
        System.out.println("BACK-END WARNING: LIST RETURNED! [ List<Funcionario> listBySearchFUNCIONARIO(String searchMode, String search) ]");
        return listCollection;
    }

    @Override
    public List<CollectionClasses> listBySearchPORTARIA(String searchMode, String search) {
        search = "'%" + search + "%'";

        //---------------------------------------------------------------------

        /*A variável determina o tipo de indivíduo a ser
        pesquisado: proprietário, animal. -----------------------------------*/
        String tipoIndividuo = "";

        switch (searchMode) {

            case "numeroPortaria":
                searchMode = "p.numeroPortaria";
                tipoIndividuo = "portaria";
                break;

            case "tituloProjetoPortaria":
                searchMode = "p.tituloProjetoPortaria";
                tipoIndividuo = "portaria";
                break;

            case "professorCoordenador":
                searchMode = "p.professorCoordenador";
                tipoIndividuo = "portaria";
                break;

            case "faculdadePortaria":
                searchMode = "p.faculdadePortaria";
                tipoIndividuo = "portaria";
                break;
        }
        List<CollectionClasses> listCollection = new ArrayList<>();

        switch (tipoIndividuo) {

            case "portaria":
                List<Portaria> listPortaria
                        = (List<Portaria>) this.list("select p from Portaria p where "
                        + searchMode + " like '%" + search + "%'");
/*("select p from Portaria p where "
                        + "p." + searchMode + " like '%" + search + "%'");*/
/*("SELECT p from Portaria p"
                                + " where " + searchMode + " like " + search);*/
                
        }
        System.out.println("BACK-END WARNING: LIST RETURNED! [ public List<CollectionClasses> listBySearchPORTARIA(String searchMode, String search) ]");
        return listCollection;
    }

    @Override
    public List<CollectionClasses> listBySearchRELATORIOF(String searchMode, String search) {
        search = "'%" + search + "%'";

        //---------------------------------------------------------------------

        /*A variável determina o tipo de indivíduo a ser
        pesquisado: proprietário, animal. -----------------------------------*/
        String tipoIndividuo = "";

        switch (searchMode) {

            case "numeroDeProtocolo":
                searchMode = "r.numeroDeProtocolo";
                tipoIndividuo = "relatoriof";
                break;

            case "assinaturaRespEntrega":
                searchMode = "r.assinaturaRespEntrega";
                tipoIndividuo = "relatoriof";
                break;

            case "faculdadeRelatorioF":
                searchMode = "r.faculdadeRelatorioF";
                tipoIndividuo = "relatoriof";
                break;
        }
        List<CollectionClasses> listCollection = new ArrayList<>();

        switch (tipoIndividuo) {

            case "relatoriof":
                List<RelatorioF> listRelatorioF
                        = (List<RelatorioF>) this.list("select r from RelatorioF r where "
                        + searchMode + " like '%" + search + "%'");

                break;
        }

        System.out.println("BACK-END WARNING: LIST RETURNED! [ public List<CollectionClasses> listBySearchRELATORIOF(String searchMode, String search) ]");
        return listCollection;
    }
}
