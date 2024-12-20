    create table cliente (
        id uuid not null,
        email varchar(255) not null,
        idade integer not null,
        nome varchar(255) not null,
        primary key (id)
    )

    create table conta (
        id uuid not null,
        numero_da_conta integer not null,
        saldo float4 not null,
        situacao smallint not null check (situacao between 0 and 2),
        cliente_id uuid not null,
        primary key (id)
    )

    create table senha (
        id uuid not null,
        senha varchar(255) not null,
        conta_id uuid not null,
        primary key (id)
    )

    create table transacao (
        id uuid not null,
        dataehora timestamp(6) not null,
        tipo smallint not null check (tipo between 0 and 1),
        valor float4 not null,
        conta_id uuid not null,
        primary key (id)
    )

    alter table if exists conta 
       drop constraint if exists UK6t2bvmc5puj41fv34bif1j96f

    alter table if exists conta 
       add constraint UK6t2bvmc5puj41fv34bif1j96f unique (numero_da_conta)

    alter table if exists senha 
       drop constraint if exists UKn0j8gj72w9iark8buyi260mr6

    alter table if exists senha 
       add constraint UKn0j8gj72w9iark8buyi260mr6 unique (conta_id)

    alter table if exists conta 
       add constraint FKfksaesgpmec0cph81iq5or1wn 
       foreign key (cliente_id) 
       references cliente

    alter table if exists senha 
       add constraint FKfb8m070bbon3v3ihj4xr452np 
       foreign key (conta_id) 
       references conta

    alter table if exists transacao 
       add constraint FK6968iodq71yxdsg3ctxmnffv1 
       foreign key (conta_id) 
       references conta
