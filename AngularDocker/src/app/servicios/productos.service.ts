import { HttpClient,HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environment/environment';
import { Producto } from '../domain/productos/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductosService {

  constructor(private http: HttpClient) { }

  ObtenerProducto(codigo: number){
    let url = environment.PATH_WS + "/productos/leer?codigo=" + codigo;
    console.log("leer", url);
    return this.http.get<any>(url);
  }

  Actualizar(producto: Producto){
    let url = environment.PATH_WS + "/productos/actualizar";
    console.log("actualizar", url);
    return this.http.put<any>(url,producto);
  }

  BorrarProducto(codigo: number){
    let url = environment.PATH_WS + "/productos/borrar?codigo=" + codigo;
    console.log("borrar", url);
    return this.http.delete<any>(url);
  }

  CrearProducto(producto: Producto){
    let url = environment.PATH_WS + "/productos/crear";
    console.log("crear", url);
    return this.http.post<any>(url,producto);
  }

  ListarProductos(){
    let url = environment.PATH_WS + "/productos/list";
    console.log("listar", url);
    return this.http.get<any>(url);
  }
}
