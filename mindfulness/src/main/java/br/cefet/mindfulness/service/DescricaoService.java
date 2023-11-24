package br.cefet.mindfulness.service;

import br.cefet.mindfulness.dao.DescricaoDao;
import br.cefet.mindfulness.model.Descricao;
import java.util.List;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class DescricaoService {
    
    private final DescricaoDao descricaoDao;
    
    public DescricaoService(Jdbi jdbi){
        this.descricaoDao = jdbi.onDemand(DescricaoDao.class);
    }
    
    public Descricao inserir (Descricao descricao){
        int id_descricao = descricaoDao.insert(descricao);
        descricao.setId_descricao(id_descricao);
        return descricao;
    }
    
    public List<Descricao> consultarTodos(){
        return descricaoDao.getAll();
    }
    
    public Descricao consultarPorId(int id_descricao){
        return descricaoDao.get(id_descricao);
    }
    
    public List<Descricao> consultarPorAluno(int aluno_id){
        return descricaoDao.getAllByAluno(aluno_id);
    }
    
    public void alterar(Descricao descricao){
        descricaoDao.update(descricao);
    }
    
    public void excluir(int id_descricao){
        descricaoDao.delete(id_descricao);
    }
    
}
