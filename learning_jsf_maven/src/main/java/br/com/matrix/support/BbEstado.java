package br.com.matrix.support;

import br.com.matrix.model.dao.HibernateDAO;
import br.com.matrix.model.dao.InterfaceDAO;
import br.com.matrix.model.entities.Estado;
import br.com.matrix.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbEstado")
@RequestScoped
public class BbEstado implements Serializable
{
    private static final long serialVersionUID = 1L;

    public List<Estado> getEstados()
    {
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }
}