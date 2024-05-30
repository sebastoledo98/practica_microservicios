package com.web.gestion;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import com.web.modelo.Producto;

import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

import com.web.dao.DAOProducto;

@Stateless
public class GestionProducto {

    @Inject
    private DAOProducto productoDao;

    private final Tracer tracer = GlobalTracer.get();

    public void guardarProducto(Producto producto){
        Span span = tracer.buildSpan("guardarProducto").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            Producto prod = productoDao.read(producto.getCodigo());
            if(prod == null)
            productoDao.create(producto);
            else
            productoDao.update(producto);
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public void actualizarProducto(Producto producto) throws Exception{
        Span span = tracer.buildSpan("guardarProducto").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            Producto prod = productoDao.read(producto.getCodigo());
            if(prod != null)
            productoDao.update(producto);
            else
            throw new Exception("Producto no existe");
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public void borrarProducto(int id){
        Span span = tracer.buildSpan("guardarProducto").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            productoDao.delete(id);
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public Producto buscarProductoId(int id){
        Span span = tracer.buildSpan("guardarProducto").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            return productoDao.read(id);
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

    public List<Producto> getProductos(){
        Span span = tracer.buildSpan("guardarProducto").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            return productoDao.getAll();
        }catch(Exception e){
            span.log(e.getMessage());
            throw e;
        }finally{
            span.finish();
        }
    }

}
