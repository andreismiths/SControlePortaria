package com.ufpa.scontroleportaria.DAO;

import com.ufpa.scontroleportaria.model.Funcionario;
import com.ufpa.scontroleportaria.model.Portaria;
import com.ufpa.scontroleportaria.model.RelatorioF;

import java.util.List;

public interface GenericoDAO<T> {

    public void save(T entidade);

    public List<T> list(String sqlHQL);

    public List<Funcionario> listBySearchFUNCIONARIO(String searchMode, String search);

    public List<Portaria> listBySearchPORTARIA(String searchMode, String search);

    public List<RelatorioF> listBySearchRELATORIOF(String searchMode, String search);

    public List<Portaria> listBySearchPORTARIAVigencia(String searchMode, String search, String search2);

    public void remove(Object entidade);

    public void update(Object entidade);

    public int validate(String username, String password);

    public List<String> getNameProfessor();
    

//        void inserir(T entidade);
//    
//	T atualizar(T entidade);
//
//	void remover(T entidade);
//
//	T getPorId(Object id) throws EntityNotFoundException;
//
//	List<T> listar();
//
//	List<T> listar(Class<T> tipo, String campoOrdem);
//
//	int executa(String consulta, Object... valores);
//
//	int executa(String sql);
//
//	List<T> consultaUsuario(Class<T> tipo, String campo, String sql);
//
//	TypedQuery<T> criarConsulta(String sql, Object... valores);
//
//	TypedQuery<T> criarConsulta(String sql, int maxResults);
//
//	TypedQuery<T> criarConsultaAPartir(String sql, int firstResults);
//
//	TypedQuery<T> criarConsulta(String sql, int firstResults, int maxResults);
//
//	TypedQuery<T> criarConsulta(String sql, int maxResults, Object... valores);
//
//	TypedQuery<T> criarConsulta(String sql, int firstResults, int maxResults, Object... valores);
//
//	T get(String sql);
//
//	T get(String sql, Object... valores);
//
//	List<T> listar(String sql);
//
//	List<T> listar(String sql, Object... valores);
//
//	List<T> listarNoMaximo(String sql, int maxResults);
//
//	List<T> listarNoMaximo(String sql, int maxResults, Object... valores);
//
//	List<T> listarAPartir(String sql, int firstResults);
//
//	List<T> subListar(String sql, int firstResults, int maxResults);
//
//	List<T> subListar(String sql, int firstResults, int maxResults, Object... valores);
//
//	Long count(Class<T> tipo);
//
//	TypedQuery<T> criarConsulta(String sql, Map<String, Object> parametros);
//
//	T get(String namedQuery, Map<String, Object> parametros) throws NoResultException;
//
//	List<T> listar(String sql, Map<String, Object> parametros);
}
