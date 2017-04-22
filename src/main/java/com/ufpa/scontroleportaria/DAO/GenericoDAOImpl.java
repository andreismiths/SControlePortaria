package com.ufpa.scontroleportaria.DAO;


import com.ufpa.scontroleportaria.model.Funcionario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Stateless
public class GenericoDAOImpl<T> implements GenericoDAO<T> {

//	protected HashMap<String, Object> parametros(Object... valores) {
//		List<Object> par = Arrays.asList(valores);
//
//		HashMap<String, Object> parametros = new HashMap<>();
//
//		for (int i = 0; i < par.size() - 1; i = i + 2) {
//			parametros.put(par.get(i).toString(), par.get(i + 1));
//		}
//		return parametros;
//	}
    /**
     *
     * @param entidade
     */
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

    //Método genérico para recuperação de objetos do banco de dados
    @Override
    public T getById(String model, Integer id) {
        List<T> getObject = new java.util.ArrayList<T>();
        String idType = "pk";
        if (model.equals("User") || model.equals("Animais") || model.equals("Cliente")) {
            idType = "id.pk";
        }
        getObject = this.list("SELECT o from " + model + " o where o." + idType + model + "=" + id);
        System.out.println("BACK-END WARNING: LIST RETURNED! [ public T getById(String model, Integer id) ]");
        return (T) getObject.get(0);
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

    //Método para listar os nomes de pelagens inseridas no banco de dados
    @Override
    public List<String> getPelagemNames() {
        List<String> listaPelagens = new ArrayList<>();
        for (Object obj : (List<Object>) this.list("SELECT pl.nomePelagem from Pelagem pl")) {
            listaPelagens.add((String) obj);
        }
        System.out.println("BACK-END WARNING: LIST RETURNED! [ public List<String> getPelagemNames() ]");
        return listaPelagens;
    }

    @Override
    public List<T> list(T entidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Funcionario> listBySearchPESSOA(String searchMode, String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
