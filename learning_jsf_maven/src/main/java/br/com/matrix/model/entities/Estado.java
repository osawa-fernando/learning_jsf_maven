package br.com.matrix.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "estado")
public class Estado implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdEstado", nullable = false)
    private Integer idEstado;
    @Column(name = "Nome", length = 40, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEndereço")
    private List<Endereço> endereços;

    public Estado() 
    {
    
    }

    public Integer getIdEstado() 
    {
    
        return idEstado;
    
    }

    public void setIdEstado(Integer idEstado) 
    {
    
        this.idEstado = idEstado;
    
    }

    public String getNome() 
    {
    
        return nome;
    
    }

    public void setNome(String nome) 
    {
    
        this.nome = nome;
    
    }

    public List<Endereço> getEndereços() 
    {
    
        return endereços;
    
    }

    public void setEndereços(List<Endereço> endereços) 
    {
    
        this.endereços = endereços;
    
    }

    @Override
    public int hashCode() 
    {
    
        int hash = 7;
        hash = 47 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
        return hash;
    
    }

    @Override
    public boolean equals(Object obj) 
    {
    
        if (obj == null) 
        {
        
            return false;
        
        }
        if (getClass() != obj.getClass()) 
        {
        
            return false;
        
        }
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) 
        {
        
            return false;
        
        }
        return true;
    }
}
