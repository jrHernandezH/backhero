## Tablas Mejoradas y Normalizadas

### **Viajes**
Tabla principal para representar los viajes, con claves foráneas a otras tablas.
- `id` (PK)
- `idUnidad` (FK a **Unidades**)
- `idFactura` (FK a **Facturas**)
- `idRuta` (FK a **Rutas**)
- `idOperador` (FK a **Operadores**)
- `idValeDiesel` (FK a **Vales**)
- `odometroInicio`
- `odometroFin`
- `tanqueInicio`
- `tanqueFin`
- `fechaInicio`
- `fechaFin`
- `activo`

---

### **Unidades**
Información sobre las unidades de transporte.
- `id` (PK)
- `numeroUnidad` (Único)
- `tipoUnidad` (e.g., tractocamión, remolque)
- `marca`
- `modelo`
- `año`
- `placas`
- `estado` (activo/inactivo)

---

### **Facturas**
Para manejar información detallada de las facturas asociadas a un viaje.
- `id` (PK)
- `numeroFactura` (Único)
- `proveedor`
- `monto`
- `fechaEmision`
- `estatus` (e.g., pagada, pendiente)

---

### **Viajes_Vales** (Nueva tabla)
- `id` (PK)
- `idViaje` (FK a **Viajes**)
- `idVale` (FK a **Vales**)

---

### **Vales**
Para almacenar información de los vales.
- `id` (PK)
- `numeroVale` (Único)
- `descripcion`
- `monto`   
- `fechaExpedicion`
- `tipoVale` (e.g., combustible, mantenimiento)

---

### **Rutas**
Tabla para manejar información sobre las rutas de un viaje.
- `id` (PK)
- `origen` (Municipio, estado o país)
- `destino` (Municipio, estado o país)
- `distancia`
- `tiempoEstimado` (opcional)

---

### **Operadores**
Para asignar un operador responsable de cada viaje.
- `id` (PK)
- `nombreCompleto`
- `numeroLicencia`
- `telefono`
- `direccion`
- `fechaContratacion`
- `estatus` (activo/inactivo)

---

### **ViajesDetalles**
Tabla auxiliar para almacenar información adicional sobre un viaje.
- `id` (PK)
- `idViaje` (FK a **Viajes**)
- `imagenTanqueInicio`
- `imagenTanqueFin`
- `imagenOdometroInicio`
- `imagenOdometroFin`
- `equipoAdicional` (texto o FK a **Equipos**)
- `serviciosForaneos`
- `verificacionLlantas`

---

### **Equipos**
Tabla para listar equipos adicionales utilizados en los viajes.
- `id` (PK)
- `nombreEquipo`
- `descripcion`
- `estatus` (activo/inactivo)

---

### **Remisiones**
Tabla para almacenar las remisiones relacionadas con un viaje.
- `id` (PK)
- `idViaje` (FK a **Viajes**)
- `imagenRemision`
- `descripcion`
- `fechaRemision`

---

### **Gastos**
Tabla para almacenar los gastos relacionados con los viajes.
- `id` (PK)
- `idViaje` (FK a **Viajes**)
- `tipoGasto` (e.g., combustible, reparación, viáticos)
- `monto`
- `imagenGasto`
- `fechaGasto`


- `observaciones`

# Relaciones en Verbo y Lista

## **Relaciones Principales**

1. **Un Viaje está asociado con una Unidad:**
   - Un viaje *se realiza con* una unidad.
   - Relación: **Viajes → Unidades** (1:N)

2. **Un Viaje está asociado con un Operador:**
   - Un viaje *es asignado a* un operador.
   - Relación: **Viajes → Operadores** (1:N)

3. **Un Viaje utiliza un Vale de Diesel:**
   - Un viaje *utiliza* un vale de diesel.
   - Relación: **Viajes → Vales** (1:N)

4. **Un Viaje está asociado con una Factura:**
   - Un viaje *genera* una factura.
   - Relación: **Viajes → Facturas** (1:N)

5. **Un Viaje sigue una Ruta específica:**
   - Un viaje *recorre* una ruta.
   - Relación: **Viajes → Rutas** (1:N)

6. **Un Viaje tiene detalles adicionales:**
   - Un viaje *tiene* información extra como imágenes o verificaciones.
   - Relación: **Viajes → ViajesDetalles** (1:1)

7. **Un Viaje puede tener múltiples Remisiones:**
   - Un viaje *genera* una o más remisiones.
   - Relación: **Viajes → Remisiones** (1:N)

8. **Un Viaje puede tener múltiples Gastos:**
   - Un viaje *implica* diferentes tipos de gastos.
   - Relación: **Viajes → Gastos** (1:N)


---

## **Relaciones Reutilizables**

11. **Una Unidad puede ser asignada a múltiples Viajes:**
    - Una unidad *es utilizada en* diferentes viajes.
    - Relación: **Unidades → Viajes** (1:N)

12. **Un Operador puede estar asignado a múltiples Viajes:**
    - Un operador *conduce* distintos viajes.
    - Relación: **Operadores → Viajes** (1:N)

13. **Una Factura puede estar relacionada con un Viaje:**
    - Una factura *es generada por* un viaje.
    - Relación: **Facturas → Viajes** (1:N)

14. **Un Vale puede ser usado por múltiples Viajes:**
    - Un vale *se utiliza en* uno o más viajes (si es reutilizable).
    - Relación: **Vales → Viajes** (1:N)

15. **Una Ruta puede ser recorrida por múltiples Viajes:**
    - Una ruta *es recorrida en* diferentes viajes.
    - Relación: **Rutas → Viajes** (1:N)

16. **Un Equipo adicional puede estar asociado con múltiples Viajes:**
    - Un equipo adicional *es utilizado en* uno o más viajes.
    - Relación: **Equipos → ViajesDetalles** (1:N)

---

## **Resumen del Modelo Relacional**

### **Relaciones 1:1**
- Viajes → ViajesDetalles
- Viajes → Verificaciones

### **Relaciones 1:N**
- Viajes → Unidades
- Viajes → Operadores
- Viajes → Vales
- Viajes → Facturas
- Viajes → Rutas
- Viajes → Remisiones
- Viajes → Gastos

### **Relaciones Reutilizables**
- Equipos → ViajesDetalles
- Unidades → Viajes
- Operadores → Viajes
