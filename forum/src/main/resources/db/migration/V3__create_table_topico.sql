create table topico(
    id bigint not null auto_increment,
    titulo varchar(50),
    mensagem varchar(300),
    data_criacao datetime,
    status varchar(300),
    curso_id bigint,
    autor_id bigint,
    primary key(id),
    foreign key(curso_id) references curso(id),
    foreign key(autor_id) references usuario(id)
);