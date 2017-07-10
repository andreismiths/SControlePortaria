package com.ufpa.scontroleportaria.model;
// Generated 09/07/2017 11:02:20 by Hibernate Tools 4.3.1


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
 * Portaria generated by hbm2java
 */
@Entity
@Table(name="Portaria"
    ,catalog="SControlePortaria"
)
public class Portaria  implements java.io.Serializable {


     private Integer pkPortaria;
     private String numeroPortaria;
     private String ementaPortaria;
     private String projetoPortaria;
     private String tituloProjetoPortaria;
     private String faculdadePortaria;
     private String professorCoordenador;
     private String siapeCoordenador;
     private Date inicioVigencia;
     private Date fimVigencia;
     private String colaborador1;
     private String siapeColaborador1;
     private String colaborador2;
     private String siapeColaborador2;
     private String colaborador3;
     private String siapeColaborador3;
     private String statusPortaria;
     private Set<FuncionarioHasPortaria> funcionarioHasPortarias = new HashSet<FuncionarioHasPortaria>(0);

    public Portaria() {
    }

	
    public Portaria(String numeroPortaria, String ementaPortaria, String projetoPortaria, String tituloProjetoPortaria, String faculdadePortaria, String professorCoordenador, String siapeCoordenador, Date inicioVigencia, Date fimVigencia, String statusPortaria) {
        this.numeroPortaria = numeroPortaria;
        this.ementaPortaria = ementaPortaria;
        this.projetoPortaria = projetoPortaria;
        this.tituloProjetoPortaria = tituloProjetoPortaria;
        this.faculdadePortaria = faculdadePortaria;
        this.professorCoordenador = professorCoordenador;
        this.siapeCoordenador = siapeCoordenador;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
        this.statusPortaria = statusPortaria;
    }
    public Portaria(String numeroPortaria, String ementaPortaria, String projetoPortaria, String tituloProjetoPortaria, String faculdadePortaria, String professorCoordenador, String siapeCoordenador, Date inicioVigencia, Date fimVigencia, String colaborador1, String siapeColaborador1, String colaborador2, String siapeColaborador2, String colaborador3, String siapeColaborador3, String statusPortaria, Set<FuncionarioHasPortaria> funcionarioHasPortarias) {
       this.numeroPortaria = numeroPortaria;
       this.ementaPortaria = ementaPortaria;
       this.projetoPortaria = projetoPortaria;
       this.tituloProjetoPortaria = tituloProjetoPortaria;
       this.faculdadePortaria = faculdadePortaria;
       this.professorCoordenador = professorCoordenador;
       this.siapeCoordenador = siapeCoordenador;
       this.inicioVigencia = inicioVigencia;
       this.fimVigencia = fimVigencia;
       this.colaborador1 = colaborador1;
       this.siapeColaborador1 = siapeColaborador1;
       this.colaborador2 = colaborador2;
       this.siapeColaborador2 = siapeColaborador2;
       this.colaborador3 = colaborador3;
       this.siapeColaborador3 = siapeColaborador3;
       this.statusPortaria = statusPortaria;
       this.funcionarioHasPortarias = funcionarioHasPortarias;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="PK_portaria", unique=true, nullable=false)
    public Integer getPkPortaria() {
        return this.pkPortaria;
    }
    
    public void setPkPortaria(Integer pkPortaria) {
        this.pkPortaria = pkPortaria;
    }

    
    @Column(name="numeroPortaria", nullable=false, length=45)
    public String getNumeroPortaria() {
        return this.numeroPortaria;
    }
    
    public void setNumeroPortaria(String numeroPortaria) {
        this.numeroPortaria = numeroPortaria;
    }

    
    @Column(name="ementaPortaria", nullable=false, length=45)
    public String getEmentaPortaria() {
        return this.ementaPortaria;
    }
    
