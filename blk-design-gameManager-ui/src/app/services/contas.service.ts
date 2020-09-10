import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UsuarioObject } from '../objects/usuario-object';

@Injectable({
  providedIn: 'root'
})
export class ContasService {

  contasUrl = 'http://localhost:8080/conta';
  listaContas: UsuarioObject[];

  constructor(private http: HttpClient) { }

  consultar(): any {
    return this.http.get(this.contasUrl);
  }

  adicionar(usuario: UsuarioObject): Promise<any> {
    return this.http.post(this.contasUrl, usuario)
    .toPromise()
    .then((data:any) => {
      console.log(data);
    });
  }

  
}
