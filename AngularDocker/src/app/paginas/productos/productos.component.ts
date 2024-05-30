import { Component} from '@angular/core';
import { Producto } from '../../domain/productos/producto';
import { ProductosService } from '../../servicios/productos.service';
import { CommonModule, NgForOf } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-productos',
  standalone: true,
  imports: [CommonModule, HttpClientModule, NgForOf, FormsModule],

  templateUrl: './productos.component.html',
  styleUrl: './productos.component.css'
})
export class ProductosComponent {

  producto : Producto = new Producto;

  productos : any;

  editar : boolean = false;

  constructor(private servicioProductos: ProductosService){
    this.ListarProductos();
  }

  BotonClick(){
    if(this.editar){
      this.ActualizarProducto();
      this.editar = false;
    }else{
      this.AgregarProducto();
    }
  }

  AgregarProducto(){
    console.log("agregando producto");
    this.servicioProductos.CrearProducto(this.producto).subscribe(data => {
      console.log(data);
    });
    this.ListarProductos();
  }

  ActualizarProducto(){
    console.log("actualizando producto");
    this.servicioProductos.Actualizar(this.producto).subscribe(data => {
      console.log(data);
    });
    this.ListarProductos();
  }

  EliminarProducto(codigo: any){
    console.log("eliminando producto");
    this.servicioProductos.BorrarProducto(codigo).subscribe(data => {
      console.log(data);
    });
    this.ListarProductos();
  }

  ListarProductos(){
    this.servicioProductos.ListarProductos().subscribe(data => {
      this.productos = data;
      console.log(data);
    });
  }

  EditarProducto(codigo: any){
    this.servicioProductos.ObtenerProducto(codigo).subscribe(data => {
      console.log(data);
      this.producto = data;
    });
    this.editar = true;
  }
}
