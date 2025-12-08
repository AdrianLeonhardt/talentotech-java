const API_URL = "http://localhost:8080/products";
const ORDER_API_URL = "http://localhost:8080/orders";

let modal;
let carrito = []; // Array para guardar items temporalmente

document.addEventListener('DOMContentLoaded', () => {
    modal = new bootstrap.Modal(document.getElementById('modalProducto'));
    cargarProductos();
});

// 1. GESTIÓN DE PRODUCTOS (LISTADO Y UI)


async function cargarProductos(nombre = '', categoria = '') {
    try {
        const params = new URLSearchParams();
        if (nombre) params.append('name', nombre);
        if (categoria) params.append('category', categoria);

        const url = `${API_URL}?${params.toString()}`;

        const respuesta = await fetch(url);
        const productos = await respuesta.json();

        const contenedor = document.getElementById('lista-productos');
        contenedor.innerHTML = '';

        if (productos.length === 0) {
            contenedor.innerHTML = '<div class="col-12 text-center text-muted">No se encontraron productos 😢</div>';
            return;
        }

        productos.forEach(p => {
            const img = (p.imageUrl && p.imageUrl.trim() !== "") ? p.imageUrl : 'https://placehold.co/300x200?text=Producto';

            // Lógica visual de stock
            let badgeStock = `<span class="badge bg-success">Stock: ${p.stock}</span>`;
            let btnAgregar = `<button class="btn btn-outline-primary w-100 mb-2" onclick="agregarAlCarrito(${p.id}, '${p.name}', ${p.price}, ${p.stock})">🛒 Agregar</button>`;

            if(p.stock === 0) {
                badgeStock = `<span class="badge bg-danger">Agotado</span>`;
                btnAgregar = `<button class="btn btn-secondary w-100 mb-2" disabled>Sin Stock</button>`;
            }

            contenedor.innerHTML += `
                <div class="col-md-4">
                    <div class="card h-100 shadow-sm">
                        <img src="${img}" class="card-img-top imagen-producto" alt="${p.name}">
                        <div class="card-body d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-2">
                                <h5 class="card-title text-truncate">${p.name}</h5>
                                <h5 class="text-primary">$${p.price}</h5>
                            </div>
                            <p class="text-muted small mb-1">${p.category}</p>
                            <div class="mb-3">${badgeStock}</div>

                            <div class="mt-auto">
                                ${btnAgregar}

                                <hr>
                                <div class="d-flex gap-2">
                                    <button class="btn btn-warning btn-sm w-100"
                                        onclick="abrirModalEditar('${p.id}', '${p.name}', '${p.category}', ${p.price}, ${p.stock}, '${p.imageUrl}')">
                                        ✏️ Editar
                                    </button>
                                    <button class="btn btn-danger btn-sm w-100" onclick="borrarProducto(${p.id})">🗑️</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            `;
        });
    } catch (error) {
        console.error("Error cargando productos:", error);
    }
}

function buscarProductos() {
    const nombre = document.getElementById('busquedaNombre').value;
    const categoria = document.getElementById('busquedaCategoria').value;
    cargarProductos(nombre, categoria);
}

function limpiarFiltros() {
    document.getElementById('busquedaNombre').value = '';
    document.getElementById('busquedaCategoria').value = '';
    cargarProductos();
}

// 2. GESTIÓN ADMIN (CREAR, EDITAR, BORRAR)

async function guardarProducto() {
    const id = document.getElementById('prodId').value;
    const datos = {
        name: document.getElementById('prodNombre').value,
        category: document.getElementById('prodCategoria').value,
        price: parseFloat(document.getElementById('prodPrecio').value),
        stock: parseInt(document.getElementById('prodStock').value),
        imageUrl: document.getElementById('prodImg').value
    };

    let metodo = 'POST';
    let url = API_URL;

    if (id) {
        metodo = 'PUT';
        url = `${API_URL}/${id}`;
    }

    await fetch(url, {
        method: metodo,
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(datos)
    });

    modal.hide();
    cargarProductos(); // Refrescar lista
}

async function borrarProducto(id) {
    if (confirm("¿Eliminar producto permanentemente?")) {
        await fetch(`${API_URL}/${id}`, { method: 'DELETE' });
        cargarProductos();
    }
}

// Funciones del Modal
window.abrirModalCrear = function() {
    document.getElementById('tituloModal').innerText = "Nuevo Producto";
    document.getElementById('prodId').value = "";
    document.getElementById('prodNombre').value = "";
    document.getElementById('prodCategoria').value = "";
    document.getElementById('prodPrecio').value = "";
    document.getElementById('prodStock').value = "";
    document.getElementById('prodImg').value = "";
    modal.show();
}

