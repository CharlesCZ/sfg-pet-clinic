package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {

      //  if(visit.getPet()==null || visit.getPet().getOwner()==null || visit.getPet().getId()==null || visit.getPet().getOwner().getId()==null)
        //    throw new RuntimeException("Invalid List");
        if(visit.getPet()==null )
            throw new RuntimeException("Pet null");
       if (visit.getPet().getOwner()==null)
           throw new RuntimeException("visit.getPet().getOwner()==null");

       if(visit.getPet().getId()==null )
           throw new RuntimeException("visit.getPet().getId()==null ");

        if(visit.getPet().getOwner().getId()==null)
           throw new RuntimeException("visit.getPet().getOwner().getId()==null");

        return super.save(visit);
    }

    @Override
    public Visit findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteByID(Long id) {
super.deleteById(id);
    }
}
