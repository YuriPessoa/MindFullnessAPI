package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.Humor_DiarioTipo_Humor_DiarioDao;
import br.cefet.mindfulness.model.Tipo_Humor_Diario;
import br.cefet.mindfulness.model.Humor_DiarioTipo_Humor_Diario;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class Humor_DiarioTipo_Humor_DiarioService {
    private final Humor_DiarioTipo_Humor_DiarioDao humor_diarioTipo_humor_diarioDao;
    
    public Humor_DiarioTipo_Humor_DiarioService(Jdbi jdbi){
        this.humor_diarioTipo_humor_diarioDao = jdbi.onDemand(Humor_DiarioTipo_Humor_DiarioDao.class);
    }
    
    public Humor_DiarioTipo_Humor_Diario inserir (Humor_DiarioTipo_Humor_Diario humor_diarioTipo_humor_diario){
        humor_diarioTipo_humor_diarioDao.insert(humor_diarioTipo_humor_diario);
        return humor_diarioTipo_humor_diario;
    }
    
    public List<Tipo_Humor_Diario> getByHumor_Diario(int id_humor_diario){
        List<Tipo_Humor_Diario> tipo_humor_diarioList = humor_diarioTipo_humor_diarioDao.getAllByHumor_Diario(id_humor_diario);
        return tipo_humor_diarioList;
    }
    
    public Tipo_Humor_Diario get(int id_humor_diario, int idTipo_Humor_Diario){
        Tipo_Humor_Diario tipo_humor_diario = humor_diarioTipo_humor_diarioDao.get(id_humor_diario, idTipo_Humor_Diario);
        return tipo_humor_diario;
    }
    
    public void delete(int id_humor_diario, int idTipo_Humor_Diario){
        humor_diarioTipo_humor_diarioDao.delete(id_humor_diario, idTipo_Humor_Diario);
    }
    
    public void deleteAllByHumor_Diario(int id_humor_diario){
        humor_diarioTipo_humor_diarioDao.deleteAllByHumor_Diario(id_humor_diario);
    }
}
