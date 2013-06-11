package br.com.matrix.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "Complemento")
    private Integer complemento;
    
    
    
}
