alter table consertos
    alter column dt_entrada drop not null;

alter table consertos
    alter column dt_saida drop not null;

alter table consertos
    alter column anos_experiencia drop not null;

alter table consertos
    add column cor varchar(30);
