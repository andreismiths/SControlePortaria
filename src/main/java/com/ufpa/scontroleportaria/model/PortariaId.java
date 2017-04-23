package com.ufpa.scontroleportaria.model;
// Generated 23/04/2017 12:10:30 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PortariaId generated by hbm2java
 */
@Embeddable
public class PortariaId  implements java.io.Serializable {


     private int idPortaria;
     private int funcionarioSiapeFuncionario;

    public PortariaId() {
    }

    public PortariaId(int idPortaria, int funcionarioSiapeFuncionario) {
       this.idPortaria = idPortaria;
       this.funcionarioSiapeFuncionario = funcionarioSiapeFuncionario;
    }
   


    @Column(name="idPortaria", nullable=false)
    public int getIdPortaria() {
        return this.idPortaria;
    }
    
    public void setIdPortaria(int idPortaria) {
        this.idPortaria = idPortaria;
    }


    @Column(name="Funcionario_siapeFuncionario", nullable=false)
    public int getFuncionarioSiapeFuncionario() {
        return this.funcionarioSiapeFuncionario;
    }
    
    public void setFuncionarioSiapeFuncionario(int funcionarioSiapeFuncionario) {
        this.funcionarioSiapeFuncionario = funcionarioSiapeFuncionario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PortariaId) ) return false;
		 PortariaId castOther = ( PortariaId ) other; 
         
		 return (this.getIdPortaria()==castOther.getIdPortaria())
 && (this.getFuncionarioSiapeFuncionario()==castOther.getFuncionarioSiapeFuncionario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPortaria();
         result = 37 * result + this.getFuncionarioSiapeFuncionario();
         return result;
   }   


}

