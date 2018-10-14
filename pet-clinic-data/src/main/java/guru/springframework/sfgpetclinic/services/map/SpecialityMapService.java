package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialtiesService;

import java.util.Set;

public class SpecialityMapService extends AbstractMapService<Speciality,Long> implements SpecialtiesService {
    @Override
    public Set<Speciality> findAll()  {
        return super.findAll();
    }

    @Override
    public void delete(Speciality object)  {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality object)  {
        return super.save(object);
    }

    @Override
    public Speciality findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteByID(Long id)  {
        super.deleteById(id);
    }
}
