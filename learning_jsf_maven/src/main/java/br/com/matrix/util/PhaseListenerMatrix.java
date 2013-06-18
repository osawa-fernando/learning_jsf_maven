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
       System.out.println("Antes da fase: " + phase.getPhaseId().toString());
       if(phase.getPhaseId().equals(PhaseId.RESTORE_VIEW))
       {
                      
           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           FacesContextUtil.setRequestSession(session);
                      
       }
    
    }

    @Override
    public void afterPhase(PhaseEvent phase) 
    {
        System.out.println("Depois da fase: " + phase.getPhaseId());
        if(phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE))
        {
            
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
