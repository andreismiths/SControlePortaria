package com.ufpa.scontroleportaria.model;
// Generated 02/09/2017 11:08:35 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PortariaId generated by hbm2java
 */
@Embeddable
public class PortariaId  implements java.io.Serializable {


     private int pkPortaria;
     private int fkFuncionario;

    public PortariaId() {
    }

    public PortariaId(int pkPortaria, int fkFuncionario) {
       this.pkPortaria = pkPortaria;
       this.fkFuncionario = fkFuncionario;
    }
   


    @Column(name="PK_portaria", nullable=false)
    public int getPkPortaria() {
        return this.pkPortaria;
    }
    
    public void setPkPortaria(int pkPortaria) {
        this.pkPortaria = pkPortaria;
    }


    @Column(name="FK_funcionario", nullable=false)
    public int getFkFuncionario() {
        return this.fkFuncionario;
    }
    
    public void setFkFuncionario(int fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PortariaId) ) return false;
		 PortariaId castOther = ( PortariaId ) other; 
         
		 return (this.getPkPortaria()==castOther.getPkPortaria())
 && (this.getFkFuncionario()==castOther.getFkFuncionario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getPkPortaria();
         result = 37 * result + this.getFkFuncionario();
         return result;
   }   


}


