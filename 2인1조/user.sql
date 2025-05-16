CREATE TABLE board_user_tbl(
 user_id varchar2(20) ,
 user_pw varchar2(100) NOT NULL,
 name varchar2(10) PRIMARY KEY
);


DROP TABLE board_user_tbl;
--DROP TABLE board_tbl;


INSERT INTO board_user_tbl values('testuser1', '1234', 'test1');
INSERT INTO board_user_tbl values('testuser2', '3334', 'test2');

SELECT * FROM board_user_tbl;

-- 사용자의 id 와 게시글 작성자 조인 (게시글 번호, 이름, 제목, 내용만 출력)
SELECT bt.board_no, bu.name, bt.title, bt.content
FROM board_user_tbl bu
JOIN board_tbl bt
ON bu.user_id = bt.writer;



