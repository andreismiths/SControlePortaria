package com.ufpa.scontroleportaria.model;
// Generated 26/07/2017 09:37:50 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FuncionarioHasPortaria generated by hbm2java
 */
@Entity
@Table(name="Funcionario_has_Portaria"
    ,catalog="SControlePortaria"
)
public class FuncionarioHasPortaria  implements java.io.Serializable {


     private FuncionarioHasPortariaId id;
     private Funcionario funcionario;
     private Portaria portaria;

    public FuncionarioHasPortaria() {
    }

    public FuncionarioHasPortaria(FuncionarioHasPortariaId id, Funcionario funcionario, Portaria portaria) {
       this.id = id;
       this.funcionario = funcionario;
       this.portaria = portaria;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="pkFuncionarioHasPortaria", column=@Column(name="PK_Funcionario_has_Portaria", nullable=false) ), 
        @AttributeOverride(name="fkFuncionario", column=@Column(name="FK_funcionario", nullable=false) ), 
        @AttributeOverride(name="fkPortaria", column=@Column(name="FK_portaria", nullable=false) ) } )
    public FuncionarioHasPortariaId getId() {
        return this.id;
    }
    
    public void setId(FuncionarioHasPortariaId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_funcionario", nullable=false, insertable=false, updatable=false)
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FK_portaria", nullable=false, insertable=false, updatable=false)
    public Portaria getPortaria() {
        return this.portaria;
    }
    
    public void setPortaria(Portaria portaria) {
        this.portaria = portaria;
    }




}


