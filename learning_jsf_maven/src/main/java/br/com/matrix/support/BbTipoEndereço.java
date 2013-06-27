package br.com.matrix.support;

import br.com.matrix.model.dao.HibernateDAO;
import br.com.matrix.model.dao.InterfaceDAO;
import br.com.matrix.model.entities.TipoEndereço;
import br.com.matrix.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name="bbTipoEndereço")
@RequestScoped
public class BbTipoEndereço  implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public List<TipoEndereço> getTipoEndereços() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<TipoEndereço> tipoEndereçoDAO = new HibernateDAO<TipoEndereço>(TipoEndereço.class, session);
        return tipoEndereçoDAO.getEntities();
    }
}