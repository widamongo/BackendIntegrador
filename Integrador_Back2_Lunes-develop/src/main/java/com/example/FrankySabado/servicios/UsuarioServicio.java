package com.example.FrankySabado.servicios;

import com.example.FrankySabado.modelos.Usuario;
import com.example.FrankySabado.modelos.dtos.UsuarioGenericoDTO;
import com.example.FrankySabado.modelos.mapas.IMapaUsuarioDTO;
import com.example.FrankySabado.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    //1. Llamar al repositorio
    //INYECTAR UNA DEPENDENCIA AL REPO
    @Autowired
    IUsuarioRepositorio repositorio;

    @Autowired
    IMapaUsuarioDTO mapa;

    //1. Servicio para guardar un usuario
    public UsuarioGenericoDTO guardarUsuario(Usuario datosUsuario)throws Exception{
        try{
            return this.mapa.convertirADTO(this.repositorio.save(datosUsuario));

        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //2. Servicio para buscar Todos los usuarios
    public List<UsuarioGenericoDTO> buscarUsuarios()throws Exception{
        try{
            return this.mapa.convertirListaDTO(this.repositorio.findAll());
        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //3. Servicio para buscar un usuario si me dan su ID
    public UsuarioGenericoDTO buscarUsuarioPorId(Integer id)throws Exception{
        try{
            Optional<Usuario>usuarioBuscado=this.repositorio.findById(id);
            if(usuarioBuscado.isPresent()){ //SI SI ESTA
                return this.mapa.convertirADTO(usuarioBuscado.get());
            }else{ //SI NO ESTA
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //Buscar por correo
    public UsuarioGenericoDTO buscarUsuarioPorCorreo(String correo)throws Exception{
        try{
            Optional<Usuario>usuarioBuscado=this.repositorio.findByCorreo(correo);
            if(usuarioBuscado.isPresent()){ //SI SI ESTA
                return this.mapa.convertirADTO(usuarioBuscado.get());
            }else{ //SI NO ESTA
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }





}
