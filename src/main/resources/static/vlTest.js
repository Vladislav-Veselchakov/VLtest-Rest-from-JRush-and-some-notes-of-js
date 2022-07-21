// сработал (has worded):
// над контроллером поставил
// @CrossOrigin(origins = "http://localhost:8080/clients")
let response = await fetch("http://localhost:8080/clients", {method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'},
    credentials: "same-origin",

    body:JSON.stringify({
        name: "vl name",
        email: "mail@dam.ru",
        password: "vl pass"
    })
});

// это что-то изменило в ответе
let response = await fetch("http://localhost:8080/clients", {method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'},
    credentials: "same-origin",
    mode: 'no-cors',

    body:JSON.stringify({
        name: "=--=",
        email: "==-----==u555",
        password: "=---===555"
    })
});





let response = await fetch("http://localhost:8080/clients", {method: 'POST',
    headers: {
        'Content-Type': 'application/json;charset=utf-8'},
    credentials: "include",

    body:JSON.stringify({
        name: "hoho",
        email: "mail@dam.ru"
    })
});

/*
final HttpHeaders responseHeaders = new HttpHeaders();
responseHeaders.set(headerName, headerValue);
final ResponseEntity<> response = new ResponseEntity<>(responseHeaders, HttpStatus.FORBIDDEN);


//create a new headers object.
HttpHeaders headers = new HttpHeaders();
//add all existing headers in new headers
headers.addAll(response.getHeaders());
//add the new required header
headers.add("newheader","newvalue");
//add the headers to the responseEntity along with yourBody object
ResponseEntity.status(HttpStatus.OK).headers(headers).body(yourBody);
а точнее:
ResponseEntity.ok().header().body()

public void addCustomHeader(ResponseEntity response,String headerName,String headerValue)
{
  response.getHeaders().add(headerName, headerValue);

}


*/


