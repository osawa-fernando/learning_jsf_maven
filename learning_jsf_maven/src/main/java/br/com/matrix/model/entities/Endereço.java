package br.com.matrix.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "endereço")
public class Endereço implements Serializable
{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "IdEndereço", nullable = false)
    private Integer idEndereço;
    @Column(name = "Bairro", length = 80, nullable = false)
    private String bairro;
    @Column(name = "NomeLogradouro", length = 120, nullable = false)
    private String nomeLogradouro;
    @Column(name = "CEP", length = 9, nullable = false)
    private String cep;
    @Column(name = "Numero", nullable = false)
    private Integer numero;
    @Column(name = "Complemento", length = 40, nullable = false)
    private String complemento;
    
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "EndereçoPessoa")
    @JoinColumn(name = "IdPessoa", referencedColumnName = "IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoLogradouroEndereço")
    @JoinColumn(name = "IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro")
    private TipoLogradouro tipoLogradouro;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "CidadeEndereço")
    @JoinColumn(name = "IdCidade", referencedColumnName = "IdCidade")
    private Cidade cidade;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "EstadoEndereço")
    @JoinColumn(name = "IdEstado", referencedColumnName = "IdEstado")
    private Estado estado;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoEndereçoEndereço")
    @JoinColumn(name = "IdTipoEndereço", referencedColumnName = "IdTipoEndereço")
    private TipoEndereço tipoEndereço;

    public Endereço() 
    {
    
        this.cidade = new Cidade();
        this.estado = new Estado();
        this.tipoLogradouro = new TipoLogradouro();
        this.tipoEndereço = new TipoEndereço();
        this.pessoa = new Pessoa();
        
    }

    public Integer getIdEndereço() 
    {
    
        return idEndereço;
    
    }

    public void setIdEndereço(Integer idEndereço) 
    {
    
        this.idEndereço = idEndereço;
    
    }

    public String getBairro() 
    {
    
        return bairro;
    
    }

    public void setBairro(String bairro) 
    {
    
        this.bairro = bairro;
    
    }

    public String getNomeLogradouro() 
    {
    
        return nomeLogradouro;
    
    }

    public void setNomeLogradouro(String nomeLogradouro) 
    {
    
        this.nomeLogradouro = nomeLogradouro;
    
    }

    public String getCep() 
    {
    
        return cep;
    
    }

    public void setCep(String cep) 
    {
    
        this.cep = cep;
    
    }

    public Integer getNumero() 
    {
    
        return numero;
    
    }

    public void setNumero(Integer numero) 
    {
    
        this.numero = numero;
    
    }

    public String getComplemento() 
    {
    
        return complemento;
    
    }

    public void setComplemento(String complemento) 
    {
    
        this.complemento = complemento;
    
    }

    public Pessoa getPessoa() 
    {
    
        return pessoa;
    
    }

    public void setPessoa(Pessoa pessoa) 
    {
    
        this.pessoa = pessoa;
    
    }

    public TipoLogradouro getTipoLogradouro() 
    {
    
        return tipoLogradouro;
    
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) 
    {
    
        this.tipoLogradouro = tipoLogradouro;
    
    }

    public Cidade getCidade() 
    {
    
        return cidade;
    
    }

    public void setCidade(Cidade cidade) 
    {
    
        this.cidade = cidade;
    
    }

    public Estado getEstado() 
    {
    
        return estado;
    
    }

    public void setEstado(Estado estado) 
    {
    
        this.estado = estado;
    
    }

    public TipoEndereço getTipoEndereço() 
    {
    
        return tipoEndereço;
    
    }

    public void setTipoEndereço(TipoEndereço tipoEndereço) 
    {
    
        this.tipoEndereço = tipoEndereço;
    
    }

    @Override
    public int hashCode() 
    {
    
        int hash = 7;
        hash = 61 * hash + (this.idEndereço != null ? this.idEndereço.hashCode() : 0);
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
        final Endereço other = (Endereço) obj;
        if (this.idEndereço != other.idEndereço && (this.idEndereço == null || !this.idEndereço.equals(other.idEndereço))) 
        {
        
            return false;
        
        }
        return true;
    }
}
