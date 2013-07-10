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
@Table(name = "tipoendereco")
public class TipoEndereco implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "IdTipoEndereco", nullable = false)
    private Integer idTipoEndereco;
    @Column(name = "Nome", length = 40, nullable = false)
    private String nome;
    @OneToMany(mappedBy = "tipoendereco", fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoEnderecoEndereco")
    private List<Endereco> enderecos;

    public TipoEndereco()
    {
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos()
    {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos)
    {
        this.enderecos = enderecos;
    }
    
	public Integer getIdTipoEndereco()
    {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco)
    {
        this.idTipoEndereco = idTipoEndereco;
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idTipoEndereco != other.idTipoEndereco && (this.idTipoEndereco == null || !this.idTipoEndereco.equals(other.idTipoEndereco)))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 53 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
        return hash;
    }
}
