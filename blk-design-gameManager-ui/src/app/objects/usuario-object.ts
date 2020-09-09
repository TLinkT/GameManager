import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class UsuarioObject {

    nome: any;
    email: any;
    senha: any;

    
    criar(nome: any, email: any, senha: any) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}