window.abrirModalEditar = function(id, nombre, categoria, precio, stock, img) {
    document.getElementById('tituloModal').innerText = "Editar Producto";
    document.getElementById('prodId').value = id;
    document.getElementById('prodNombre').value = nombre;
    document.getElementById('prodCategoria').value = categoria;
    document.getElementById('prodPrecio').value = precio;
    document.getElementById('prodStock').value = stock;
    const urlLimpia = (img && img !== 'null' && img !== 'undefined') ? img : "";
    document.getElementById('prodImg').value = urlLimpia;
    modal.show();
}

// 3. LOGICA DEL CARRITO DE COMPRAS

function agregarAlCarrito(id, nombre, precio, stockMaximo) {
    // Buscar si ya existe en el carrito
    const itemExistente = carrito.find(item => item.id === id);

    if (itemExistente) {
        if (itemExistente.cantidad + 1 > stockMaximo) {
            alert("⚠️ No puedes agregar más items del stock disponible.");
            return;
        }
        itemExistente.cantidad++;
    } else {
        carrito.push({ id, nombre, precio, cantidad: 1, stockMaximo });
    }

    // Actualizar vista del carrito (Offcanvas)
    renderizarCarrito();

    // Abrir el Offcanvas automáticamente para feedback visual (Opcional)
    const offcanvasEl = document.getElementById('carritoOffcanvas');
    const bsOffcanvas = new bootstrap.Offcanvas(offcanvasEl);
    bsOffcanvas.show();
}

function renderizarCarrito() {
    const contenedor = document.getElementById('items-carrito');
    const contador = document.getElementById('contador-carrito');
    const totalEl = document.getElementById('total-carrito');

    contenedor.innerHTML = '';

    let totalPrecio = 0;
    let totalItems = 0;

    if (carrito.length === 0) {
        contenedor.innerHTML = '<div class="text-center mt-5 text-muted"><p>Tu carrito está vacío 🛒</p></div>';
    }

    carrito.forEach((item, index) => {
        const subtotal = item.precio * item.cantidad;
        totalPrecio += subtotal;
        totalItems += item.cantidad;

        contenedor.innerHTML += `
            <div class="card mb-2 border-0 shadow-sm">
                <div class="card-body p-2 d-flex justify-content-between align-items-center">
                    <div style="width: 60%">
                        <h6 class="mb-0 text-truncate">${item.nombre}</h6>
                        <small class="text-muted">$${item.precio} x ${item.cantidad}</small>
                    </div>
                    <div class="text-end">
                        <span class="fw-bold d-block">$${subtotal.toFixed(2)}</span>
                        <button class="btn btn-sm btn-outline-danger py-0" onclick="eliminarDelCarrito(${index})">×</button>
                    </div>
                </div>
            </div>
        `;
    });

    contador.innerText = totalItems;
    totalEl.innerText = `$${totalPrecio.toFixed(2)}`;
}

function eliminarDelCarrito(index) {
    carrito.splice(index, 1);
    renderizarCarrito();
}

async function finalizarCompra() {
    if (carrito.length === 0) {
        alert("El carrito está vacío");
        return;
    }

    // Mapear al formato DTO de Java: ProductoPedidoRequest
    const itemsRequest = carrito.map(item => ({
        productoId: item.id,
        cantidad: item.cantidad
    }));

    try {
        const response = await fetch(ORDER_API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(itemsRequest)
        });

        if (response.ok) {
            const pedido = await response.json();
            alert(`✅ ¡Compra realizada con éxito! \nPedido ID: ${pedido.id}\nTotal: $${pedido.total}`);

            // Limpiar carrito
            carrito = [];
            renderizarCarrito();

            // Cerrar Offcanvas
            const offcanvasEl = document.getElementById('carritoOffcanvas');
            const modalInstance = bootstrap.Offcanvas.getInstance(offcanvasEl);
            if(modalInstance) modalInstance.hide();

            // RECARGAR PRODUCTOS para ver el Stock actualizado desde el Backend
            cargarProductos();

        } else {
            const errorMsg = await response.text();
            alert("❌ Error al procesar la compra: " + errorMsg);
        }
    } catch (error) {
        console.error(error);
        alert("Error de conexión con el servidor");
    }
}

// Exponer funciones globales para el HTML
window.buscarProductos = buscarProductos;
window.limpiarFiltros = limpiarFiltros;
window.guardarProducto = guardarProducto;
window.borrarProducto = borrarProducto;
window.agregarAlCarrito = agregarAlCarrito;
window.eliminarDelCarrito = eliminarDelCarrito;
window.finalizarCompra = finalizarCompra;