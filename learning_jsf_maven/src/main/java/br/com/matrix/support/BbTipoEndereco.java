package br.com.matrix.support;

import br.com.matrix.model.dao.HibernateDAO;
import br.com.matrix.model.dao.InterfaceDAO;
import br.com.matrix.model.entities.TipoEndereco;
import br.com.matrix.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name = "bbTipoEndereco")
@RequestScoped
public class BbTipoEndereco implements Serializable
{
    private static final long serialVersionUID = 1L;

    public List<TipoEndereco> getTipoEnderecos()
    {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<TipoEndereco> tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, session);
        return tipoEnderecoDAO.getEntities();
    }
}