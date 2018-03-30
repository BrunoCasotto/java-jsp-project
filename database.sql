use todo;

INSERT INTO tasks VALUES (5, 2, 'titulo da task', 0);
INSERT INTO tasks VALUES (6, 2, 'titulo da task', 1);
INSERT INTO tasks VALUES (7, 2, 'titulo da task', 0);
INSERT INTO tasks VALUES (8, 2, 'titulo da task', 1);

select * from todo.users;
select * from todo.tasks;

delete from todo.users where id = 4
