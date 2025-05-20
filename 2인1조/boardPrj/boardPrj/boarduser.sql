CREATE TABLE board_user_tbl (
  user_id VARCHAR2(20) PRIMARY KEY,
  user_pw VARCHAR2(100) NOT NULL,
  name VARCHAR2(10)
);

INSERT INTO board_user_tbl values('test11', '1234', '이동우');


CREATE TABLE board_tbl (
  board_no NUMBER PRIMARY KEY,
  writer VARCHAR2(20),
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(1000),
  board_pw VARCHAR2(30),
  hit NUMBER DEFAULT 0,
  creat_at DATE DEFAULT SYSDATE,
  CONSTRAINT fk_writer_id FOREIGN KEY (writer) REFERENCES board_user_tbl(user_id)
);

INSERT INTO board_tbl (writer, title, content, board_pw) VALUES ('test11', 'test', 'testttt', 1234);

-- 시퀀스
CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
NOCACHE
NOORDER;

-- 트리거
CREATE OR REPLACE TRIGGER trg_board_tbl
BEFORE INSERT ON board_tbl
FOR EACH ROW
BEGIN
  IF :NEW.board_no IS NULL THEN
    SELECT board_seq.NEXTVAL INTO :NEW.board_no FROM DUAL;
  END IF;
END;


SELECT * FROM board_tbl;
SELECT * FROM board_user_tbl;

DROP TABLE board_tbl;
DROP TABLE board_user_tbl;

DELETE board_tbl;

-- 시퀀스 삭제
DROP SEQUENCE board_seq;


SELECT * FROM user_errors WHERE type = 'TRIGGER' AND name = 'TRG_BOARD_TBL';
DROP TRIGGER trg_board_tbl;
