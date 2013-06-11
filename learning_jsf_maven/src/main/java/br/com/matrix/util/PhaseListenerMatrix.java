package br.com.matrix.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

public class PhaseListenerMatrix implements PhaseListener
{

    @Override
    public void beforePhase(PhaseEvent phase) 
    {
    
       if(phase.getPhaseId().equals(PhaseId.RESTORE_VIEW))
       {
           
           System.out.println("Antes da fase: " + getPhaseId().toString());
           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           FacesContextUtil.setRequestSession(session);
                      
       }
    
    }

    @Override
    public void afterPhase(PhaseEvent phase) 
    {
    
        if(phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE))
        {
            System.out.println("Depois da fase: " + getPhaseId());
            Session session = FacesContextUtil.getRequestSession();
            try 
            {
            
                session.getTransaction().commit();
                
            } 
            catch (Exception e) 
            {
                
                if(session.getTransaction().isActive())
                {
                    
                    session.getTransaction().rollback();
                                        
                }
                
            }
            finally
            {
                
                session.close();
                
            }
            
        }
    
    }

    @Override
    public PhaseId getPhaseId() 
    {
    
        return PhaseId.ANY_PHASE;
    
    }
    
       
    
}
