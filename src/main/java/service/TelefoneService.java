package service;

import dao.TelefoneDao;
import application.Telefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // ← Adicione esta anotação!
public class TelefoneService {

    private final TelefoneDao telefoneDao;  // ← Removido static

    @Autowired
    public TelefoneService(TelefoneDao telefoneDao){
        this.telefoneDao = telefoneDao;
    }

    public List<Telefone> listarTelefone() {  // ← Removido static
        return telefoneDao.listarTelefone();
    }

    public Telefone buscarTelefone(int id) {  // ← Removido static
        // Você precisará implementar buscarPorId no DAO
        return telefoneDao.buscarPorId(id);
    }

    public Telefone editarTelefone(int id_telefone, Telefone telefone) {  // ← Removido static
        telefone.setId(id_telefone);
        telefoneDao.editarTelefone(telefone);  // ← Corrigido: passa o objeto completo
        return telefone;
    }

    public void deletarTelefone(int idTelefone) {  // ← Removido static, return void
        Telefone telefone = new Telefone();
        telefone.setId(idTelefone);
        telefoneDao.deletarTelefone(idTelefone);
    }

    public void criarTelefone(Telefone telefone) {
        telefoneDao.criarTelefone(telefone);

    }

}