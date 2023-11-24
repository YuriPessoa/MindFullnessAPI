package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.Humor_DiarioDao;
import br.cefet.mindfulness.model.Humor_Diario;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class Humor_DiarioService {
    private final Humor_DiarioDao humor_diarioDao;

    public Humor_DiarioService(Jdbi jdbi) {
        this.humor_diarioDao = jdbi.onDemand(Humor_DiarioDao.class);
    }

    public Humor_Diario inserir(Humor_Diario humor_diario) {
        int id_humor_diario = humor_diarioDao.insert(humor_diario);
        humor_diario.setId_humor_diario(id_humor_diario);
        return humor_diario;
    }

    public List<Humor_Diario> consultarTodos() {
        return humor_diarioDao.getAll();
    }

    public Humor_Diario consultarPorId(int id_humor_diario) {
        return humor_diarioDao.get(id_humor_diario);
    }

    public List<Humor_Diario> consultarPorAluno(int id_humor_diario) {
        return humor_diarioDao.getAllByAluno(id_humor_diario);
    }

    public void alterar(Humor_Diario humor_diario) {
        humor_diarioDao.update(humor_diario);
    }

    public void excluir(int id_humor_diario) {
        humor_diarioDao.delete(id_humor_diario);
    }
}
