package package_name_from.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import package_name_from.model.Client;
import package_name_from.service.ClientService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

//    @CrossOrigin(origins = "http://localhost:8080/clients")
    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        // send this:
//        let response = await fetch("http://localhost:8080/clients", {method: 'POST',
//                headers: {
//            'Content-Type': 'application/json;charset=utf-8'},
//        credentials: "same-origin",  // <= в этом было дело!
//
//                body:JSON.stringify({
//                name: "vl name",
//                email: "mail@dam.ru",
//                password: "vl pass"
//            })
//        });

        clientService.create(client);

//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("Access-Control-Allow-Origin", "*");
//        responseHeaders.set("Content-Type", "application/xml");
//         ResponseEntity<?> response = new ResponseEntity<>(responseHeaders, HttpStatus.OK);

       //ResponseEntity<?> respen = new ResponseEntity<>("aaaa: 111", HttpStatus.OK);


        return new ResponseEntity<>("aaaa: 111", HttpStatus.OK);
//        return response;
    }


    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

//        HttpHeaders headers = new HttpHeaders();
 //       headers.set("Content-Type", "text/html");
//        ResponseEntity<List<Client>> response = new ResponseEntity<>(clients, headers, HttpStatus.OK);
        // response.getHeaders().add("Content-Type",application/xml "text/html");
        // response.getHeaders();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") int id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<String>("{DFFF: FFFFF}",HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

} // public class ClientController {