package com.example.vodafonespringboot.controller;

import com.example.vodafonespringboot.models.User;
import com.example.vodafonespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// Configuración de origenes permitidos
@CrossOrigin(origins = "http://localhost:8080")
// Anotación para declarar este archivo java como controlador, e indicar
// que los retornos tendrán que estar contenidos en un web response body
@RestController
//Declaración de la dirección url root de los métodos del CRUD de este archivo
@RequestMapping("")
public class UserListController {
    // -------------------------------------------------- CRUD ---------------------------------------------------

    //Este decorador declarará el repositorio como si fuera una variable local, instanciándo el objeto de la misma
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        // GET, obtiene la información de un usuario existente a través de su id

        // Obtención de los datos de usuario mediante id
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // POST, crea un usuario nuevo. Varios pueden tener mismos parámetros de entrada, el Id será siempre distinto
        // Parametros de entrada:
        //      name(String):           Nombre usuario
        //      lastName(String):       Apellido usuario
        //      age(Integer):           Edad usuario
        //      pointQuantity(Float):   puntuación inicial del usuario
        try{
            System.out.println("Creating User...");
            User _user = userRepository.save(new User(user.getName(), user.getLastName(), user.getAge(), true, user.getPointQuantity()));
            System.out.println("User have been created in DDBB");
            return new ResponseEntity<>(_user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        // PUT, Actualiza un usuario existente a través de su id. En el caso del parámetro pointQuantity éste
        // representará la cantidad de puntos a sumar a los que ya tenía previamente

        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            //Si se recibe un 0 es porque no se ha actualizado la edad
            int age = ((user.getAge() == 0) ? _user.getAge() : user.getAge());
            //Si se recibe null es porque no se ha actualizado el nombre
            String name = ((user.getName() == null) ? _user.getName() : user.getName());
            //Si se recibe un null es porque no se ha actualizado el apellido
            String lastName = ((user.getLastName() == null) ? _user.getLastName() : user.getLastName());

            _user.setAge(age);
            _user.setName(name);
            _user.setLastName(lastName);
            _user.addPoints(user.getPointQuantity());

            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        // DELETE, Elimina un usuario existente a través de su id

        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
