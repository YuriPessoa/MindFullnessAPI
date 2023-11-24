package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.Tipo_Humor_DiarioDao;
import br.cefet.mindfulness.model.Tipo_Humor_Diario;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class Tipo_Humor_DiarioService {
    private final Tipo_Humor_DiarioDao tipo_humor_diarioDao;

    public Tipo_Humor_DiarioService(Jdbi jdbi) {
        this.tipo_humor_diarioDao = jdbi.onDemand(Tipo_Humor_DiarioDao.class);
    }

    public Tipo_Humor_Diario inserir(Tipo_Humor_Diario tipo_humor_diario) {
        int id_tipo_humor_diario = tipo_humor_diarioDao.insert(tipo_humor_diario);
        tipo_humor_diario.setId_tipo_humor_diario(id_tipo_humor_diario);
        return tipo_humor_diario;
    }

    public List<Tipo_Humor_Diario> consultarTodos() {
        return tipo_humor_diarioDao.getAll();
    }

    public Tipo_Humor_Diario consultarPorId(int id_tipo_humor_diario) {
        return tipo_humor_diarioDao.get(id_tipo_humor_diario);
    }

    public List<Tipo_Humor_Diario> consultarPorTipoHumor(String tipo_humor) {
        return tipo_humor_diarioDao.getAllByTipoHumor(tipo_humor);
    }

    public void alterar(Tipo_Humor_Diario tipo_humor_diario) {
        tipo_humor_diarioDao.update(tipo_humor_diario);
    }

    public void excluir(int id_tipo_humor_diario) {
        tipo_humor_diarioDao.delete(id_tipo_humor_diario);
    }
}