    public void setEmentaPortaria(String ementaPortaria) {
        this.ementaPortaria = ementaPortaria;
    }

    
    @Column(name="projetoPortaria", nullable=false, length=45)
    public String getProjetoPortaria() {
        return this.projetoPortaria;
    }
    
    public void setProjetoPortaria(String projetoPortaria) {
        this.projetoPortaria = projetoPortaria;
    }

    
    @Column(name="tituloProjetoPortaria", nullable=false, length=45)
    public String getTituloProjetoPortaria() {
        return this.tituloProjetoPortaria;
    }
    
    public void setTituloProjetoPortaria(String tituloProjetoPortaria) {
        this.tituloProjetoPortaria = tituloProjetoPortaria;
    }

    
    @Column(name="faculdadePortaria", nullable=false, length=45)
    public String getFaculdadePortaria() {
        return this.faculdadePortaria;
    }
    
    public void setFaculdadePortaria(String faculdadePortaria) {
        this.faculdadePortaria = faculdadePortaria;
    }

    
    @Column(name="professorCoordenador", nullable=false, length=45)
    public String getProfessorCoordenador() {
        return this.professorCoordenador;
    }
    
    public void setProfessorCoordenador(String professorCoordenador) {
        this.professorCoordenador = professorCoordenador;
    }

    
    @Column(name="siapeCoordenador", nullable=false, length=45)
    public String getSiapeCoordenador() {
        return this.siapeCoordenador;
    }
    
    public void setSiapeCoordenador(String siapeCoordenador) {
        this.siapeCoordenador = siapeCoordenador;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="inicioVigencia", nullable=false, length=10)
    public Date getInicioVigencia() {
        return this.inicioVigencia;
    }
    
    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fimVigencia", nullable=false, length=10)
    public Date getFimVigencia() {
        return this.fimVigencia;
    }
    
    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    
    @Column(name="colaborador1", length=45)
    public String getColaborador1() {
        return this.colaborador1;
    }
    
    public void setColaborador1(String colaborador1) {
        this.colaborador1 = colaborador1;
    }

    
    @Column(name="siapeColaborador1", length=45)
    public String getSiapeColaborador1() {
        return this.siapeColaborador1;
    }
    
    public void setSiapeColaborador1(String siapeColaborador1) {
        this.siapeColaborador1 = siapeColaborador1;
    }

    
    @Column(name="colaborador2", length=45)
    public String getColaborador2() {
        return this.colaborador2;
    }
    
    public void setColaborador2(String colaborador2) {
        this.colaborador2 = colaborador2;
    }

    
    @Column(name="siapeColaborador2", length=45)
    public String getSiapeColaborador2() {
        return this.siapeColaborador2;
    }
    
    public void setSiapeColaborador2(String siapeColaborador2) {
        this.siapeColaborador2 = siapeColaborador2;
    }

    
    @Column(name="colaborador3", length=45)
    public String getColaborador3() {
        return this.colaborador3;
    }
    
    public void setColaborador3(String colaborador3) {
        this.colaborador3 = colaborador3;
    }

    
    @Column(name="siapeColaborador3", length=45)
    public String getSiapeColaborador3() {
        return this.siapeColaborador3;
    }
    
    public void setSiapeColaborador3(String siapeColaborador3) {
        this.siapeColaborador3 = siapeColaborador3;
    }

    
    @Column(name="statusPortaria", nullable=false, length=45)
    public String getStatusPortaria() {
        return this.statusPortaria;
    }
    
    public void setStatusPortaria(String statusPortaria) {
        this.statusPortaria = statusPortaria;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="portaria")
    public Set<FuncionarioHasPortaria> getFuncionarioHasPortarias() {
        return this.funcionarioHasPortarias;
    }
    
    public void setFuncionarioHasPortarias(Set<FuncionarioHasPortaria> funcionarioHasPortarias) {
        this.funcionarioHasPortarias = funcionarioHasPortarias;
    }




}


