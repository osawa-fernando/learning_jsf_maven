package br.com.matrix.controller;

import br.com.matrix.model.dao.HibernateDAO;
import br.com.matrix.model.dao.InterfaceDAO;
import br.com.matrix.model.entities.Endereço;
import br.com.matrix.model.entities.Pessoa;
import br.com.matrix.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbPessoa")
@SessionScoped
public class MbPessoa  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Pessoa pessoa = new Pessoa();
    private Endereço endereço = new Endereço();
    private List<Pessoa> pessoas;
    private List<Endereço> endereços;

    public MbPessoa() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereço> endereçoDAO(){
        InterfaceDAO<Endereço> endereçoDAO = new HibernateDAO<Endereço>(Endereço.class, FacesContextUtil.getRequestSession());
        return endereçoDAO;
    }
    
    public String limpPessoa(){
        pessoa = new Pessoa();
        endereço = new Endereço();
        return editPessoa();        
    }
    
    public String editPessoa(){
        return "/restrict/cadastrarpessoa.faces";        
    }
    
    public String addPessoa(){
        Date date = new Date();
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0){
           pessoa.setDataDeCadastro(date);
            insertPessoa();
        } else {
            updatePessoa();
        }
        
        return null;
    }

    private void insertPessoa() {
        pessoaDAO().save(pessoa);
        endereço.setPessoa(pessoa);
        endereçoDAO().save(endereço);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        endereçoDAO().update(endereço);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
    public String deletePessoa() {
        pessoaDAO().remove(pessoa);
        endereçoDAO().remove(endereço);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro excluído com sucesso", ""));
        return null;
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereço> getEndereços() {
        endereços = endereçoDAO().getEntities();
        return endereços;
    }

    public void setEndereços(List<Endereço> endereços) {
        this.endereços = endereços;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereço getEndereço() {
        return endereço;
    }

    public void setEndereço(Endereço endereço) {
        this.endereço = endereço;
    }
    
}
