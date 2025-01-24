import model.UsuariosModel;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    private UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();

    public String salvar(UsuariosModel usuario) throws SQLException {
        return usuarioRepository.salvar(usuario);
    }

    public List<UsuariosModel> buscarTodos() throws SQLException {
        return usuarioRepository.buscarTodos();
    }

    public String remover(Long idUsuarioSelecionado) throws SQLException {
        UsuariosModel usuario = usuarioRepository.buscarPorId(idUsuarioSelecionado);
        if (usuario != null) {
            return usuarioRepository.remover(usuario);
        } else {
            return "Usuário não encontrado!";
        }
    }

    public UsuariosModel buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }
}
