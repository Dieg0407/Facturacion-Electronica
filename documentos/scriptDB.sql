drop database facturacion_electronica;

create database facturacion_electronica
	charset utf8 collate utf8_bin;

use facturacion_electronica;

create table empresa (
	ruc char (11),
    nombre varchar (100),
    nombre_comercial varchar (100),
    ubigeo varchar (30),
    direccion varchar (100),
    urbanizacion varchar (50),
    distrito varchar (30),
    provincia varchar (20),
    certificado blob,
    nom_certificado varchar (50),
    pin varchar (25),
    alias varchar (50),
    usuario_secundario varchar (20),
    pass varchar (200),
    email varchar (100),
    web varchar(100)
);

create table telefonos(
	ruc char (11),
    numero varchar(15)
);

create table urls(
	produccion varchar (100),
    guias_remision varchar (100),
    retenciones varchar (100),
    validacion_comprobante varchar(100),
    validacion_constancia varchar(100),
    verificar_boletas boolean
);

create table tipos_documentos(
	tipo_doc varchar(3),
    descripcion varchar (60)
);

create table correlacion (
	tipo_doc varchar(3),
    identificador varchar(8),
    correlativo int
);

create table estados(
	id int,
    descripcion varchar (60)
);

create table rangos(
	id int,
    descripcion varchar (60)
);

create table documentos (
    serie varchar(6) not null,
    numero int not null,
    tipo_doc varchar(3),
    fecha_emision char(8) not null,
    fecha_vencimiento char(8),
    tipo_cliente varchar(4),
    num_cliente varchar(20),
	nom_cliente varchar (100),
    direccion varchar (100),
    distrito varchar (30),
    provincia varchar (20),
    departamento varchar (20),
    email varchar (100),
    venta_afecta numeric (10,2),
    venta_inafecta numeric (10,2),
    venta_exonerada numeric (10,2),
    isc numeric (8,2),
    cod_isc varchar(4),
    igv numeric (8,2),
    cod_igv varchar (4),
    otros_tributos numeric (8,2),
    total numeric (11,2),
    id_estado int,
    id_resumen int unsigned 
);

create table detalles (
    sec int,
    serie varchar(6) not null,
    numero int not null,	
    codigo varchar(20),
    descripcion varchar (100),
    unidad varchar (4),
    valor_unitario numeric (10,2),
    cantidad numeric(10,2),
    isc numeric (8,2),
    cod_isc varchar(4),
    igv numeric (8,2),
    cod_igv varchar (4),
    otros_tributos numeric (8,2),
    total numeric (11,2)
);

create table envios(
	id int unsigned auto_increment primary key,
    serie varchar(6) not null,
    numero int not null,
    serie_electronica varchar(8),
    numero_electronico int,
    fecha_envio char (8),
    archivo blob default null,
    respuesta blob default null,
    activo boolean default false
);

create table resumenes (
	id int unsigned auto_increment primary key,
	fecha_generacion varchar(8) not null,
    tipo_doc varchar(3),
    correlativo int,
    fecha_referencia varchar(8) not null,
    ticket varchar(25),
    archivo blob default null,
    respuesta blob default null
);

create table usuarios(
	id_usuario varchar (10),
    pass varchar (60),
	nombres varchar (200),
	dni char(8),
    rango int
);


alter table empresa
add primary key(ruc);

alter table telefonos
add foreign key (ruc) references empresa (ruc);

alter table tipos_documentos
add primary key(tipo_doc);

alter table correlacion
add foreign key (tipo_doc) references tipos_documentos (tipo_doc);

alter table estados
add primary key (id);

alter table rangos
add primary key (id);

alter table documentos
add primary key(serie,numero);

alter table documentos
add foreign key (tipo_doc) references tipos_documentos (tipo_doc);

alter table documentos
add foreign key (id_estado) references estados (id);

alter table documentos
add foreign key (id_resumen) references resumenes(id);


alter table detalles
add foreign key (serie,numero) references documentos(serie,numero);

alter table detalles
add primary key(serie,numero,sec);

alter table usuarios
add primary key (id_usuario);