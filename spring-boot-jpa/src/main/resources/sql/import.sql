-- ADMIN
INSERT INTO ADMIN(id, name, age)
VALUES
(1, 'admin1', 30),
(2, 'admin2', 31),
(3, 'admin3', 32)
;


-- MEMBER
INSERT INTO MEMBER(id, name, age, admin_id)
VALUES
(1, 'member1', 19, 1),
(2, 'member2', 20, 1),
(3, 'member3', 21, 1),
(4, 'member4', 22, 1),
(5, 'member5', 23, 2),
(6, 'member6', 24, 2),
(7, 'member7', 25, 2),
(8, 'member8', 26, 3),
(9, 'member9', 27, 3),
(10, 'member10', 28, 3)
;


-- STUDENT
INSERT INTO STUDENT(id, name, age)
VALUES
(1, 'student1', 1),
(2, 'student2', 2),
(3, 'student3', 3),
(4, 'student4', 4),
(5, 'student5', 5),
(6, 'student6', 6),
(7, 'student7', 7),
(8, 'student8', 8),
(9, 'student9', 9),
(10, 'student10', 10)
;
