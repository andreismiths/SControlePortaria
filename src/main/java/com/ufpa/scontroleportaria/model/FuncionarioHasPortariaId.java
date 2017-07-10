package com.ufpa.scontroleportaria.model;
// Generated 09/07/2017 11:02:20 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * FuncionarioHasPortariaId generated by hbm2java
 */
@Embeddable
public class FuncionarioHasPortariaId  implements java.io.Serializable {


     private int pkFuncionarioHasPortaria;
     private int fkFuncionario;
     private int fkPortaria;

    public FuncionarioHasPortariaId() {
    }

    public FuncionarioHasPortariaId(int pkFuncionarioHasPortaria, int fkFuncionario, int fkPortaria) {
       this.pkFuncionarioHasPortaria = pkFuncionarioHasPortaria;
       this.fkFuncionario = fkFuncionario;
       this.fkPortaria = fkPortaria;
    }
   


    @Column(name="PK_Funcionario_has_Portaria", nullable=false)
    public int getPkFuncionarioHasPortaria() {
        return this.pkFuncionarioHasPortaria;
    }
    
    public void setPkFuncionarioHasPortaria(int pkFuncionarioHasPortaria) {
        this.pkFuncionarioHasPortaria = pkFuncionarioHasPortaria;
    }


    @Column(name="FK_funcionario", nullable=false)
    public int getFkFuncionario() {
        return this.fkFuncionario;
    }
    
    public void setFkFuncionario(int fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }


    @Column(name="FK_portaria", nullable=false)
    public int getFkPortaria() {
        return this.fkPortaria;
    }
    
    public void setFkPortaria(int fkPortaria) {
        this.fkPortaria = fkPortaria;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FuncionarioHasPortariaId) ) return false;
		 FuncionarioHasPortariaId castOther = ( FuncionarioHasPortariaId ) other; 
         
		 return (this.getPkFuncionarioHasPortaria()==castOther.getPkFuncionarioHasPortaria())
 && (this.getFkFuncionario()==castOther.getFkFuncionario())
 && (this.getFkPortaria()==castOther.getFkPortaria());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPkFuncionarioHasPortaria();
         result = 37 * result + this.getFkFuncionario();
         result = 37 * result + this.getFkPortaria();
         return result;
   }   


}


