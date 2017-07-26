package com.ufpa.scontroleportaria.model;
// Generated 26/07/2017 09:37:50 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Funcionario generated by hbm2java
 */
@Entity
@Table(name="Funcionario"
    ,catalog="SControlePortaria"
)
public class Funcionario  implements java.io.Serializable {


     private Integer pkFuncionario;
     private String nomeFuncionario;
     private Integer siapeFuncionario;
     private String cpfFuncionario;
     private String senhaFuncionario;
     private Date dataNascimentoFuncionario;
     private String emailFuncionario;
     private String tipoFuncionario;
     private Set<FuncionarioHasPortaria> funcionarioHasPortarias = new HashSet<FuncionarioHasPortaria>(0);

    public Funcionario() {
    }

    public Funcionario(String nomeFuncionario, Integer siapeFuncionario, String cpfFuncionario, String senhaFuncionario, Date dataNascimentoFuncionario, String emailFuncionario, String tipoFuncionario, Set<FuncionarioHasPortaria> funcionarioHasPortarias) {
       this.nomeFuncionario = nomeFuncionario;
       this.siapeFuncionario = siapeFuncionario;
       this.cpfFuncionario = cpfFuncionario;
       this.senhaFuncionario = senhaFuncionario;
       this.dataNascimentoFuncionario = dataNascimentoFuncionario;
       this.emailFuncionario = emailFuncionario;
       this.tipoFuncionario = tipoFuncionario;
       this.funcionarioHasPortarias = funcionarioHasPortarias;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="PK_funcionario", unique=true, nullable=false)
    public Integer getPkFuncionario() {
        return this.pkFuncionario;
    }
    
    public void setPkFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    
    @Column(name="nomeFuncionario", length=45)
    public String getNomeFuncionario() {
        return this.nomeFuncionario;
    }
    
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    
    @Column(name="siapeFuncionario")
    public Integer getSiapeFuncionario() {
        return this.siapeFuncionario;
    }
    
    public void setSiapeFuncionario(Integer siapeFuncionario) {
        this.siapeFuncionario = siapeFuncionario;
    }

    
    @Column(name="cpfFuncionario", length=45)
    public String getCpfFuncionario() {
        return this.cpfFuncionario;
    }
    
    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    
    @Column(name="senhaFuncionario", length=100)
    public String getSenhaFuncionario() {
        return this.senhaFuncionario;
    }
    
    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="dataNascimentoFuncionario", length=10)
    public Date getDataNascimentoFuncionario() {
        return this.dataNascimentoFuncionario;
    }
    
    public void setDataNascimentoFuncionario(Date dataNascimentoFuncionario) {
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
    }

    
    @Column(name="emailFuncionario", length=45)
    public String getEmailFuncionario() {
        return this.emailFuncionario;
    }
    
    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    
    @Column(name="tipoFuncionario", length=45)
    public String getTipoFuncionario() {
        return this.tipoFuncionario;
    }
    
    public void setTipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario")
    public Set<FuncionarioHasPortaria> getFuncionarioHasPortarias() {
        return this.funcionarioHasPortarias;
    }
    
    public void setFuncionarioHasPortarias(Set<FuncionarioHasPortaria> funcionarioHasPortarias) {
        this.funcionarioHasPortarias = funcionarioHasPortarias;
    }




}


