INSERT INTO estado (id,nombre) values  (1,'Pendiente');
INSERT INTO estado (id,nombre) values  (2,'Pagando');
INSERT INTO estado (id,nombre) values  (3,'Cancelado');


select * from deuda d ;

insert  into deuda (descripcion,valor,estado_id) values('Deuda de prueb',100000,1);
