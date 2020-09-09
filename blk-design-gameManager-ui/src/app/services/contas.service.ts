import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UsuarioObject } from '../objects/usuario-object';

@Injectable({
  providedIn: 'root'
})
export class ContasService {

  contasUrl = 'http://localhost:8080/conta';

  constructor(private http: HttpClient) { }

  consultar() {
    
  }

  adicionar(usuario: UsuarioObject): Promise<any> {
    return this.http.post('http://localhost:8080/conta', usuario)
    .toPromise()
    .then((data:any) => {
      console.log(data);
    });
  }

  
}
