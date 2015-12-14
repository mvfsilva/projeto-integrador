package org.doando.business;

import org.doando.entity.OngEntity;
import org.doando.exception.InvallidEmailOrCnpjException;
import org.doando.repository.OngRepository;

/**
 *
 * @author MarcusSilva
 */
public class OngBusiness extends AbstractBusiness<OngEntity, Integer>{

    public OngBusiness() {
        this.repository = new OngRepository();
    }
    
    @Override
    public void validate(OngEntity t) throws InvallidEmailOrCnpjException {
        super.validate(t);
        if (t.getName().isEmpty()) {
            throw new IllegalArgumentException("The name is empty");
        } 
        OngEntity r = find(t.getEmail(), t.getCnpj());
        if(r != null) {
        	throw new InvallidEmailOrCnpjException("Email or CNPJ already in the system");
        }
    }

    public OngEntity find(String name, String cnpj) {
    	return ((OngRepository) getRepository()).find(name, cnpj);
    }
    
}
