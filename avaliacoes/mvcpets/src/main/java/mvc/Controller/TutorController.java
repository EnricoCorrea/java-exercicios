package main.java.mvc.Controller;

import main.java.mvc.dao.TutorDao;
import main.java.mvc.model.Tutor;
import java.util.List;

public class TutorController {
    private TutorDao dao = new TutorDao();

    public void criarTutor(String nome, String apelido){
        Tutor t = new Tutor(nome,apelido);
        dao.adicionarTutor(t);
    }

    public List<Tutor> listarTutores() {
        return dao.listarTutores();
    }

    public Tutor buscarPorNome(String nome) {
        return dao.buscarPorNome(nome);
    }

    public Tutor buscarPorApelido(String apelido) {
        return dao.buscarPorApelido(apelido);
    }

    public boolean deletarPorNome(String nome) {
        return dao.removerPorNome(nome);
    }

    public boolean deletarPorApelido(String apelido) {
        return dao.removerPorApelido(apelido);
    }
}
