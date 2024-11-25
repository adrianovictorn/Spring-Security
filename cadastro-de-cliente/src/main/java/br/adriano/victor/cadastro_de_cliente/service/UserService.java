package br.adriano.victor.cadastro_de_cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.adriano.victor.cadastro_de_cliente.entity.User;
import br.adriano.victor.cadastro_de_cliente.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    //Cadastrar Usuário
    public User cadastrarUsuario(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }
    //Listar Usuários
    public List<User> listarUsuarios(){
        return userRepository.findAll();
    }
    //Buscar Usuário por Id
    public User buscarUsuarioPorId(Long id){
        return userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado" + id));
    }
    //Atualizar Usuário
    public User atualizarUsuario (Long id, User user){
        User userExistente = buscarUsuarioPorId(id);
        userExistente.setUsername(user.getUsername());
        userExistente.setRole(user.getRole());
        userExistente.setPassword(user.getPassword());

        return userRepository.save(userExistente);
    }
    //Deletar Usuário
    public void deletarUsuario(Long id){
        User userExistente = buscarUsuarioPorId(id);
        userRepository.delete(userExistente);
    }

}
