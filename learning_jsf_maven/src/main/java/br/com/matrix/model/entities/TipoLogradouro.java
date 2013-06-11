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
@Table(name = "tipoLogradouro")

public class TipoLogradouro implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdTipoLogradouro", nullable = false)
    private Integer idTipoLogradouro;
    @Column(name = "Nome", length = 40, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "tipoLogradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoLogradouroEndereço")
    private List<Endereço> endereços;

    public TipoLogradouro() 
    {
    
    }

    public Integer getIdTipoLogradouro() 
    {
    
        return idTipoLogradouro;
    
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) 
    {
    
        this.idTipoLogradouro = idTipoLogradouro;
    
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
        hash = 37 * hash + (this.idTipoLogradouro != null ? this.idTipoLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogradouro != other.idTipoLogradouro && (this.idTipoLogradouro == null || !this.idTipoLogradouro.equals(other.idTipoLogradouro))) 
        {
        
            return false;
        
        }
        return true;
    }
}
