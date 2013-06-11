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
@Table(name = "tipoEndereço")

public class TipoEndereço implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdTipoEndereço", nullable = false)
    private Integer idTipoEndereço;
    @Column(name = "Nome", length = 40, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "tipoEndereço", fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoEndereçoEndereço")
    private List<Endereço> endereços;

    public TipoEndereço() 
    {
        
    }

    public Integer getIdTipoEndereço() 
    {
    
        return idTipoEndereço;
    
    }

    public void setIdTipoEndereço(Integer idTipoEndereço) 
    {
    
        this.idTipoEndereço = idTipoEndereço;
    
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
    
        int hash = 5;
        hash = 53 * hash + (this.idTipoEndereço != null ? this.idTipoEndereço.hashCode() : 0);
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
        final TipoEndereço other = (TipoEndereço) obj;
        if (this.idTipoEndereço != other.idTipoEndereço && (this.idTipoEndereço == null || !this.idTipoEndereço.equals(other.idTipoEndereço))) 
        {
        
            return false;
        
        }
        return true;
    }
  }
